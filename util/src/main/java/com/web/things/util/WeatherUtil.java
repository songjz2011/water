package com.web.things.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WeatherUtil {
  public static String getWeather(String cityCode) {
    String result = "";
    Pattern pattern = Pattern.compile(".*?\"weather\":\"(.*?)\",.*");
    try {
      URL url = new URL("http://www.weather.com.cn/data/cityinfo/" + cityCode + ".html");
      InputStream in = url.openStream();
      BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
      String line = br.readLine();
      if (null == line) {
        return result;
      } else {
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
          result = matcher.group(1);
        }
      }
      System.out.println(line);
      br.close();
      in.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return result;
  }
  
  public static void main(String[] args) {  
    System.out.println(WeatherUtil.getWeather("100001"));  
}  

}
