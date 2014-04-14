package com.trains.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trains.data.builder.TrainStationBuilder;
import com.trains.domain.TrainStation;

public class TrainsRouteDistanceServiceTest {

	private static List<TrainStation> trainStationList;
	private TrainsRouteDistanceService service;

	@BeforeClass
	public static void beforeClass() {
		TrainStationBuilder builder = new TrainStationBuilder();
		trainStationList = new ArrayList<TrainStation>();

		trainStationList.add(builder.getTrainStationA());
		trainStationList.add(builder.getTrainStationB());
		trainStationList.add(builder.getTrainStationC());
		trainStationList.add(builder.getTrainStationD());
		trainStationList.add(builder.getTrainStationE());
		
	}
	
	@Before
	public void before() {
		service = new TrainsRouteDistanceService();
	}
	
	@Test
	public void empty_route_should_not_has_distance() {
		service.setTrainStationList(trainStationList);
		String actualDistance = service.getRouteDistance("");
		assertEquals("NO SUCH ROUTE", actualDistance);
	}
	
	@Test
	public void empty_trainstation_should_not_has_distance() {
		String actualDistance = service.getRouteDistance("A-B");
		assertEquals("NO SUCH ROUTE", actualDistance);
	}
	
	@Test
	public void route_less_two_station_should_not_has_distance() {
		service.setTrainStationList(trainStationList);
		String actualDistance = service.getRouteDistance("A");
		assertEquals("NO SUCH ROUTE", actualDistance);
	}
	
	@Test
	public void inexistence_route_should_not_has_distance() {
		service.setTrainStationList(trainStationList);
		String actualDistance = service.getRouteDistance("A-B-D");
		assertEquals("NO SUCH ROUTE", actualDistance);
	}
	
	@Test
	public void inexistence_route_should_has_distance() {
		service.setTrainStationList(trainStationList);
		String actualDistance = service.getRouteDistance("A-B-C");
		assertEquals("9", actualDistance);
	}

}
