package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        FlightFilterImpl flightFilter = new FlightFilterImpl();

        List<Flight> flights =  FlightBuilder.createFlights();

        System.out.println("All flights:");
        flightFilter.allFlight(flights);
        System.out.println("-----------------------------------");

        System.out.println("All flights segments:");
        flightFilter.allFlightSegments(flights);
        System.out.println("-----------------------------------");

        System.out.println("Flights with departure before the current time:");
        flightFilter.departureBeforeToTheCurrentTime(flights);

        System.out.println("Flights segments, with arrival date earlier than departure date:");
        flightFilter.segmentsWithTheArrivalDateEarlierThanTheDepartureDate(flights);

        System.out.println("A flights spent more than two hours on the ground:");
        flightFilter.theTotalTimeSpentOnTheGroundExceedsTwoHours(flights);
    }
}