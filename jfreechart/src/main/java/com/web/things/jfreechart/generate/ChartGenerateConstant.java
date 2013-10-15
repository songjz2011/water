package com.web.things.jfreechart.generate;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Paint;

/**
 * <pre>
 * 图形的恒定量
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月1日
 */
public class ChartGenerateConstant {

	/** 默认使用的字体 */
	public static final Font DEFAULT_VALUE_LABEL_FONT = new Font("SansSerif", Font.PLAIN, 12);

	/** 该字体用于DomainAxis 的列数过多的情况下使用 */
	public static final Font SMALL_FONT = new Font("SansSerif", Font.PLAIN, 10);

	/** 默认的图形背景颜色 */
	public static final Paint DEFAULT_BACKGROUND_PAINT = new GradientPaint(0, 0, Color.white, 0,
			1000, new Color(168, 228, 214));

	/** PLOT区域的颜色 */
	public static final Paint DEFAULT_PLOT_BACKGROUND_PAINT = new GradientPaint(0, 0, Color.white,
			0, 0, Color.orange);

	/** 该字体用于图形中的Title */
	public static final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 16);

	/** 该字体用于图形中的subTitle */
	public static final Font SUB_TITLE_FONT = new Font("SansSerif", Font.PLAIN, 12);

	/** PLOT区域的颜色 */
	public static final Paint DEFAULT_PLOT_PAINT = new GradientPaint(0, 0, Color.white, 0, 0,
			Color.orange);

	/** 设置无数据时给出消息的颜色 */
	public static final Paint N0_DATA_MESSAGE_PAINT = Color.RED;

	/** 是否显示纵轴的网格线 */
	public static final boolean DISPLAY_RANGE_GRIDLINE = true;

	/** 纵轴网格线的颜色 */
	public static final Paint RANGE_GRIDLINE_PAINT = Color.LIGHT_GRAY;

	/** 横轴网格线的颜色 */
	public static final Paint DOMAIN_GRIDLINE_PAINT = Color.WHITE;

	/** 是否显示横轴的网格线 */
	public static final boolean DISPLAY_DOMAIN_GRIDLINE = false;

	/** 设置3D图形的透明度 0.0f~~1.0f */
	public static final float FOREGROUNDALPHA = 0.65F;
}
