package com.trains.service;

import java.util.Set;

public class TrainsRouteNumberExactlyStopService extends AbstactTrainsRouteNumberService {

	public int getTripsNumber(String startStation, String endStation, int exactlyStops) {
		int result = super.getTripsNumber(startStation, endStation, exactlyStops);
		return result;
	}

	@Override
	protected boolean addResultNameToCollection(String endStation, String stationNames, int stops,
			Set<String> resultSet) {
		String[] names = stationNames.split(getNameSeparator());
		int nameMaxIndex = names.length - 1;
		if (nameMaxIndex > stops) {
			return true;
		}
		String lastName = names[nameMaxIndex];
		if (nameMaxIndex == stops && lastName.equals(endStation)) {
			resultSet.add(stationNames);
			return true;
		}
		return false;
	}

}
