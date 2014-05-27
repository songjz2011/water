package com.web.things.excel;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import com.nfschina.fourjoy.budget.model.FundItemDetail;
import com.nfschina.fourjoy.budget.model.FundItemDetailExtension;
import com.nfschina.fourjoy.budget.model.FundItemDetailField;
import com.nfschina.fourjoy.budget.model.FundItemDetailType;
import com.nfschina.fourjoy.util.POIUtil;

/**
 * 资产导入
 * 
 * @author songjz
 * @version 1.0, 2014年5月24日
 */
public class FundItemDetailImportManager {
    
    public List<FundItemDetail> buildDetailsByImportFile(FundItemDetailImportData data) throws RuntimeException {
        validateData(data);
        POIFSFileSystem fs = null;
        HSSFWorkbook wb = null;
        try {
            fs = new POIFSFileSystem(data.getInputStream());
            wb = new HSSFWorkbook(fs);
        } catch (IOException e) {
            throw new RuntimeException("读取文件出错");
        }
        List<FundItemDetailExcel> list = new ArrayList<FundItemDetailExcel>(2);
        list.add(EquimpmentExcel.NAME);
        list.add(BooksExcel.NAME);
        return buildDetailList(list, wb, data);
    }

    /**
     * 验证数据
     * 
     * @author songjz 2014年5月24日
     */
    private void validateData(FundItemDetailImportData data) {
        String message = "";
        if (data.getInputStream() == null) {
            message = "上传的数据不能为空";
        }
        if (message != "") {
            throw new RuntimeException(message);
        }
    }

    private List<FundItemDetail> buildDetailList(List<FundItemDetailExcel> excelList, HSSFWorkbook wb,
            FundItemDetailImportData data) {
        List<FundItemDetail> result = new ArrayList<FundItemDetail>();
        for (FundItemDetailExcel excel : excelList) {
            int sheetIndex = excel.sheetNum();
            int contentStartRow = excel.contentStartRow();
            HSSFSheet sheet = wb.getSheetAt(sheetIndex);
            int totalRow = sheet.getLastRowNum();
            for (int i = contentStartRow; i <= totalRow; i++) {
                HSSFRow row = sheet.getRow(i);
                String value = POIUtil.getCellValue(row, 0);
                FundItemDetail detail = new FundItemDetail();
                setNecessaryFieldValue(detail, excel, row);
                setExpendFieldValue(detail, excel, row, data.getFieldList());
                result.add(detail);
            }
        }
        return result;
    }

