package com.rongxintx.uranus.utils.locations;

import java.util.ArrayList;
import java.util.List;

public class Province {
  public Integer id;
  public String name;
  // 省所包含的市.
  public List<City> cities = new ArrayList<City>();;

  public Province() {
  }

  public Province(Item item) {
    this.id = item.cityId;
    this.name = item.cityName;
  }
}
