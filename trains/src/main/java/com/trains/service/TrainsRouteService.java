package com.trains.service;

import java.util.List;

import com.trains.domain.TrainStation;
import com.trains.util.StringUtil;

public class TrainsRouteService {

	private List<TrainStation> trainStationList;

	public int getTripsNumberByMaxStops(String startStation, String endStation, int maxStops) {
		int result = 0;
		if (!validateData(startStation, endStation, maxStops)) {
			return result;
		}
		return result;
	}

	private boolean validateData(String startStation, String endStation, int maxStops) {
		if (StringUtil.isEmpty(startStation) || StringUtil.isEmpty(endStation) || maxStops < 1) {
			return false;
		}
		if (trainStationList == null || trainStationList.isEmpty()) {
			return false;
		}
		return true;
	}

	public void setTrainStationList(List<TrainStation> trainStationList) {
		this.trainStationList = trainStationList;
	}

}
