package com.trains.service;

import com.trains.constant.TrainConstant;
import com.trains.domain.TrainStation;
import com.trains.util.StringUtil;

public class TrainsRouteDistanceService extends BasicTrainsRouteService {

	private static final String NO_SUCH_ROUTE = "NO SUCH ROUTE";

	public String getRouteDistance(String route) {
		String distance = NO_SUCH_ROUTE;
		if (!validateData(route)) {
			return distance;
		}
		String[] names = route.split(getNameSeparator());
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
			TrainStation station = findTrainStationByName(names[i]);
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

	private boolean validateData(String route) {
		if (StringUtil.isEmpty(route)) {
			return false;
		}
		String[] names = route.split(TrainConstant.ROUTE_SEPARATOR);
		if (names.length < 2) {
			return false;
		}
		return true;
	}

}
