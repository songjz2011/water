package com.trains.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trains.data.builder.TrainStationBuilder;
import com.trains.domain.TrainStation;

public class TrainsRouteNumberMaxStopServiceTest {

	private static List<TrainStation> trainStationList;
	private TrainsRouteNumberMaxStopService service;

	@BeforeClass
	public static void beforeClass() {
		TrainStationBuilder builder = new TrainStationBuilder();
		trainStationList = builder.getTrainStationList();
	}

	@Before
	public void before() {
		service = new TrainsRouteNumberMaxStopService();
		service.setTrainStationList(trainStationList);
	}

	@Test
	public void empty_param_should_has_zero_trip() {
		int emptyStartStation = service.getTripsNumber("", "C", 3);
		assertEquals(0, emptyStartStation);
		int emptyEndStation = service.getTripsNumber("C", "", 3);
		assertEquals(0, emptyEndStation);
		int emptyMaxTrips = service.getTripsNumber("C", "C", 0);
		assertEquals(0, emptyMaxTrips);
	}

	@Test
	public void empty_trainstationlist_should_has_zero_trip() {
		service.setTrainStationList(null);
		int actualValue = service.getTripsNumber("C", "C", 3);
		assertEquals(0, actualValue);
	}

	@Test
	public void inexistence_trainstation_should_has_zero_trip() {
		int actualValue = service.getTripsNumber("INEXISTENCETRAIN", "C", 3);
		assertEquals(0, actualValue);
	}

	@Test
	public void inexistence_route_should_has_zero_trip() {
		int actualValue = service.getTripsNumber("A", "C", 1);
		assertEquals(0, actualValue);
	}

	@Test
	public void existence_route_should_has_trips() {
		int actualValue = service.getTripsNumber("A", "C", 2);
		assertEquals(2, actualValue);
	}

}
