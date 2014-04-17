package com.tsingsoft.android.entity;

/**
 * <pre>
 * 天气详情
 * </pre>
 * 
 * @author songjz
 * @time 2013年12月19日
 */
public class WeatherDetail {

	/** 日期 */
	private String ymd;
	/** 周几 */
	private String weekDay;
	/** 天气类型(例如：晴、多云、小雨等) */
	private String weatherType;
	/** 温度 */
	private String temperature;
	/** 风力 */
	private String windPower;
	/** 风向 */
	private String windDirection;
	/** 湿度 */
	private String humidity;
	
	public String getYmd() {
		return ymd;
	}

	public void setYmd(String ymd) {
		this.ymd = ymd;
	}

	public String getWeekDay() {
		return weekDay;
	}

	public void setWeekDay(String weekDay) {
		this.weekDay = weekDay;
	}

	public String getWeatherType() {
		return weatherType;
	}

	public void setWeatherType(String weatherType) {
		this.weatherType = weatherType;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getWindPower() {
		return windPower;
	}

	public void setWindPower(String windPower) {
		this.windPower = windPower;
	}

	public String getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(String windDirection) {
		this.windDirection = windDirection;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

}
