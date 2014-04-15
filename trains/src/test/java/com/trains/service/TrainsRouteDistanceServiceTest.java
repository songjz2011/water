package com.trains.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trains.data.builder.TrainStationBuilder;
import com.trains.domain.TrainStation;

public class TrainsRouteDistanceServiceTest {

	private static List<TrainStation> trainStationList;
	private TrainsRouteDistanceService service;
	
	private String noRoute = "NO SUCH ROUTE";

	@BeforeClass
	public static void beforeClass() {
		TrainStationBuilder builder = new TrainStationBuilder();
		trainStationList = builder.getTrainStationList();
	}
	
	@Before
	public void before() {
		service = new TrainsRouteDistanceService();
		service.setTrainStationList(trainStationList);
	}
	
	@Test
	public void empty_route_should_not_have_distance() {
		String actualDistance = service.getRouteDistance("");
		assertEquals(noRoute, actualDistance);
	}
	
	@Test
	public void empty_trainstationlist_should_not_have_distance() {
		service.setTrainStationList(null);
		String actualDistance = service.getRouteDistance("A-B");
		assertEquals(noRoute, actualDistance);
	}
	
	@Test
	public void inexistence_trainstation_should_not_have_distance() {
		service.setTrainStationList(null);
		String actualDistance = service.getRouteDistance("INEXISTENCETRAIN-B");
		assertEquals(noRoute, actualDistance);
	}
	
	@Test
	public void route_less_two_station_should_not_have_distance() {
		String actualDistance = service.getRouteDistance("A");
		assertEquals(noRoute, actualDistance);
	}
	
	@Test
	public void inexistence_route_should_not_have_distance() {
		String actualDistance = service.getRouteDistance("A-B-D");
		assertEquals(noRoute, actualDistance);
	}
	
	@Test
	public void existence_route_should_have_distance() {
		String actualDistance = service.getRouteDistance("A-B-C");
		assertEquals("9", actualDistance);
	}

}
