package com.trains.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trains.data.builder.TrainStationBuilder;

public class TrainStationTest {
	
	private static TrainStationBuilder builder;

	private TrainStation station;
	
	@BeforeClass
	public static void beforeClass() {
		builder = new TrainStationBuilder();
	}
	
	@Before
	public void before() {
		station = builder.getTrainStationA();
	}
	
	@Test
	public void empty_adjointrainlist_should_not_has_distance() {
		station.setAdjoinStationList(null);
		Integer actualDistance = station.getAdjoinDistance("B");
		assertNull(actualDistance);
	}
	
	@Test
	public void empty_param_adjointrainname_should_not_has_distance() {
		Integer actualDistance = station.getAdjoinDistance("");
		assertNull(actualDistance);
	}
	
	@Test
	public void inexistence_adjointrain_should_not_has_distance() {
		Integer actualDistance = station.getAdjoinDistance("C");
		assertNull(actualDistance);
	}
	
	@Test
	public void existence_adjointrain_should_has_distance() {
		Integer actualDistance = station.getAdjoinDistance("B");
		assertNotNull(actualDistance);
	}
	
}
