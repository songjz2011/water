package com.trains.service;

import com.trains.domain.AdjoinTrain;
import com.trains.domain.TrainStation;

public class TrainsRouteShortestDistanceService extends BasicTrainsRouteService {

	public Integer getShorestDistance(String startStation, String endStation) {
		Integer bestCost = null;
		if (!validateStation(startStation, endStation)) {
			return bestCost;
		}
		TrainStation station = findTrainStationByName(startStation);
		TrainsRouteShortestDistance shortest = new TrainsRouteShortestDistance();
		for (AdjoinTrain adjoinTrain : station.getAdjoinStationList()) {
			String linkNames = linkAdjoinStationNames(station.getName(), adjoinTrain.getName());
			Integer distance = getAdjoinDistance(station, adjoinTrain.getName());
			if (distance == null) {
				continue;
			}
			dfs(endStation, linkNames, distance, shortest);
		}
		if (shortest.isRoute()) {
			bestCost = shortest.getShortestDistance();
		}
		return bestCost;
	}

	private void dfs(String endStation, String stationNames, Integer cost,
			TrainsRouteShortestDistance shortest) {
		if (putBestCostToMap(endStation, stationNames, cost, shortest)) {
			return;
		}
		String[] names = stationNames.split(getNameSeparator());
		String lastName = names[names.length - 1];
		TrainStation station = findTrainStationByName(lastName);
		if (station == null) {
			return;
		}
		for (AdjoinTrain adjoinTrain : station.getAdjoinStationList()) {
			String adjoinTrainName = adjoinTrain.getName();
			if (stationNames.indexOf(adjoinTrainName) > 0) {
				continue;
			}
			String linkNames = linkAdjoinStationNames(stationNames, adjoinTrainName);
			Integer distance = getAdjoinDistance(station, adjoinTrainName);
			if (distance == null) {
				continue;
			}
			Integer sumCost = cost + distance;
			dfs(endStation, linkNames, sumCost, shortest);
		}
	}

	protected boolean putBestCostToMap(String endStation, String stationNames, Integer cost,
			TrainsRouteShortestDistance shortest) {
		String[] names = stationNames.split(getNameSeparator());
		String lastName = names[names.length - 1];
		if (lastName.equals(endStation)) {
			if (!shortest.isRoute()) {
				shortest.setShortestDistance(cost);
			} else {
				Integer bestCost = shortest.getShortestDistance();
				if (cost < bestCost) {
					shortest.setShortestDistance(cost);
				}
			}
			shortest.setRoute(true);
			return true;
		}
		return false;
	}

	private class TrainsRouteShortestDistance {
		private Integer shortestDistance;

		private boolean isRoute;

		public Integer getShortestDistance() {
			return shortestDistance;
		}

		public void setShortestDistance(Integer shortestDistance) {
			this.shortestDistance = shortestDistance;
		}

		public boolean isRoute() {
			return isRoute;
		}

		public void setRoute(boolean isRoute) {
			this.isRoute = isRoute;
		}
	}

}
