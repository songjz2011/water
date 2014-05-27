package com.nfschina.fourjoy.budget.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 经费类别的明细
 * 
 * @author songjz
 * @version 1.0, 2014年4月26日
 */
public class FundItemDetail implements Serializable {

	private static final long serialVersionUID = -8214692705181713329L;

	/**
	 * 经费类别的明细-类型
	 */
	private FundItemDetailType detailType;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 单价
	 */
	private Double unitPrice;

	/**
	 * 数量
	 */
	private Integer amount;

	/**
	 * 总价(单价 * 数量)
	 */
	private Double totalPrice;

	/**
	 * 描述
	 */
	private String description;

	/**
	 * 购置日期
	 */
	private Date purchaseTime;

	/**
	 * 填写日期
	 */
	private Date fillTime;

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
			total = unitPrice * amount;
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

	public FundItemDetailType getDetailType() {
		return detailType;
	}

	public void setDetailType(FundItemDetailType detailType) {
		this.detailType = detailType;
	}

	public List<FundItemDetailExtension> getDetailExtensions() {
		return detailExtensions;
	}

	public void setDetailExtensions(List<FundItemDetailExtension> detailExtensions) {
		this.detailExtensions = detailExtensions;
	}

	public Date getPurchaseTime() {
		return purchaseTime;
	}

	public void setPurchaseTime(Date purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public Date getFillTime() {
		return fillTime;
	}

	public void setFillTime(Date fillTime) {
		this.fillTime = fillTime;
	}

}
