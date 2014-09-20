package com.rongxintx.uranus.utils;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

import com.rongxintx.uranus.utils.locations.City;
import com.rongxintx.uranus.utils.locations.LocationUtil;
import com.rongxintx.uranus.utils.locations.Province;

public class LocationUtilTest extends TestCase {

  @Test
  public void testLocation() {
    List<Province> provinces = LocationUtil.getAllProvinces();
    assertTrue(provinces.size() > 0);
    for (Province p : provinces) {
      if (p.id == 150000) {
        assertEquals(p.name, "内蒙古自治区");
      }

      if (p.id == 330000) {
        assertEquals(p.name, "浙江省");
        assertTrue(p.cities.size() > 0);
        for (City city : p.cities) {
          if (city.id == 330100) {
            assertEquals(city.name, "杭州市");
          }
        }
      }
    }
  }
}
