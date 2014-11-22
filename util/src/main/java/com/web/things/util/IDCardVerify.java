package com.web.things.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Hashtable;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 身份证有效性验证
 * 
 * @author jiangyujiang
 * @date 2014年8月21日
 */

public class IDCardVerify {

  private static Hashtable<String, String> areaCode;

  public IDCardVerify() {
    initAreaCode();
  }

  /**
   * 验证身份证有效性
   * 
   * @param id 身份证号
   * @return 有效：返回"" 无效：返回无效信息
   */
  public String verify(String id) {
    String errorInfo = "";// 记录错误信息
    String[] valCodes = {"1", "0", "x", "9", "8", "7", "6", "5", "4", "3", "2"};
    String[] wi = {"7", "9", "10", "5", "8", "4", "2", "1", "6", "3", "7", "9", "10", "5", "8", "4", "2"};
    String ai = "";
    // 号码的长度 15位或18位
    if (id.length() != 15 && id.length() != 18) {
      errorInfo = "身份证号码长度应该为15位或18位";
      return errorInfo;
    }

    // 除最后一位都为数字
    if (id.length() == 18) {
      ai = id.substring(0, 17);
    } else {
      ai = id.substring(0, 6) + "19" + id.substring(6, 15);
    }
    if (isNumeric(ai) == false) {
      errorInfo = "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字";
      return errorInfo;
    }

    // ================ 出生年月是否有效 ================
    String strYear = ai.substring(6, 10);// 年份
    String strMonth = ai.substring(10, 12);// 月份
    String strDay = ai.substring(12, 14);// 月份
    if (isDate(strYear + "-" + strMonth + "-" + strDay) == false) {
      errorInfo = "身份证生日无效";
      return errorInfo;
    }
    GregorianCalendar gc = new GregorianCalendar();
    SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
    try {
      if ((gc.get(Calendar.YEAR) - Integer.parseInt(strYear)) > 150
          || (gc.getTime().getTime() - s.parse(strYear + "-" + strMonth + "-" + strDay).getTime()) < 0) {
        errorInfo = "身份证生日不在有效范围";
        return errorInfo;
      }
    } catch (NumberFormatException e) {
      e.printStackTrace();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    if (Integer.parseInt(strMonth) > 12 || Integer.parseInt(strMonth) == 0) {
      errorInfo = "身份证月份无效";
      return errorInfo;
    }
    if (Integer.parseInt(strDay) > 31 || Integer.parseInt(strDay) == 0) {
      errorInfo = "身份证日期无效";
      return errorInfo;
    }

    // ================ 地区码是否有效 ================
    if (areaCode.get(ai.substring(0, 2)) == null) {
      errorInfo = "身份证地区编码错误";
      return errorInfo;
    }

    // 15位的身份证不用判断最后一位数字
    if (id.length() == 15) {
      return "";
    }

    // 计算最后一位的值
    int totalMulAiWi = 0;
    for (int i = 0; i < 17; i++) {
      totalMulAiWi = totalMulAiWi + Integer.parseInt(String.valueOf(ai.charAt(i))) * Integer.parseInt(wi[i]);
    }
    int modValue = totalMulAiWi % 11;
    String verifyCode = valCodes[modValue];

    // 18位身份证验证
    ai = ai + verifyCode;
    if (id.length() == 18) {
      if (ai.equalsIgnoreCase(id) == false) {
        errorInfo = "身份证无效，不是合法的身份证号码";
        return errorInfo;
      }
    }

    return "";
  }

  /**
   * 功能：判断字符串是否为数字
   */
  private boolean isNumeric(String str) {
    Pattern pattern = Pattern.compile("[0-9]*");
    Matcher isNum = pattern.matcher(str);
    if (isNum.matches()) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * 功能：判断字符串是否为日期格式
   */
  private boolean isDate(String strDate) {
    Pattern pattern = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
    Matcher m = pattern.matcher(strDate);
    if (m.matches()) {
      return true;
    } else {
      return false;
    }
  }

  private void initAreaCode() {
    areaCode = new Hashtable<String, String>();
    areaCode.put("11", "北京");
    areaCode.put("12", "天津");
    areaCode.put("13", "河北");
    areaCode.put("14", "山西");
    areaCode.put("15", "内蒙古");
    areaCode.put("21", "辽宁");
    areaCode.put("22", "吉林");
    areaCode.put("23", "黑龙江");
    areaCode.put("31", "上海");
    areaCode.put("32", "江苏");
    areaCode.put("33", "浙江");
    areaCode.put("34", "安徽");
    areaCode.put("35", "福建");
    areaCode.put("36", "江西");
    areaCode.put("37", "山东");
    areaCode.put("41", "河南");
    areaCode.put("42", "湖北");
    areaCode.put("43", "湖南");
    areaCode.put("44", "广东");
    areaCode.put("45", "广西");
    areaCode.put("46", "海南");
    areaCode.put("50", "重庆");
    areaCode.put("51", "四川");
    areaCode.put("52", "贵州");
    areaCode.put("53", "云南");
    areaCode.put("54", "西藏");
    areaCode.put("61", "陕西");
    areaCode.put("62", "甘肃");
    areaCode.put("63", "青海");
    areaCode.put("64", "宁夏");
    areaCode.put("65", "新疆");
    areaCode.put("71", "台湾");
    areaCode.put("81", "香港");
    areaCode.put("82", "澳门");
    areaCode.put("91", "国外");
  }
}
