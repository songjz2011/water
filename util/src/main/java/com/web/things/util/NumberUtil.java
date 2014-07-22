package com.web.things.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 * 数据 - 类型的工具类
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月5日
 */
public class NumberUtil {

	@SuppressWarnings("unchecked")
	public static <T extends Number> T parseNumber(Object obj, Class<T> targetClass) {
		if (StringUtil.isEmpty(obj)) {
			return null;
		}
		String text = StringUtil.trimAllWhitespace(obj.toString());
		if (targetClass.equals(Byte.class)) {
			return (T) (isHexNumber(text) ? Byte.decode(text) : Byte.valueOf(text));
		} else if (targetClass.equals(Short.class)) {
			return (T) (isHexNumber(text) ? Short.decode(text) : Short.valueOf(text));
		} else if (targetClass.equals(Integer.class)) {
			return (T) (isHexNumber(text) ? Integer.decode(text) : Integer.valueOf(text));
		} else if (targetClass.equals(Long.class)) {
			return (T) (isHexNumber(text) ? Long.decode(text) : Long.valueOf(text));
		} else if (targetClass.equals(BigInteger.class)) {
			return (T) (isHexNumber(text) ? decodeBigInteger(text) : new BigInteger(text));
		} else if (targetClass.equals(Float.class)) {
			return (T) Float.valueOf(text);
		} else if (targetClass.equals(Double.class)) {
			return (T) Double.valueOf(text);
		} else if (targetClass.equals(BigDecimal.class) || targetClass.equals(Number.class)) {
			return (T) new BigDecimal(text);
		} else {
			throw new IllegalArgumentException("Cannot convert String [" + text
					+ "] to target class [" + targetClass.getName() + "]");
		}
	}

	/**
	 * 是否是16进制
	 * 
	 * @param value
	 * @return
	 */
	private static boolean isHexNumber(String value) {
		int index = (value.startsWith("-") ? 1 : 0);
		return (value.startsWith("0x", index) || value.startsWith("0X", index) || value.startsWith(
				"#", index));
	}

	/**
	 * Decode a {@link java.math.BigInteger} from a {@link String} value.
	 * Supports decimal, hex and octal notation.
	 * 
	 * @see BigInteger#BigInteger(String, int)
	 */
	private static BigInteger decodeBigInteger(String value) {
		int radix = 10;
		int index = 0;
		boolean negative = false;

		// Handle minus sign, if present.
		if (value.startsWith("-")) {
			negative = true;
			index++;
		}

		// Handle radix specifier, if present.
		if (value.startsWith("0x", index) || value.startsWith("0X", index)) {
			index += 2;
			radix = 16;
		} else if (value.startsWith("#", index)) {
			index++;
			radix = 16;
		} else if (value.startsWith("0", index) && value.length() > 1 + index) {
			index++;
			radix = 8;
		}

		BigInteger result = new BigInteger(value.substring(index), radix);
		return (negative ? result.negate() : result);
	}
	
	/**
	 * 转成Double
	 * 
	 * @param obj
	 * @return
	 */
	public static Double convertToDouble(Object obj) {
		Double result = null;
		if (obj != null) {
			try {
				result = Double.valueOf(obj.toString());
			} catch (Exception e) {
				LoggerUtil.error(NumberUtil.class, e.getMessage());
			}
		}
		return result;
	}

	/**
	 * <pre>
	 * 减法（first-second）
	 * 若参数其中一个值为NULL，则返回NULL
	 * </pre>
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Double reduce(Double first, Double second) {
		if (first == null || second == null) {
			return null;
		}
		return first - second;
	}

	/**
	 * <pre>
	 * 除法，若其中一个为null，返回null；若dividend为0，返回null
	 * </pre>
	 * 
	 * @param divisor
	 *            :除数
	 * @param dividend
	 *            ：被除数
	 * @return
	 */
	public static Double divide(Double divisor, Double dividend) {
		if (divisor == null || dividend == null || dividend == 0) {
			return null;
		}
		return divisor / dividend;
	}

	/**
	 * <pre>
	 * 求和，若其中一个为null，则返回有值得数据；若都为null，则返回null；
	 * </pre>
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Double sum(Double first, Double second) {
		if (first == null && second == null) {
			return null;
		}
		if (first == null) {
			return second;
		}
		if (second == null) {
			return first;
		}
		return first + second;
	}

	/**
	 * 求和，若都为null，则返回null
	 * 
	 * @param list
	 * @return
	 */
	public static Double sum(List<Double> list) {
		if (isAllNull(list)) {
			return null;
		}
		Double sum = 0d;
		for (Double d : list) {
			if (d == null) {
				continue;
			}
			sum += d;
		}
		return sum;
	}

	/**
	 * 乘法,若其中一个为null，则返回为null
	 * 
	 * @param first
	 * @param second
	 * @return
	 */
	public static Double multiply(Double first, Double second) {
		if (first == null || second == null) {
			return null;
		}
		return first * second;
	}

