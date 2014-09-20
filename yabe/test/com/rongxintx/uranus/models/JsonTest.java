package com.rongxintx.uranus.models;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import static org.junit.Assert.*;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class JsonTest {

  @Test
  public void test_date_format() {
    JsonA a = new JsonA();

    Calendar c = Calendar.getInstance();
    c.set(Calendar.YEAR, 2014);
    c.set(Calendar.MONTH, 8);
    c.set(Calendar.DAY_OF_MONTH, 11);
    c.set(Calendar.HOUR_OF_DAY, 10);
    c.set(Calendar.MINUTE, 10);
    c.set(Calendar.SECOND, 10);

    a.date = c.getTime();

    String str = JSONObject.toJSONString(a);
    assertEquals("{\"age\":123,\"date\":\"2014-09-11\"}", str);
  }

}

class JsonA {
  public int age = 123;
  @JSONField(format = "yyyy-MM-dd")
  public Date date;
}