package com.tsingsoft.android.entity;

import java.util.List;

/**
 * <pre>
 * 天气数据实体
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月19日
 */
public class Weather {
	/** 当前日期的气象详情 */
	private WeatherDetail curDetail;
	/** 历史日期的气象详情 */
	private List<WeatherDetail> hisDetail;
	/** 未来日期的气象详情 */
	private List<WeatherDetail> futureDetail;

	public WeatherDetail getCurDetail() {
		return curDetail;
	}

	public void setCurDetail(WeatherDetail curDetail) {
		this.curDetail = curDetail;
	}

	public List<WeatherDetail> getHisDetail() {
		return hisDetail;
	}

	public void setHisDetail(List<WeatherDetail> hisDetail) {
		this.hisDetail = hisDetail;
	}

	public List<WeatherDetail> getFutureDetail() {
		return futureDetail;
	}

	public void setFutureDetail(List<WeatherDetail> futureDetail) {
		this.futureDetail = futureDetail;
	}

}
