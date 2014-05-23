package com.nfschina.fourjoy.budget.model;

/**
 * 经费类别的明细 类别
 * 
 * @author songjz
 * @version 1.0, 2014年4月26日
 */
public enum FundItemDetailType {

    EQUIPMENT("设备", 0);

    private String name;

    private int index;

    private FundItemDetailType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index) {
        for (FundItemDetailType type : FundItemDetailType.values()) {
            if (type.getIndex() == index) {
                return type.name;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
}
