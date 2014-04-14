package com.trains.domain;

import java.util.List;

import com.trains.util.StringUtil;

/**
 * <pre>
 * 火车站
 * </pre>
 */
public class TrainStation {

	/**
	 * 车站名称
	 */
	private String name;

	/**
	 * 相邻车站集合（当前车站能够到达的相邻车站）
	 */
	private List<AdjoinTrain> adjoinStationList;

	public Integer getAdjoinDistance(String adjoinTrainName) {
		Integer distance = null;
		List<AdjoinTrain> adjoinStationList = getAdjoinStationList();
		if (StringUtil.isEmpty(adjoinTrainName) || adjoinStationList == null) {
			return distance;
		}
		for (AdjoinTrain train : adjoinStationList) {
			if (adjoinTrainName.equals(train.getName())) {
				distance = train.getDistance();
				break;
			}
		}
		return distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AdjoinTrain> getAdjoinStationList() {
		return adjoinStationList;
	}

	public void setAdjoinStationList(List<AdjoinTrain> adjoinStationList) {
		this.adjoinStationList = adjoinStationList;
	}

}
