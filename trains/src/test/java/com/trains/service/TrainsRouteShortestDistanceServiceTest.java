package com.trains.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trains.data.builder.TrainStationBuilder;
import com.trains.domain.TrainStation;

public class TrainsRouteShortestDistanceServiceTest {

	private static List<TrainStation> trainStationList;
	private TrainsRouteShortestDistanceService service;

	@BeforeClass
	public static void beforeClass() {
		TrainStationBuilder builder = new TrainStationBuilder();
		trainStationList = builder.getTrainStationList();
	}

	@Before
	public void before() {
		service = new TrainsRouteShortestDistanceService();
		service.setTrainStationList(trainStationList);
	}
	
	@Test
	public void empty_param_should_has_not_shortest_distance() {
		Integer emptyStartStation = service.getShorestDistance("A", "");
		assertNull(emptyStartStation);
		Integer emptyEndStation = service.getShorestDistance("", "C");
		assertNull(emptyEndStation);
	}

	@Test
	public void empty_trainstationlist_should_has_not_shortest_distance() {
		service.setTrainStationList(null);
		Integer actualValue = service.getShorestDistance("A", "C");
		assertNull(actualValue);
	}
	
	@Test
	public void inexistence_trainstation_should_has_not_shortest_distance() {
		Integer actualValue = service.getShorestDistance("INEXISTENCETRAIN", "C");
		assertNull(actualValue);
	}
	
	@Test
	public void existence_route_should_has_shortest_distance() {
		Integer actualValue = service.getShorestDistance("A", "C");
		assertEquals(9, actualValue.intValue());
	}
	
}
