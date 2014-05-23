package com.web.things.excel;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.nfschina.fourjoy.budget.model.FundItemDetail;
import com.nfschina.fourjoy.budget.model.FundItemDetailField;
import com.nfschina.fourjoy.budget.model.FundItemDetailType;
import com.nfschina.fourjoy.util.POIUtil;

/**
 * <pre>
 * 读取Excel的manager
 * excel 行从1开始，列从0开始，真够损的
 * </pre>
 */
public class ExcelFileManager {

	public void read() {
		String filePath = ExcelFileRead.class.getResource("aa.xls").getPath();
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(filePath);
			POIFSFileSystem fs = new POIFSFileSystem(inputStream);
			HSSFWorkbook wb = new HSSFWorkbook(fs);
			buildDetailList(EquimpmentExcel, wb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List<FundItemDetail> buildDetailList(FundItemDetailExcel excel, HSSFWorkbook wb) {
		int sheetIndex = excel.sheetNum();
		int contentStartRow = excel.contentStartRow();
		HSSFSheet sheet = wb.getSheetAt(sheetIndex);
		int totalRow = sheet.getLastRowNum();
		List<FundItemDetail> result = new ArrayList<FundItemDetail>();
		for (int i = contentStartRow; i <= totalRow; i++) {
			FundItemDetail detail = new FundItemDetail();

			result.add(detail);
		}
		return result;
	}

	private List<FundItemDetailField> detailFieldList(FundItemDetailType type) {
		List<FundItemDetailField> list = new ArrayList<FundItemDetailField>();

		return list;
	}

	public static void main(String[] args) {
		new ExcelFileManager().read();
	}

	private interface FundItemDetailExcel {
		/** 表格内容的开始行 （索引从0开始） */
		int contentStartRow();

		/** 资产类型所在的sheet页（索引从0开始） */
		int sheetNum();

		/** 资产类型 */
		FundItemDetailType getDetailType();

	}

	private interface FundItemDetailExcelFiled {
		/** 定义了 字段 在excel中的列索引 */
		int getColIndex();

		/** 字段类型名称 */
		String getFiledName();

		/** 字段类型，是 必备字段，还是扩展字段 */
		String getFiledType();

		/** 必备字段 */
		List<FundItemDetailExcelFiled> getNecessary();

		/** 扩展字段 */
		List<FundItemDetailExcelFiled> getExpend();
	}

	enum EquimpmentExcel implements FundItemDetailExcel, FundItemDetailExcelFiled {
		NAME(1, "name", "设备名称", "necessary"), MODEL(2, "", "品牌/型号", "expend"), AMOUNT(3, "amount",
				"数量", "necessary"), UNITPRICE(4, "unitPrice", "购置单价（元）", "necessary"), TOTALPRICE(
				5, "totalPrice", "金额", "necessary"), PROVIDINGUNIT(6, "", "供应单位名称", "expend"), REGISTERCARD(
				7, "", "登记卡号", "expend"), PURCHASETIME(8, "purchaseTime", "购置时间", "necessary"), PURCHASEWAY(
				9, "", "采购方式", "expend"), STATUS(10, "", "设备状态", "expend"), DESCRIPTION(11,
				"description", "备注", "necessary");
		/** 定义了 设备字段 在excel中的列索引 */
		private int colIndex;
		/** 字段（所在表单中的名称，例如：input type=text name=name） */
		private String filedName;
		/** 字段显示的名称 */
		private String filedLabel;
		/** 字段类型，是 必备字段，还是扩展字段 */
		private String filedType;

		private EquimpmentExcel(int colIndex, String filedName, String filedLabel, String filedType) {
			this.colIndex = colIndex;
			this.filedName = filedName;
			this.filedLabel = filedLabel;
			this.filedType = filedType;
		}

		public List<FundItemDetailExcelFiled> getNecessary() {
			List<FundItemDetailExcelFiled> list = new LinkedList<FundItemDetailExcelFiled>();
			for (EquimpmentExcel excel : EquimpmentExcel.values()) {
				if (excel.filedType.equals("necessary")) {
					list.add(excel);
				}
			}
			return list;
		}

		public List<FundItemDetailExcelFiled> getExpend() {
			List<FundItemDetailExcelFiled> list = new LinkedList<FundItemDetailExcelFiled>();
			for (EquimpmentExcel excel : EquimpmentExcel.values()) {
				if (excel.filedType.equals("expend")) {
					list.add(excel);
				}
			}
			return list;
		}

		public int getColIndex() {
			return colIndex;
		}

		public String getFiledName() {
			return filedName;
		}

		public String getFiledLabel() {
			return filedLabel;
		}

		public String getFiledType() {
			return filedType;
		}

		public int contentStartRow() {
			return 7;
		}

		public int sheetNum() {
			return 0;
		}

		public FundItemDetailType getDetailType() {
			return FundItemDetailType.EQUIPMENT;
		}
	}

}
