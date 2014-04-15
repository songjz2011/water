package com.trains.data.builder;

import java.util.ArrayList;
import java.util.List;

import com.trains.domain.AdjacentStation;
import com.trains.domain.TrainStation;

public class TrainStationBuilder {

    public TrainStation getTrainStationA() {
        List<AdjacentStation> adjacentStationList = new ArrayList<AdjacentStation>();
        adjacentStationList.add(buildAdjacentStation("B", 5));
        adjacentStationList.add(buildAdjacentStation("D", 5));
        adjacentStationList.add(buildAdjacentStation("E", 7));

        TrainStation trainStation = buildTrainStation("A", adjacentStationList);
        return trainStation;
    }

    public TrainStation getTrainStationB() {
        List<AdjacentStation> adjacentStationList = new ArrayList<AdjacentStation>();
        adjacentStationList.add(buildAdjacentStation("C", 4));
        TrainStation trainStation = buildTrainStation("B", adjacentStationList);
        return trainStation;
    }

    public TrainStation getTrainStationC() {
        List<AdjacentStation> adjacentStationList = new ArrayList<AdjacentStation>();
        adjacentStationList.add(buildAdjacentStation("D", 8));
        adjacentStationList.add(buildAdjacentStation("E", 2));

        TrainStation trainStation = buildTrainStation("C", adjacentStationList);
        return trainStation;
    }

    public TrainStation getTrainStationD() {
        List<AdjacentStation> adjacentStationList = new ArrayList<AdjacentStation>();
        adjacentStationList.add(buildAdjacentStation("C", 8));
        adjacentStationList.add(buildAdjacentStation("E", 6));

        TrainStation trainStation = buildTrainStation("D", adjacentStationList);
        return trainStation;
    }

    public TrainStation getTrainStationE() {
        List<AdjacentStation> adjacentStationList = new ArrayList<AdjacentStation>();
        adjacentStationList.add(buildAdjacentStation("B", 3));

        TrainStation trainStation = buildTrainStation("E", adjacentStationList);
        return trainStation;
    }

    public List<TrainStation> getTrainStationList() {
        List<TrainStation> trainStationList = new ArrayList<TrainStation>();
        trainStationList.add(getTrainStationA());
        trainStationList.add(getTrainStationB());
        trainStationList.add(getTrainStationC());
        trainStationList.add(getTrainStationD());
        trainStationList.add(getTrainStationE());
        return trainStationList;
    }

    private TrainStation buildTrainStation(String name, List<AdjacentStation> adjacentStationList) {
        TrainStation trainStation = new TrainStation();
        trainStation.setName(name);
        trainStation.setAdjacentStationList(adjacentStationList);
        return trainStation;
    }

    private AdjacentStation buildAdjacentStation(String name, Integer distance) {
        AdjacentStation adjacentStation = new AdjacentStation();
        adjacentStation.setName(name);
        adjacentStation.setDistance(distance);
        return adjacentStation;
    }

}
