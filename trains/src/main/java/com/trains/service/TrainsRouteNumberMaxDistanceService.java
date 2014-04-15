package com.trains.service;

import java.util.HashSet;
import java.util.Set;

import com.trains.domain.AdjacentStation;
import com.trains.domain.TrainStation;

public class TrainsRouteNumberMaxDistanceService extends BasicTrainsRouteService {

	public int getRoutesNumber(String startStation, String endStation, int maxDistance) {
		int result = 0;
		if (!validateData(startStation, endStation, maxDistance)) {
			return result;
		}
		Set<String> resultSet = new HashSet<String>();
		TrainStation station = findTrainStationByName(startStation);
		for (AdjacentStation adjacentStation : station.getAdjacentStationList()) {
			String linkNames = linkAdjacentStationNames(station.getName(), adjacentStation.getName());
			Integer distance = getAdjacentStationDistance(station, adjacentStation.getName());
			if (distance == null) {
				continue;
			}
			dfs(endStation, linkNames, maxDistance, distance, resultSet);
		}
		result = resultSet.size();
		return result;
	}

	protected void dfs(String endStation, String stationNames, int maxDistance, int curDistance,
			Set<String> resultSet) {
		if (addResultNameToCollection(endStation, stationNames, maxDistance, curDistance, resultSet)) {
			return;
		}
		String[] names = stationNames.split(getNameSeparator());
		String lastName = names[names.length - 1];
		TrainStation station = findTrainStationByName(lastName);
		if (station == null) {
			return;
		}
		for (AdjacentStation adjacentStation : station.getAdjacentStationList()) {
			String linkNames = linkAdjacentStationNames(stationNames, adjacentStation.getName());
			Integer distance = getAdjacentStationDistance(station, adjacentStation.getName());
			if (distance == null) {
				continue;
			}
			Integer sumCost = curDistance + distance;
			dfs(endStation, linkNames, maxDistance, sumCost, resultSet);
		}
	}

	protected boolean addResultNameToCollection(String endStation, String stationNames,
			int maxDistance, int curDistance, Set<String> resultSet) {
		if (maxDistance > curDistance) {
			String[] names = stationNames.split(getNameSeparator());
			String lastName = names[names.length - 1];
			if (lastName.equals(endStation)) {
				resultSet.add(stationNames);
			}
			return false;
		}
		return true;
	}

	private boolean validateData(String startStation, String endStation, int maxDistance) {
		if (maxDistance < 1) {
			return false;
		}
		if (!validateStation(startStation, endStation)) {
			return false;
		}
		return true;
	}

}
