package com.trains.question.output;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.trains.data.builder.TrainStationBuilder;
import com.trains.domain.TrainStation;
import com.trains.service.TrainsRouteDistanceService;

public class QuestionOutput {

	private List<TrainStation> trainStationList;

	public QuestionOutput() {
		init();
	}

	private void init() {
		TrainStationBuilder builder = new TrainStationBuilder();
		trainStationList = new ArrayList<TrainStation>();

		trainStationList.add(builder.getTrainStationA());
		trainStationList.add(builder.getTrainStationB());
		trainStationList.add(builder.getTrainStationC());
		trainStationList.add(builder.getTrainStationD());
		trainStationList.add(builder.getTrainStationE());
	}

	public void question1_6() {
		TrainsRouteDistanceService service = new TrainsRouteDistanceService();
		service.setTrainStationList(trainStationList);
		String[] routes = new String[] { "A-B-C", "A-D", "A-D-C", "A-E-B-C-D", "A-E-D" };
		for (int i = 0; i < routes.length; i++) {
			print(String.valueOf(i + 1), service.getRouteDistance(routes[i]));
		}
	}

	private void print(String questionNumber, String result) {
		System.out.println("Output #" + questionNumber + ": " + result);
	}
	
	@Test
	public void output() {
		QuestionOutput output = new QuestionOutput();
		output.question1_6();
	}
	
	public static void main(String[] args) {
		QuestionOutput output = new QuestionOutput();
		output.question1_6();
	}

}
