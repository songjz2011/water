package com.web.things.db.print;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.web.things.db.operate.OracleOperate;
import com.web.things.db.operate.TableColumnMeta;
import com.web.things.db.operate.TableMeta;
import com.web.things.util.LoggerUtil;
import com.web.things.util.StringUtil;

public class DBPrintWord implements DBPrint {

	private final int FONT_SIZE = 12;

	private final String[] FIELD_TITLE = new String[] { "字段名", "数据类型", "是否可为空", "注释" };

	public void print(List<TableMeta> tableMetaList) {
		try {
			XWPFDocument doc = new XWPFDocument();
			for (TableMeta tableMeta : tableMetaList) {
				writeDBTableContent(tableMeta, doc);
				writeDBTableFieldContent(tableMeta, doc);
				writeNewLine(doc);
			}

			FileOutputStream out = new FileOutputStream("simple.docx");
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
		List<TableColumnMeta> columnMeta = tableMeta.getColumnList();
		if (columnMeta == null || columnMeta.isEmpty()) {
			return;
		}
		int rows = columnMeta.size() + 1;
		XWPFTable table = doc.createTable(rows, FIELD_TITLE.length);
	}

	/**
	 * 设置表字段信息的表头
	 * 
	 * @param table
	 */
	private void setDBTableFieldHead(XWPFTable table) {
		XWPFTableRow row = table.getRows().get(0);
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
		new DBPrintWord().print(oracleOperate.getAllTableMeta());
	}

}
