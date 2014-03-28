package com.web.things.util;

import java.math.BigDecimal;
import java.math.BigInteger;

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

}
