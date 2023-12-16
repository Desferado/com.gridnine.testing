package com.gridnine.testing;

import java.util.List;

public interface FlightFilter {
    void allFlightSegments(List<Flight> flights);

    List<Flight> departureToTheCurrentTime(List<Flight> flights);

    List<Flight> segmentsWithTheArrivalDateEarlierThanTheDepartureDate(List<Flight> flights);

    List<Flight> theTotalTimeSpentOnTheGroundExceedsTwoHours(List<Flight> flights);

}
