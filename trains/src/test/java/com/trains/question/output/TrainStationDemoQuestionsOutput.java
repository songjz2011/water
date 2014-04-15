package com.trains.question.output;

import java.util.List;

import com.trains.data.builder.TrainStationBuilder;
import com.trains.domain.TrainStation;
import com.trains.service.TrainsRouteDistanceService;
import com.trains.service.TrainsRouteNumberExactlyStopService;
import com.trains.service.TrainsRouteNumberMaxDistanceService;
import com.trains.service.TrainsRouteNumberMaxStopService;
import com.trains.service.TrainsRouteShortestDistanceService;

public class TrainStationDemoQuestionsOutput {

    private List<TrainStation> trainStationList;

    public TrainStationDemoQuestionsOutput() {
        init();
    }

    private void init() {
        TrainStationBuilder builder = new TrainStationBuilder();
        trainStationList = builder.getTrainStationList();
    }

    public void calculate_distance_of_route_for_given_questions_1_5() {
        TrainsRouteDistanceService service = new TrainsRouteDistanceService();
        service.setTrainStationList(trainStationList);
        String[] routes = new String[] {"A-B-C", "A-D", "A-D-C", "A-E-B-C-D", "A-E-D"};
        for (int i = 0; i < routes.length; i++) {
            print(String.valueOf(i + 1), service.getRouteDistance(routes[i]));
        }
    }

    public void calculate_number_of_trips_for_given_questions_6() {
        TrainsRouteNumberMaxStopService service = new TrainsRouteNumberMaxStopService();
        service.setTrainStationList(trainStationList);
        int result = service.getTripsNumber("C", "C", 3);
        print("6", String.valueOf(result));
    }

    public void calculate_number_of_trips_for_given_questions_7() {
        TrainsRouteNumberExactlyStopService service = new TrainsRouteNumberExactlyStopService();
        service.setTrainStationList(trainStationList);
        int result = service.getTripsNumber("A", "C", 4);
        print("7", String.valueOf(result));
    }

    public void calculate_length_of_shortest_route_for_given_questions_8_9() {
        TrainsRouteShortestDistanceService service = new TrainsRouteShortestDistanceService();
        service.setTrainStationList(trainStationList);
        Integer question8Result = service.getShorestDistance("A", "C");
        print("8", question8Result.toString());
        Integer question9Result = service.getShorestDistance("B", "B");
        print("9", question9Result.toString());
    }

    public void calculate_number_of_different_routes_for_given_questions_10() {
        TrainsRouteNumberMaxDistanceService service = new TrainsRouteNumberMaxDistanceService();
        service.setTrainStationList(trainStationList);
        int result = service.getRoutesNumber("C", "C", 30);
        print("10", String.valueOf(result));
    }

    private void print(String questionNumber, String result) {
        System.out.println("Output #" + questionNumber + ": " + result);
    }

    public static void main(String[] args) {
        TrainStationDemoQuestionsOutput output = new TrainStationDemoQuestionsOutput();
        output.calculate_distance_of_route_for_given_questions_1_5();
        output.calculate_number_of_trips_for_given_questions_6();
        output.calculate_number_of_trips_for_given_questions_7();
        output.calculate_length_of_shortest_route_for_given_questions_8_9();
        output.calculate_number_of_different_routes_for_given_questions_10();
    }

}
