package com.trains.service;

import com.trains.domain.AdjacentStation;
import com.trains.domain.TrainStation;

public class TrainsRouteShortestDistanceService extends BasicTrainsRouteService {

    public Integer getShorestDistance(String startStation, String endStation) {
        Integer bestCost = null;
        if (!validateStation(startStation, endStation)) {
            return bestCost;
        }
        TrainStation station = findTrainStationByName(startStation);
        TrainsRouteShortestDistance shortest = new TrainsRouteShortestDistance();
        for (AdjacentStation adjacentStation : station.getAdjacentStationList()) {
            String linkNames = linkAdjacentStationNames(station.getName(), adjacentStation.getName());
            Integer distance = getAdjacentStationDistance(station, adjacentStation.getName());
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

    private void dfs(String endStation, String stationNames, Integer cost, TrainsRouteShortestDistance shortest) {
        if (putBestCostToMap(endStation, stationNames, cost, shortest)) {
            return;
        }
        String[] names = stationNames.split(getNameSeparator());
        String lastName = names[names.length - 1];
        TrainStation station = findTrainStationByName(lastName);
        if (station == null) {
            return;
        }
        for (AdjacentStation adjacentStation : station.getAdjacentStationList()) {
            String adjacentStationName = adjacentStation.getName();
            if (stationNames.indexOf(adjacentStationName) > 0) {
                continue;
            }
            String linkNames = linkAdjacentStationNames(stationNames, adjacentStationName);
            Integer distance = getAdjacentStationDistance(station, adjacentStationName);
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
