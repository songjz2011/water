package com.rongxintx.uranus.utils.locations;

import java.util.ArrayList;
import java.util.List;

public class City {
  public Integer id;
  public String name;
  public Province province;
  public List<Area> areas = new ArrayList<Area>();

  public City() {
  }

  public City(Item item, Province province) {
    this.id = item.cityId;
    this.name = item.cityName;
    this.province = province;
  }
}
