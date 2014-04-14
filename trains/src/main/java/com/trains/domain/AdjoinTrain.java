package com.trains.domain;

/**
 * <pre>
 * 邻近车站
 * </pre>
 */
public class AdjoinTrain {

	/**
	 * 邻近车站名称
	 */
	private String name;
	
	/**
	 * 与邻近车站的距离
	 */
	private Integer distance;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDistance() {
		return distance;
	}

	public void setDistance(Integer distance) {
		this.distance = distance;
	}
}
