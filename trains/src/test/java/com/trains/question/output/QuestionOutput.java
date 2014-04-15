package com.trains.question.output;

import java.util.List;

import org.junit.Test;

import com.trains.data.builder.TrainStationBuilder;
import com.trains.domain.TrainStation;
import com.trains.service.TrainsRouteDistanceService;
import com.trains.service.TrainsRouteNumberExactlyStopService;
import com.trains.service.TrainsRouteNumberMaxDistanceService;
import com.trains.service.TrainsRouteNumberMaxStopService;
import com.trains.service.TrainsRouteShortestDistanceService;

public class QuestionOutput {

	private List<TrainStation> trainStationList;

	public QuestionOutput() {
		init();
	}

	private void init() {
		TrainStationBuilder builder = new TrainStationBuilder();
		trainStationList = builder.getTrainStationList();
	}

	public void question1_5() {
		TrainsRouteDistanceService service = new TrainsRouteDistanceService();
		service.setTrainStationList(trainStationList);
		String[] routes = new String[] { "A-B-C", "A-D", "A-D-C", "A-E-B-C-D", "A-E-D" };
		for (int i = 0; i < routes.length; i++) {
			print(String.valueOf(i + 1), service.getRouteDistance(routes[i]));
		}
	}

	public void question6() {
		TrainsRouteNumberMaxStopService service = new TrainsRouteNumberMaxStopService();
		service.setTrainStationList(trainStationList);
		int result = service.getTripsNumber("C", "C", 3);
		print("6", String.valueOf(result));
	}

	public void question7() {
		TrainsRouteNumberExactlyStopService service = new TrainsRouteNumberExactlyStopService();
		service.setTrainStationList(trainStationList);
		int result = service.getTripsNumber("A", "C", 4);
		print("7", String.valueOf(result));
	}

	public void question8_9() {
		TrainsRouteShortestDistanceService service = new TrainsRouteShortestDistanceService();
		service.setTrainStationList(trainStationList);
		Integer question8Result = service.getShorestDistance("A", "C");
		print("8", question8Result.toString());
		Integer question9Result = service.getShorestDistance("B", "B");
		print("9", question9Result.toString());
	}
	public void question10() {
		TrainsRouteNumberMaxDistanceService service = new TrainsRouteNumberMaxDistanceService();
		service.setTrainStationList(trainStationList);
		int result = service.getRoutesNumber("C", "C", 30);
		print("10", String.valueOf(result));
	}

	private void print(String questionNumber, String result) {
		System.out.println("Output #" + questionNumber + ": " + result);
	}

	@Test
	public void output() {
		QuestionOutput output = new QuestionOutput();
		output.question1_5();
		output.question6();
		output.question7();
		output.question8_9();
		output.question10();
	}

	public static void main(String[] args) {
		QuestionOutput output = new QuestionOutput();
		output.question1_5();
		output.question6();
		output.question7();
		output.question8_9();
		output.question10();
	}

}
