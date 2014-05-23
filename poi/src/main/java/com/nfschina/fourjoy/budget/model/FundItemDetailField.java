package com.nfschina.fourjoy.budget.model;


/**
 * 经费类别的明细--字段
 * 
 * @author songjz
 * @version 1.0, 2014年4月26日
 */
public class FundItemDetailField {

    /**
     * 字段显示的名称
     */
    private String label;

    /**
     * 字段（所在表单中的名称，例如：input type=text name=name）
     */
    private String name;

    /**
     * html的类型
     */
    private CustomFieldHtmlType htmlType = CustomFieldHtmlType.TEXT;

    /**
     * 用于区分 经费类别的明细 的类型
     */
    private FundItemDetailType detailType;

    /**
     * 排序位置
     */
    private int position;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomFieldHtmlType getHtmlType() {
        return htmlType;
    }

    public void setHtmlType(CustomFieldHtmlType htmlType) {
        this.htmlType = htmlType;
    }

    public FundItemDetailType getDetailType() {
        return detailType;
    }

    public void setDetailType(FundItemDetailType detailType) {
        this.detailType = detailType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

}
