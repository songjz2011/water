package com.web.things.db.print;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTHeight;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTcPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTrPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;

import com.web.things.db.operate.OracleOperate;
import com.web.things.db.operate.TableColumnMeta;
import com.web.things.db.operate.TableMeta;
import com.web.things.db.util.TableColumnMetaUtil;
import com.web.things.util.LoggerUtil;
import com.web.things.util.StringUtil;

public class DBPrintWord implements DBPrint {

	/**
	 * 字体大小
	 */
	private final int FONT_SIZE = 12;

	/**
	 * 表格行高
	 */
	private final int ROW_HEIGHT = 360;

	/**
	 * 表格头
	 */
	private List<String> fieldTitleList;

	public DBPrintWord() {
		init();
	}

	private void init() {
		fieldTitleList = new LinkedList<String>();
		fieldTitleList.add("字段名");
		fieldTitleList.add("数据类型");
		fieldTitleList.add("是否可为空");
		fieldTitleList.add("注释");
	}

	public void print(List<TableMeta> tableMetaList) {
		try {
			XWPFDocument doc = new XWPFDocument();
			for (TableMeta tableMeta : tableMetaList) {
				writeDBTableContent(tableMeta, doc);
				writeDBTableFieldContent(tableMeta, doc);
				writeNewLine(doc);
			}
			FileOutputStream out = new FileOutputStream("数据表.docx");
			doc.write(out);
			out.close();
		} catch (Exception e) {
			LoggerUtil.error(getClass(), e);
		}
	}

	/**
	 * 写入表的信息
	 * 
	 * @param tableMeta
	 * @param doc
	 */
	private void writeDBTableContent(TableMeta tableMeta, XWPFDocument doc) {
		String text = tableMeta.getName();
		if (!StringUtil.isEmpty(tableMeta.getRemark())) {
			text += " (" + tableMeta.getRemark() + ") ";
		}
		XWPFParagraph p1 = doc.createParagraph();
		XWPFRun run = p1.createRun();
		run.setText(text);
		run.setFontSize(FONT_SIZE);
	}

	/**
	 * 写入表字段信息
	 * 
	 * @param tableMeta
	 * @param doc
	 */
	private void writeDBTableFieldContent(TableMeta tableMeta, XWPFDocument doc) {
		List<TableColumnMeta> columnMetaList = tableMeta.getColumnList();
		if (columnMetaList == null || columnMetaList.isEmpty()) {
			return;
		}
		TableColumnMetaUtil.sortByName(columnMetaList);

		int rows = columnMetaList.size() + 1;
		XWPFTable table = doc.createTable(rows, fieldTitleList.size());
		setDBTableStyle(table);
		List<XWPFTableRow> tableRowList = table.getRows();
		// 设置表头
		setDBTableCell(tableRowList.get(0), fieldTitleList, true);
		// 设置表内容
		for (int i = 1; i < tableRowList.size(); i++) {
			TableColumnMeta columnMeta = columnMetaList.get(i - 1);
			List<String> contentList = getColumnMetaContents(columnMeta);
			setDBTableCell(tableRowList.get(i), contentList, false);
		}
	}

	/**
	 * 设置表格的样式
	 * 
	 * @param table
	 */
	private void setDBTableStyle(XWPFTable table) {
		// 设置表格的宽度
		CTTblPr tblPr = table.getCTTbl().getTblPr();
		tblPr.getTblW().setType(STTblWidth.DXA);
		// tblPr.getTblW().setW(new BigInteger("7000"));

		// 注：如果不设置风格，将采用默认的Normal风格
		// 其他风格：StyledTable
		// CTString styleStr = tblPr.addNewTblStyle();
		// styleStr.setVal("Normal");

	}

	/**
	 * 表格列的内容
	 * 
	 * @param columnMeta
	 * @return
	 */
	private List<String> getColumnMetaContents(TableColumnMeta columnMeta) {
		List<String> result = new LinkedList<String>();
		result.add(columnMeta.getName());
		String type = columnMeta.getType();
		String size = columnMeta.getSize();
		if (!StringUtil.isEmpty(columnMeta.getSize())) {
			type += "(" + size + ")";
		}
		result.add(type);
		result.add(StringUtil.trim(columnMeta.getNullFlag()));
		result.add(StringUtil.trim(columnMeta.getRemark()));
		return result;
	}

	/**
	 * 设置表格的单元格
	 * 
	 * @param tableRow
	 *            ：表格的行
	 * @param contents
	 *            ：表格的内容
	 * @param isBold
	 *            ：字体是否加粗
	 */
	private void setDBTableCell(XWPFTableRow tableRow, List<String> contents, boolean isBold) {
		setDBTableRowStyle(tableRow);
		List<XWPFTableCell> cells = tableRow.getTableCells();
		for (int i = 0; i < cells.size(); i++) {
			if (i >= contents.size()) {
				break;
			}
			int cellWidth = 2000;
			if (i == cells.size() - 2) {
				cellWidth = 1500;
			}
			if (i == cells.size() - 1) {
				cellWidth = 2500;
			}
			XWPFTableCell cell = cells.get(i);
			setDBTableCellStyle(cell, cellWidth);
			setDBTableCellContent(cell, contents.get(i), isBold);
		}
	}

	/**
	 * 设置表格行的样式
	 * 
	 * @param tableRow
	 */
	private void setDBTableRowStyle(XWPFTableRow tableRow) {
		CTTrPr trPr = tableRow.getCtRow().addNewTrPr();
		CTHeight ht = trPr.addNewTrHeight();
		// ht.setVal(BigInteger.valueOf(360));
		// 设置行高
		ht.setVal(BigInteger.valueOf(ROW_HEIGHT));
	}

	/**
	 * 设置表格-单元格的样式
	 * 
	 * @param cell
	 */
	private void setDBTableCellStyle(XWPFTableCell cell, int cellWidth) {
		CTTcPr tcpr = cell.getCTTc().addNewTcPr();
		// 设置垂直居中
		CTVerticalJc va = tcpr.addNewVAlign();
		va.setVal(STVerticalJc.CENTER);
		// 单元格宽度
		CTTblWidth cellw = tcpr.addNewTcW();
		cellw.setType(STTblWidth.DXA);
		cellw.setW(BigInteger.valueOf(cellWidth));
	}

	/**
	 * 设置表格-单元格内容
	 * 
	 * @param cell
	 * @param content
	 */
	private void setDBTableCellContent(XWPFTableCell cell, String content, boolean isBold) {
		XWPFParagraph para = cell.getParagraphs().get(0);
		XWPFRun rh = para.createRun();
		rh.setFontSize(FONT_SIZE);
		rh.setText(content);
		rh.setBold(isBold);
	}

	/**
	 * 写入空行
	 * 
	 * @param doc
	 */
	private void writeNewLine(XWPFDocument doc) {
		XWPFParagraph p1 = doc.createParagraph();
		XWPFRun run = p1.createRun();
		run.setText(StringUtil.getNewLine());
		run.setFontSize(FONT_SIZE);
	}

	public static void main(String[] args) {
		OracleOperate oracleOperate = new OracleOperate();
		List<TableMeta> list = new LinkedList<TableMeta>();
		// list.add(oracleOperate.getTableMeta("ST_STATION_ACTLC"));
		list.addAll(oracleOperate.getAllTableMeta());
		new DBPrintWord().print(list);
	}

}
