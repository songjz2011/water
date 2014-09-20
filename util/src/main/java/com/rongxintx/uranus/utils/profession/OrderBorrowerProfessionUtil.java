package com.rongxintx.uranus.utils.profession;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.web.things.util.FileUtil;

/**
 * 订单借款人职业工具类
 *
 * @author jzsong@rongxintx.com
 */
public class OrderBorrowerProfessionUtil {
  private static final String filePath = "orderBorrowerProfession.json";
  private static final List<OrderBorrowerProfessionType> orderBorrowerProfessionTypes = new ArrayList<OrderBorrowerProfessionType>();
  private static final List<OrderBorrowerProfession> orderBorrowerProfessions = new ArrayList<OrderBorrowerProfession>();
  static {
    if (orderBorrowerProfessionTypes.isEmpty()) {
      initData();
    }
  }

  /**
   * <pre>
   * 获取所有的职业类型
   * </pre>
   * 
   * @return
   */
  public static List<OrderBorrowerProfessionType> getALLOrderBorrowerProfessionTypes() {
    if (orderBorrowerProfessionTypes.isEmpty()) {
      initData();
    }
    return orderBorrowerProfessionTypes;
  }

  /**
   * <pre>
   * 获取所有的职业类型
   * </pre>
   * 
   * @return
   */
  public static List<OrderBorrowerProfession> getALLOrderBorrowerProfessions() {
    if (orderBorrowerProfessions.isEmpty()) {
      initData();
    }
    return orderBorrowerProfessions;
  }

  /**
   * <pre>
   * 初始化合作伙伴职业数据
   * </pre>
   */
  private static void initData() {
    if (!orderBorrowerProfessionTypes.isEmpty()) {
      return;
    }
    String path = Thread.currentThread().getContextClassLoader().getResource(filePath)
        .getPath();
    String json = FileUtil.readContent(new File(path));
    List<JSONObject> list = JSONArray.parseArray(json, JSONObject.class);
    for (JSONObject obj : list) {
      OrderBorrowerProfessionType type = new OrderBorrowerProfessionType(obj.getString("id"),
          obj.getString("name"));
      JSONArray jsonArray = obj.getJSONArray("children");
      for (int i = 0; i < jsonArray.size(); i++) {
        JSONObject child = jsonArray.getJSONObject(i);
        OrderBorrowerProfession profession = new OrderBorrowerProfession(child.getString("id"),
            child.getString("name"));
        type.partnerProfessions.add(profession);

        orderBorrowerProfessions.add(profession);
      }
      orderBorrowerProfessionTypes.add(type);
    }
  }

}
