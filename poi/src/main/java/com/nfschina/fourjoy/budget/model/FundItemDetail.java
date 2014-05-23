package com.nfschina.fourjoy.budget.model;

import java.util.List;

/**
 * 经费类别的明细
 * 
 * @author songjz
 * @version 1.0, 2014年4月26日
 */
public class FundItemDetail {

	/**
	 * 名称
	 */
	protected String name;

	/**
	 * 单价
	 */
	protected Double unitPrice;

	/**
	 * 数量
	 */
	protected Integer amount;

	/**
	 * 总价(单价 * 数量)
	 */
	protected Double totalPrice;

	/**
	 * 描述
	 */
	protected String description;

	/**
	 * 明细扩展（除了主字段，额外的字段）
	 */
	private List<FundItemDetailExtension> detailExtensions;

	/**
	 * 重新设置总价
	 * 
	 * @author songjz 2014年5月2日
	 */
	public void resetTotalPrice() {
		Double total = null;
		if (unitPrice != null && amount != null) {
			total = unitPrice * amount / 10000;
		}
		setTotalPrice(total);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<FundItemDetailExtension> getDetailExtensions() {
		return detailExtensions;
	}

	public void setDetailExtensions(List<FundItemDetailExtension> detailExtensions) {
		this.detailExtensions = detailExtensions;
	}
}
