package com.tsingsoft.android.entity;

/**
 * <pre>
 * 相关因素映射库信息
 * </pre>
 * 
 * @author songjz
 * @time 2014年2月26日
 */
public class StFactorMaplib {
	/**
	 * 相关因素ID
	 */
	private String factorId;

	/**
	 * 映射前值
	 */
	private Double beforeValue;

	/**
	 * 中文名称
	 */
	private String itemName;

	public String getFactorId() {
		return factorId;
	}

	public void setFactorId(String factorId) {
		this.factorId = factorId;
	}

	public Double getBeforeValue() {
		return beforeValue;
	}

	public void setBeforeValue(Double beforeValue) {
		this.beforeValue = beforeValue;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
