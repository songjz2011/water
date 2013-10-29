package com.web.things.db.operate;

import java.util.List;

/**
 * <pre>
 * 数据库表信息对象
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月29日
 */
public class TableMeta {

	/**
	 * 表名称
	 */
	private String name;

	/**
	 * 表注释
	 */
	private String remark;
	
	/**
	 * 类型（TABLE、等） 
	 */
	private String type;

	/**
	 * 表的列
	 */
	private List<TableColumnMeta> columnList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public List<TableColumnMeta> getColumnList() {
		return columnList;
	}

	public void setColumnList(List<TableColumnMeta> columnList) {
		this.columnList = columnList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
