package com.web.things.jfreechart;

/**
 * <pre>
 * 绘制曲线图形时，用到的参数
 * </pre>
 * 
 * @author songjz
 * @time 2013年8月2日
 */
public class LineChartPara extends BasicChartPara {
	/** 是否显示曲线中各点的图形 默认为显示 */
	private boolean shapesVisible = true;
	/** 是否显示曲线中各点的图形的tooltip 默认为显示 */
	private boolean shapesToolTipVisible = true;

	/**
	 * 曲线中各点的直径
	 */
	private float shapeDiameter = 4.0f;

	/**
	 * @return the shapesVisible
	 */
	public boolean isShapesVisible() {
		return shapesVisible;
	}

	/**
	 * @param shapesVisible
	 *            the shapesVisible to set
	 */
	public void setShapesVisible(boolean shapesVisible) {
		this.shapesVisible = shapesVisible;
	}

	/**
	 * @return the shapesToolTipVisible
	 */
	public boolean isShapesToolTipVisible() {
		return shapesToolTipVisible;
	}

	/**
	 * @param shapesToolTipVisible
	 *            the shapesToolTipVisible to set
	 */
	public void setShapesToolTipVisible(boolean shapesToolTipVisible) {
		this.shapesToolTipVisible = shapesToolTipVisible;
	}

	/**
	 * @return the shapeDiameter
	 */
	public float getShapeDiameter() {
		return shapeDiameter;
	}

	/**
	 * @param shapeDiameter the shapeDiameter to set
	 */
	public void setShapeDiameter(float shapeDiameter) {
		this.shapeDiameter = shapeDiameter;
	}

}
