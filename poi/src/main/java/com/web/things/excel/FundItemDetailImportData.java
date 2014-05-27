package com.web.things.excel;

import java.io.InputStream;
import java.util.List;

import com.nfschina.fourjoy.budget.model.FundItemDetailField;

/**
 * 资产导入 所需数据
 * 
 * @author songjz
 * @version 1.0, 2014年5月24日
 */
public class FundItemDetailImportData {

    /**
     * 界面输入流
     */
    private InputStream inputStream;

    /**
     * 所有经费类别的明细--字段
     */
    private List<FundItemDetailField> fieldList;

    /**
     * 租户ID
     */
    private Long lesseeId;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public List<FundItemDetailField> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<FundItemDetailField> fieldList) {
        this.fieldList = fieldList;
    }

    public Long getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(Long lesseeId) {
        this.lesseeId = lesseeId;
    }

}
