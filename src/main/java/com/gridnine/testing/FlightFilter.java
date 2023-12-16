package com.gridnine.testing;

import java.util.List;

public interface FlightFilter {
    void allFlight(List<Flight> flights);

    void allFlightSegments(List<Flight> flights);

    List<Flight> departureBeforeToTheCurrentTime(List<Flight> flights);

    List<Flight> segmentsWithTheArrivalDateEarlierThanTheDepartureDate(List<Flight> flights);

    List<Flight> theTotalTimeSpentOnTheGroundExceedsTwoHours(List<Flight> flights);

}
