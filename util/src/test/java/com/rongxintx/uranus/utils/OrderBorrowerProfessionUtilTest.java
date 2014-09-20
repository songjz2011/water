package com.rongxintx.uranus.utils;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.rongxintx.uranus.utils.profession.OrderBorrowerProfession;
import com.rongxintx.uranus.utils.profession.OrderBorrowerProfessionType;
import com.rongxintx.uranus.utils.profession.OrderBorrowerProfessionUtil;

/**
 * 订单借款人职业工具类单测
 * 
 * @author jzsong@rongxintx.com
 */
public class OrderBorrowerProfessionUtilTest extends TestCase {
  @Test
  public void testProfession() {
    List<OrderBorrowerProfessionType> types = OrderBorrowerProfessionUtil
        .getALLOrderBorrowerProfessionTypes();
    assertTrue(types.size() > 0);
    for (OrderBorrowerProfessionType type : types) {
      if ("02".equals(type.id)) {
        assertEquals(type.name, "金融业");
      }

      if ("04".equals(type.id)) {
        assertEquals(type.name, "商业服务");
        assertTrue(type.partnerProfessions.size() > 0);
        for (OrderBorrowerProfession profession : type.partnerProfessions) {
          if ("0403".equals(profession.id)) {
            assertEquals(profession.name, "中介服务");
          }
        }
      }
    }
  }
}
