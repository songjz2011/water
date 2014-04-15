package com.trains.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trains.data.builder.TrainStationBuilder;
import com.trains.domain.TrainStation;

public class TrainsRouteNumberMaxDistanceServiceTest {

	private static List<TrainStation> trainStationList;
	private TrainsRouteNumberMaxDistanceService service;

	@BeforeClass
	public static void beforeClass() {
		TrainStationBuilder builder = new TrainStationBuilder();
		trainStationList = builder.getTrainStationList();
	}

	@Before
	public void before() {
		service = new TrainsRouteNumberMaxDistanceService();
		service.setTrainStationList(trainStationList);
	}
	
	@Test
	public void empty_param_should_has_zero_number() {
		int emptyStartStation = service.getRoutesNumber("", "C", 30);
		assertEquals(0, emptyStartStation);
		int emptyEndStation = service.getRoutesNumber("C", "", 30);
		assertEquals(0, emptyEndStation);
		int emptyMaxDistance = service.getRoutesNumber("C", "C", 0);
		assertEquals(0, emptyMaxDistance);
	}

	@Test
	public void empty_trainstationlist_should_has_zero_number() {
		service.setTrainStationList(null);
		int actualValue = service.getRoutesNumber("C", "C", 30);
		assertEquals(0, actualValue);
	}
	
	@Test
	public void inexistence_trainstation_should_has_zero_number() {
		int actualValue = service.getRoutesNumber("INEXISTENCETRAIN", "C", 30);
		assertEquals(0, actualValue);
	}
	
	@Test
	public void inexistence_route_should_has_zero_number() {
		int actualValue = service.getRoutesNumber("A", "C", 1);
		assertEquals(0, actualValue);
	}
	
	@Test
	public void existence_route_should_has_zero_number() {
		int actualValue = service.getRoutesNumber("C", "C", 30);
		assertEquals(7, actualValue);
	}
	
}
