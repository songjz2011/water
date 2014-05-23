package com.nfschina.fourjoy.budget.model;


/**
 * 经费类别的 明细扩展（除了主字段，额外的字段）
 * 
 * @author songjz
 * @version 1.0, 2014年4月26日
 */
public class FundItemDetailExtension {

    /**
     * 扩展字段值的内容
     */
    protected String fieldContent;

    /**
     * 关联的 经费类别的明细--字段
     */
    protected FundItemDetailField detailField;

    public String getFieldContent() {
        return fieldContent;
    }

    public void setFieldContent(String fieldContent) {
        this.fieldContent = fieldContent;
    }

    public FundItemDetailField getDetailField() {
        return detailField;
    }

    public void setDetailField(FundItemDetailField detailField) {
        this.detailField = detailField;
    }

}
