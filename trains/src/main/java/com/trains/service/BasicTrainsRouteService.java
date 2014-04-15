package com.trains.service;

import java.util.List;

import com.trains.constant.TrainConstant;
import com.trains.domain.TrainStation;
import com.trains.util.TrainsUtil;

public class BasicTrainsRouteService {

    protected List<TrainStation> trainStationList;

    protected boolean validateStation(String startStation, String endStation) {
        TrainStation startTrainStation = findTrainStationByName(startStation);
        TrainStation endTrainStation = findTrainStationByName(endStation);
        if (startTrainStation == null || endTrainStation == null) {
            return false;
        }
        return true;
    }

    protected Integer getAdjacentStationDistance(TrainStation station, String adjacentStationName) {
        Integer distance = null;
        if (station != null) {
            distance = station.getAdjacentStationDistance(adjacentStationName);
        }
        return distance;
    }

    protected TrainStation findTrainStationByName(String name) {
        TrainStation trainStation = TrainsUtil.findTrainStationByName(name, trainStationList);
        if (trainStation == null || trainStation.getAdjacentStationList() == null
                || trainStation.getAdjacentStationList().isEmpty()) {
            trainStation = null;
        }
        return trainStation;
    }

    protected String linkAdjacentStationNames(String stationName, String adjacentStationName) {
        return stationName + getNameSeparator() + adjacentStationName;
    }

    protected String getNameSeparator() {
        return TrainConstant.ROUTE_SEPARATOR;
    }

    public void setTrainStationList(List<TrainStation> trainStationList) {
        this.trainStationList = trainStationList;
    }

}
