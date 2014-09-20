package com.rongxintx.uranus.utils.profession;

import java.util.ArrayList;
import java.util.List;

/**
 * 订单借款人职业类型
 * 
 * @author jzsong@rongxintx.com
 */
public class OrderBorrowerProfessionType {
  /**
   * 职业类型ID
   */
  public String id;

  /**
   * 职业类型名称
   */
  public String name;

  /**
   * 职业类型包含的职业
   */
  public List<OrderBorrowerProfession> partnerProfessions = new ArrayList<OrderBorrowerProfession>();;

  public OrderBorrowerProfessionType() {

  }

  public OrderBorrowerProfessionType(String id, String name) {
    this.id = id;
    this.name = name;
  }
}