	/**
	 * 获取Double集合中最大的数，若都为null，则返回null
	 * 
	 * @param list
	 * @return
	 */
	public static Double max(List<Double> list) {
		if (list == null || list.isEmpty() || isAllNull(list)) {
			return null;
		}
		List<Double> newList = new ArrayList<Double>();
		for (Double value : list) {
			if (value != null) {
				newList.add(value);
			}
		}
		return Collections.max(newList);
	}

	/**
	 * 获取Double集合中最小的数，若都为null，则返回null
	 * 
	 * @param list
	 * @return
	 */
	public static Double min(List<Double> list) {
		if (list == null || list.isEmpty() || isAllNull(list)) {
			return null;
		}
		List<Double> newList = new ArrayList<Double>();
		for (Double value : list) {
			if (value != null) {
				newList.add(value);
			}
		}
		return Collections.min(newList);
	}

	/**
	 * 是否所有的值都为空，若都为空，则返回true
	 * 
	 * @param list
	 * @return
	 */
	public static boolean isAllNull(List<? extends Object> list) {
		boolean isAllNull = true;
		if (list == null || list.isEmpty()) {
			return isAllNull;
		}
		for (Object value : list) {
			if (value != null) {
				isAllNull = false;
				break;
			}
		}
		return isAllNull;
	}

	/**
	 * <pre>
	 * 截取value（不包含小数点之后的值）的前面位数的值
	 * 例如：value=2511.11,digit=2,返回值为2500
	 * 1、若value=null，返回null
	 * 2、若digit大于value小数点之前的位数，则返回value小数点之前的值
	 * 3、若value为负值，则在digit的位上减1，例如：value=-2511.11,digit=2,返回值为-2600
	 * 总之：若有返回值，则去除了value小数点之后的值
	 * </pre>
	 * 
	 * @param value
	 *            ：截取的值
	 * @param digit
	 *            ：截取位数
	 * @return
	 */
	public static Double preCutout(Double value, int digit) {
		return preCutout(value, digit, 0);
	}

	/**
	 * <pre>
	 * 具有增量的截取value（不包含小数点之后的值）的前面位数的值
	 * 基本逻辑和preCutout(Double value, int digit)一致
	 * 只在digit的位上，增加上increment（增量）
	 * 例如：value=2511.11,digit=2,increment=3 返回值为2800
	 * 计算逻辑如下：2511.11根据digit=2，截取后为25
	 * 然后25 + 3（increment） = 28,
	 * 最后用0补充缺少的位数，返回值为2800
	 * </pre>
	 * 
	 * @param value
	 *            ：截取的值
	 * @param digit
	 *            ：截取位数
	 * @param increment
	 *            ：增量
	 * @return
	 */
	public static Double preCutout(Double value, int digit, int increment) {
		if (value == null) {
			return value;
		}
		String str = cutoutDecimalPoint(value);
		// 若截取的位数小于1，或者，value（不包含小数点之后的值）的长度不够截取时
		if (!isPreCutout(str, digit)) {
			return Double.valueOf(str);
		}
		String result = preCutoutByDigit(str, digit);
		// 首先计算缺失的位数的个数
		int offset = str.length() - result.length();
		if (value < 0) {
			result = cutoutDecimalPoint(Double.valueOf(result) - 1);
		}
		// 其次增加上增量
		result = cutoutDecimalPoint(Double.valueOf(Double.valueOf(result) + increment));
		// 最后用0补充缺少的位数
		for (int i = 0; i < offset; i++) {
			result += "0";
		}
		System.out.println(result);
		return Double.valueOf(result);
	}

	/**
	 * 是否需要截取
	 * 
	 * @param str
	 * @param digit
	 * @return
	 */
	private static boolean isPreCutout(String str, int digit) {
		int cutout = digit;
		if (cutout < 1) {
			return false;
		}
		Double value = Double.valueOf(str);
		if (value < 0) {
			cutout++;
		}
		if (str.length() <= cutout) {
			return false;
		}
		return true;
	}

	/**
	 * 截取小数点之前的字符串
	 * 
	 * @param value
	 * @return
	 */
	private static String cutoutDecimalPoint(Double value) {
		String str = value.toString();
		int pointIndex = str.indexOf(".");
		if (pointIndex > 0) {
			str = str.substring(0, pointIndex);
		}
		return str;
	}

	/**
	 * 根据位数截取字符串
	 * 
	 * @param value
	 * @param digit
	 * @return
	 */
	private static String preCutoutByDigit(String value, int digit) {
		int cutout = digit;
		if (Double.valueOf(value) < 0) {
			cutout++;
		}
		return value.substring(0, cutout);
	}

	public static void main(String[] args) {
		Double value = -2311.1D;
		preCutout(value, 2);
	}

}
