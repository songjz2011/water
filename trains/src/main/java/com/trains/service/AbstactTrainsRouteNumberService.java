package com.trains.service;

import java.util.HashSet;
import java.util.Set;

import com.trains.domain.AdjacentStation;
import com.trains.domain.TrainStation;

public abstract class AbstactTrainsRouteNumberService extends BasicTrainsRouteService {

    protected abstract boolean addResultNameToCollection(String endStation, String stationNames, int stops,
            Set<String> resultSet);

    protected int getTripsNumber(String startStation, String endStation, int number) {
        int result = 0;
        TrainStation station = getStartTrainStation(startStation, endStation, number);
        if (station == null) {
            return result;
        }
        Set<String> resultSet = new HashSet<String>();
        for (AdjacentStation adjacentStation : station.getAdjacentStationList()) {
            String linkNames = linkAdjacentStationNames(station.getName(), adjacentStation.getName());
            dfs(endStation, linkNames, number, resultSet);
        }
        result = resultSet.size();
        return result;
    }

    protected void dfs(String endStation, String stationNames, int stops, Set<String> resultSet) {
        if (addResultNameToCollection(endStation, stationNames, stops, resultSet)) {
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
            dfs(endStation, linkNames, stops, resultSet);
        }
    }

    protected TrainStation getStartTrainStation(String startStation, String endStation, int stops) {
        TrainStation trainStation = null;
        if (!validateData(startStation, endStation, stops)) {
            return trainStation;
        }
        trainStation = findTrainStationByName(startStation);
        return trainStation;
    }

    protected boolean validateData(String startStation, String endStation, int number) {
        if (number < 1) {
            return false;
        }
        if (!validateStation(startStation, endStation)) {
            return false;
        }
        return true;
    }

}
