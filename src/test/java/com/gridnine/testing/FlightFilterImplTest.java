package com.gridnine.testing;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterImplTest {

    private final List<Flight> flights = new ArrayList<>(

    );
    private final FlightFilter flightFilter = new FlightFilterImpl();
    LocalDateTime time = LocalDateTime.now();

    @Test
    @DisplayName("Test of the deviation display method for the current time.")
    public void departureBeforeToTheCurrentTimeTest() {
        Segment segment = new Segment(time.minusDays(3),time);
        List<Segment> segments = new ArrayList<>();
        segments.add(segment);
        Flight flight = new Flight(segments);
        flights.add(flight);
        List<Flight> expected = flightFilter.departureBeforeToTheCurrentTime(flights);
        Assertions.assertEquals(expected,flights);
    }

    @Test
    @DisplayName("Test of the method of displaying flights with arrival date earlier than departure date. ")
    public void segmentsWithTheArrivalDateEarlierThanTheDepartureDateTest() {
        Segment segment = new Segment(time,time.minusHours(1));
        List<Segment> segments = new ArrayList<>();
        segments.add(segment);
        Flight flight = new Flight(segments);
        flights.add(flight);
        List<Flight> expected = flightFilter.segmentsWithTheArrivalDateEarlierThanTheDepartureDate(flights);
        Assertions.assertEquals(expected,flights);
    }

    @Test
    @DisplayName("Method test for filtering flights with a total time on the ground of more than two hours")
    public void theTotalTimeSpentOnTheGroundExceedsTwoHoursTest() {
        Segment segment1 = new Segment(time, time.plusHours(2));
        Segment segment2 = new Segment(time.plusHours(5), time.plusHours(6));
        List<Segment> segments = new ArrayList<>();
        segments.add(segment1);
        segments.add(segment2);
        Flight flight = new Flight(segments);
        flights.add(flight);
        List<Flight> expected = flightFilter.theTotalTimeSpentOnTheGroundExceedsTwoHours(flights);
        Assertions.assertEquals(expected,flights);
    }
}