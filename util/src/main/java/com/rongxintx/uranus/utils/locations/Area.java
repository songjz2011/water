package com.rongxintx.uranus.utils.locations;

/**
 * 区信息.
 */
public class Area {
  public Integer id;
  public String name;
  public City city;

  public Area() {
  }

  public Area(Item item, City city) {
    this.id = item.cityId;
    this.name = item.cityName;
    this.city = city;
  }
}