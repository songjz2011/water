package com.web.things.db.operate;

/**
 * <pre>
 * 数据库表的列信息对象
 * </pre>
 * 
 * @author songjz
 * @time 2013年10月29日
 */
public class TableColumnMeta {

	/**
	 * 列名称
	 */
	private String name;

	/**
	 * 列注释
	 */
	private String remark;

	/**
	 * 列数据类型
	 */
	private String type;

	/**
	 * 列数据大小
	 */
	private String size;

	/**
	 * 列是否允许为空标志，"NO"不可以，“YES”or空 可以
	 */
	private String nullFlag;

	/**
	 * 所属table的名称
	 */
	private String tableName;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getNullFlag() {
		return nullFlag;
	}

	public void setNullFlag(String nullFlag) {
		this.nullFlag = nullFlag;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
