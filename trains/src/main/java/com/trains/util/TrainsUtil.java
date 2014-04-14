package com.trains.util;

import java.util.List;

import com.trains.domain.TrainStation;

public class TrainsUtil {

	public static TrainStation findTrainStationByName(String stationName,
			List<TrainStation> trainStationList) {
		TrainStation station = null;
		if (StringUtil.isEmpty(stationName) || trainStationList == null) {
			return station;
		}
		for (TrainStation trainStation : trainStationList) {
			if (stationName.equals(trainStation.getName())) {
				station = trainStation;
				break;
			}
		}
		return station;
	}

}
