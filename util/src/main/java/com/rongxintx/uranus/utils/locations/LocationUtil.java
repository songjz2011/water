package com.rongxintx.uranus.utils.locations;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.web.things.util.FileUtil;

/**
 * 地理位置工具类.
 * 
 * @author royguo@rongxintx.com
 */
public class LocationUtil {
  private static final String filePath = "/cities.json";
  private static final List<Province> provinces = new ArrayList<Province>(50);
  private static final List<City> cities = new ArrayList<City>();

  // JSON直接映射的对象.
  private static List<Item> items = new ArrayList<Item>();

  static {
    if (provinces.isEmpty()) {
      initData();
    }
  }

  /**
   * 获得所有的省信息.
   * 
   * @return
   */
  public static List<Province> getAllProvinces() {
    if (provinces.isEmpty()) {
      initData();
    }
    return provinces;
  }

  /**
   * 根据城市获得所在省.
   * 
   * @param cityID
   * @return
   */
  public static Province getProvinceByCity(Integer cityID) {
    for (City city : cities) {
      if (city.id == cityID) {
        return city.province;
      }
    }
    return null;
  }

  /**
   * 特例，全国的编号是0.
   */
  public static String getCountryCode() {
    return "0";
  }

  /**
   * 初始化数据.
   */
  private synchronized static void initData() {
    if (!provinces.isEmpty())
      return;
    // 从资源文件读取原始数据
    URL resourceUrl = LocationUtil.class.getClass().getResource(filePath);
    String provinceFilePath = resourceUrl.getFile();

    try {
      String json = FileUtil.readContent(new File(provinceFilePath));
      @SuppressWarnings("unchecked")
      Map<String, List<JSONObject>> map = JSON.parseObject(json, Map.class);
      for (String key : map.keySet()) {
        List<JSONObject> objs = map.get(key);
        for (JSONObject obj : objs) {
          Item item = JSON.parseObject(obj.toJSONString(), Item.class);
          items.add(item);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    // 先读取所有数据缓存到对应的数组里，方便后面遍历.
    List<Item> i1s = new ArrayList<Item>();
    List<Item> i2s = new ArrayList<Item>();
    List<Item> i3s = new ArrayList<Item>();
    for (Item i : items) {
      if (i.cityType.equals("1")) {
        i1s.add(i);
      } else if (i.cityType.equals("2")) {
        i2s.add(i);
      } else if (i.cityType.equals("3")) {
        i3s.add(i);
      }
    }

    // 添加省信息.
    for (Item i1 : i1s) {
      Province p = new Province(i1);
      provinces.add(p);
      // 为省添加市数据
      for (Item i2 : i2s) {
        if (i2.parentId.equals(p.id))
          continue;
        City city = new City(i2, p);
        p.cities.add(city);
        // 为市添加区信息.
        for (Item i3 : i3s) {
          if (!i3.parentId.equals(city.id))
            continue;
          Area area = new Area(i3, city);
          city.areas.add(area);
        }
        // 将City添加到全局集合中.
        cities.add(city);
      }
    }
  }
}


/**
 * 与数据源的条目映射, 字段名称不代表实际意义.
 * 
 * @author royguo@rongxintx.com
 */
class Item {
  public Integer cityId;
  public String cityName;
  public String cityType;
  public Integer id;
  public String parentId;

  public Item() {}
}