    private void setNecessaryFieldValue(FundItemDetail detail, FundItemDetailExcel excel, HSSFRow row) {
        List<FundItemDetailExcelFiled> fieldList = excel.getNecessary();
        for (FundItemDetailExcelFiled field : fieldList) {
            String filedName = field.getFiledName();
            int col = field.getColIndex();
            String value = POIUtil.getCellValue(row, col);
            Method[] methods = FundItemDetail.class.getDeclaredMethods();
            for (Method method : methods) {
                String methodName = method.getName();
                if (!methodName.startsWith("set")) {
                    continue;
                }
                methodName = methodName.replaceFirst("set", "");
                if (!methodName.equalsIgnoreCase(filedName)) {
                    continue;
                }
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes == null || parameterTypes.length != 1) {
                    continue;
                }
                String parameterTypeName = parameterTypes[0].getSimpleName();
                Object obj = value;
                if ("Integer".equals(parameterTypeName)) {
                    obj = Integer.valueOf(value);
                } else if ("Double".equals(parameterTypeName)) {
                    obj = Double.valueOf(value);
                } else if ("Date".equals(parameterTypeName)) {
                    try {
                        SimpleDateFormat dateFormat = new SimpleDateFormat(field.getDatePattern());
                        Date date = dateFormat.parse(value);
                        obj = date;
                    } catch (ParseException e) {
                        throw new RuntimeException("日期格式不正确");
                    }
                }
                try {
                    method.invoke(detail, obj);
                } catch (Exception e) {
                    throw new RuntimeException("设置 " + detail.getDetailType().getName() + " 出错");
                }
                break;
            }
        }
    }

    private void setExpendFieldValue(FundItemDetail detail, FundItemDetailExcel excel, HSSFRow row,
            List<FundItemDetailField> fieldList) {
        List<FundItemDetailExtension> list = new ArrayList<FundItemDetailExtension>();
        List<FundItemDetailExcelFiled> expendFiledList = excel.getExpend();
        for (FundItemDetailExcelFiled expendField : expendFiledList) {
            FundItemDetailField field = findDetailField(detail.getDetailType(), expendField.getFiledName(), fieldList);
            int col = expendField.getColIndex();
            String value = POIUtil.getCellValue(row, col);
            FundItemDetailExtension extension = new FundItemDetailExtension();
            extension.setDetailField(field);
            extension.setFieldContent(value);
            list.add(extension);
        }
        detail.setDetailExtensions(list);
    }

    private FundItemDetailField findDetailField(FundItemDetailType type, String name,
            List<FundItemDetailField> fieldList) {
        FundItemDetailField result = null;
        for (FundItemDetailField field : fieldList) {
            if (type.getIndex() != field.getDetailType().getIndex()) {
                continue;
            }
            if (!field.getName().equals(name)) {
                continue;
            }
            result = field;
            break;
        }
        return result;
    }

    private interface FundItemDetailExcel {
        /** 表格内容的开始行 （索引从0开始） */
        int contentStartRow();

        /** 资产类型所在的sheet页（索引从0开始） */
        int sheetNum();

        /** 资产类型 */
        FundItemDetailType getDetailType();

        /** 必备字段 */
        List<FundItemDetailExcelFiled> getNecessary();

        /** 扩展字段 */
        List<FundItemDetailExcelFiled> getExpend();
    }

    private interface FundItemDetailExcelFiled {
        /** 定义了 字段 在excel中的列索引 */
        int getColIndex();

        /** 字段类型名称 */
        String getFiledName();

        /** 日期格式，若是日期格式，此字段则会用到 */
        String getDatePattern();

        /** 字段类型，是 必备字段，还是扩展字段 */
        String getFiledType();
    }

    enum EquimpmentExcel implements FundItemDetailExcel, FundItemDetailExcelFiled {
        NAME(1, "name", "设备名称", "necessary", "yyyy.MM.dd"), MODEL(2, "equipment_model", "品牌/型号", "expend", "yyyy.MM.dd"), AMOUNT(
                3, "amount", "数量", "necessary", "yyyy.MM.dd"), UNITPRICE(4, "unitPrice", "购置单价（元）", "necessary",
                "yyyy.MM.dd"), TOTALPRICE(5, "totalPrice", "金额", "necessary", "yyyy.MM.dd"), PROVIDINGUNIT(6,
                "equipment_provide_department", "供应单位名称", "expend", "yyyy.MM.dd"), REGISTERCARD(7,
                "equipment_register_card", "登记卡号", "expend", "yyyy.MM.dd"), PURCHASETIME(8, "purchaseTime", "购置时间",
                "necessary", "yyyy.MM.dd"), PURCHASEWAY(9, "equipment_procurement_method", "采购方式", "expend",
                "yyyy.MM.dd"), STATUS(10, "equipment_status", "设备状态", "expend", "yyyy.MM.dd"), DESCRIPTION(11,
                "description", "备注", "necessary", "yyyy.MM.dd");
        /** 定义了 设备字段 在excel中的列索引 */
        private int colIndex;
        /** 字段（所在表单中的名称，例如：input type=text name=name） */
        private String filedName;
        /** 字段显示的名称 */
        private String filedLabel;
        /** 字段类型，是 必备字段，还是扩展字段 */
        private String filedType;
        /** 日期格式，若是日期格式，此字段则会用到 */
        private String datePattern;

        private EquimpmentExcel(int colIndex, String filedName, String filedLabel, String filedType, String datePattern) {
            this.colIndex = colIndex;
            this.filedName = filedName;
            this.filedLabel = filedLabel;
            this.filedType = filedType;
            this.datePattern = datePattern;
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

        public String getDatePattern() {
            return datePattern;
        }
    }

    enum BooksExcel implements FundItemDetailExcel, FundItemDetailExcelFiled {
        NAME(1, "name", "名称", "necessary", ""), 
        AUTHOR(2, "book_author", "责任者", "expend", ""), 
        PUBLISHER(3, "book_publisher", "出版单位/收藏单位", "expend", ""),
        UNITPRICE(4, "unitPrice", "购置单价（元）", "necessary", ""),
        AMOUNT(5, "amount", "数量", "necessary", ""), 
        PURCHASETIME(6, "purchaseTime", "购置时间", "necessary", "yyyy.MM"),
        PROCUREMENTMETHOD(7,"book_procurement_method", "采购方式", "expend", ""),
        PROCUREMENTOBJECT(8,"book_procurement_object", "采购对象", "expend", ""),
        TOTALPRICE(9, "totalPrice", "小计（元）", "necessary", "");
        /** 定义了 设备字段 在excel中的列索引 */
        private int colIndex;
        /** 字段（所在表单中的名称，例如：input type=text name=name） */
        private String filedName;
        /** 字段显示的名称 */
        private String filedLabel;
        /** 字段类型，是 必备字段，还是扩展字段 */
        private String filedType;
        /** 日期格式，若是日期格式，此字段则会用到 */
        private String datePattern;

        private BooksExcel(int colIndex, String filedName, String filedLabel, String filedType, String datePattern) {
            this.colIndex = colIndex;
            this.filedName = filedName;
            this.filedLabel = filedLabel;
            this.filedType = filedType;
            this.datePattern = datePattern;
        }

        public List<FundItemDetailExcelFiled> getNecessary() {
            List<FundItemDetailExcelFiled> list = new LinkedList<FundItemDetailExcelFiled>();
            for (BooksExcel excel : BooksExcel.values()) {
                if (excel.filedType.equals("necessary")) {
                    list.add(excel);
                }
            }
            return list;
        }

        public List<FundItemDetailExcelFiled> getExpend() {
            List<FundItemDetailExcelFiled> list = new LinkedList<FundItemDetailExcelFiled>();
            for (BooksExcel excel : BooksExcel.values()) {
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
            return 1;
        }

        public FundItemDetailType getDetailType() {
            return FundItemDetailType.BOOKS;
        }

        public String getDatePattern() {
            return datePattern;
        }
    }
}
