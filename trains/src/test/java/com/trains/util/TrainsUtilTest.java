package com.trains.util;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.trains.data.builder.TrainStationBuilder;
import com.trains.domain.TrainStation;

public class TrainsUtilTest {

	private static List<TrainStation> trainStationList;
	
	@BeforeClass
	public static void beforeClass() {
		TrainStationBuilder builder = new TrainStationBuilder();
		trainStationList = builder.getTrainStationList();
	}

	@Test
	public void empty_inputparam_should_not_findTrainStationByName() {
		TrainStation emptyName = TrainsUtil.findTrainStationByName(null, trainStationList);
		assertNull(emptyName);
		TrainStation emptyTrain = TrainsUtil.findTrainStationByName("A", null);
		assertNull(emptyTrain);
	}
	
	@Test
	public void inexistence_train_should_not_findTrainStationByName() {
		TrainStation station = TrainsUtil.findTrainStationByName("INEXISTENCETRAIN", trainStationList);
		assertNull(station);
	}
	
	@Test
	public void existence_train_should_findTrainStationByName() {
		TrainStation station = TrainsUtil.findTrainStationByName("A", trainStationList);
		assertNotNull(station);
	}

}
