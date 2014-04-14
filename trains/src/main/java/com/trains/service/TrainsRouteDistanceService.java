package com.trains.service;

import java.util.List;

import com.trains.constant.TrainConstant;
import com.trains.domain.TrainStation;
import com.trains.util.StringUtil;
import com.trains.util.TrainsUtil;

public class TrainsRouteDistanceService {

	private List<TrainStation> trainStationList;

	public String getRouteDistance(String route) {
		String distance = "NO SUCH ROUTE";
		if (!validateData(route)) {
			return distance;
		}
		String[] names = route.split(TrainConstant.ROUTE_SEPARATOR);
		Integer totalDistance = calculateTotalDistance(names);
		if (totalDistance != null) {
			distance = totalDistance.toString();
		}
		return distance;
	}

	private Integer calculateTotalDistance(String[] names) {
		Integer totalDistance = null;
		int namesLength = names.length;
		for (int i = 0; i < namesLength; i++) {
			if (i + 1 == namesLength) {
				break;
			}
			TrainStation station = TrainsUtil.findTrainStationByName(names[i], trainStationList);
			Integer distance = getAdjoinDistance(station, names[i + 1]);
			if (distance == null) {
				totalDistance = null;
				break;
			}
			if (totalDistance == null) {
				totalDistance = distance;
			} else {
				totalDistance += distance;
			}
		}
		return totalDistance;
	}

	private Integer getAdjoinDistance(TrainStation station, String adjoinStationName) {
		Integer distance = null;
		if (station == null) {
			return distance;
		}
		distance = station.getAdjoinDistance(adjoinStationName);
		return distance;
	}

	private boolean validateData(String route) {
		if (StringUtil.isEmpty(route)) {
			return false;
		}
		if (trainStationList == null || trainStationList.isEmpty()) {
			return false;
		}
		String[] names = route.split(TrainConstant.ROUTE_SEPARATOR);
		if (names.length < 2) {
			return false;
		}
		return true;
	}

	public void setTrainStationList(List<TrainStation> trainStationList) {
		this.trainStationList = trainStationList;
	}

}
