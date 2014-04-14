package com.trains.data.builder;

import java.util.ArrayList;
import java.util.List;

import com.trains.domain.AdjoinTrain;
import com.trains.domain.TrainStation;

public class TrainStationBuilder {

	public TrainStation getTrainStationA() {
		List<AdjoinTrain> adjoinTrainList = new ArrayList<AdjoinTrain>();
		adjoinTrainList.add(buildAdjoinTrain("B", 5));
		adjoinTrainList.add(buildAdjoinTrain("D", 5));
		adjoinTrainList.add(buildAdjoinTrain("E", 7));

		TrainStation trainStation = buildTrainStation("A", adjoinTrainList);
		return trainStation;
	}
	
	public TrainStation getTrainStationB() {
		List<AdjoinTrain> adjoinTrainList = new ArrayList<AdjoinTrain>();
		adjoinTrainList.add(buildAdjoinTrain("C", 4));
		TrainStation trainStation = buildTrainStation("B", adjoinTrainList);
		return trainStation;
	}
	
	public TrainStation getTrainStationC() {
		List<AdjoinTrain> adjoinTrainList = new ArrayList<AdjoinTrain>();
		adjoinTrainList.add(buildAdjoinTrain("D", 8));
		adjoinTrainList.add(buildAdjoinTrain("E", 2));
		
		TrainStation trainStation = buildTrainStation("C", adjoinTrainList);
		return trainStation;
	}
	
	public TrainStation getTrainStationD() {
		List<AdjoinTrain> adjoinTrainList = new ArrayList<AdjoinTrain>();
		adjoinTrainList.add(buildAdjoinTrain("C", 8));
		adjoinTrainList.add(buildAdjoinTrain("E", 6));
		
		TrainStation trainStation = buildTrainStation("D", adjoinTrainList);
		return trainStation;
	}
	
	public TrainStation getTrainStationE() {
		List<AdjoinTrain> adjoinTrainList = new ArrayList<AdjoinTrain>();
		adjoinTrainList.add(buildAdjoinTrain("B", 3));
		
		TrainStation trainStation = buildTrainStation("E", adjoinTrainList);
		return trainStation;
	}

	private TrainStation buildTrainStation(String name, List<AdjoinTrain> adjoinTrainList) {
		TrainStation trainStation = new TrainStation();
		trainStation.setName(name);
		trainStation.setAdjoinStationList(adjoinTrainList);
		return trainStation;
	}

	private AdjoinTrain buildAdjoinTrain(String name, Integer distance) {
		AdjoinTrain adjoinTrain = new AdjoinTrain();
		adjoinTrain.setName(name);
		adjoinTrain.setDistance(distance);
		return adjoinTrain;
	}

}
