package com.gridnine.testing;

import com.gridnine.testing.flightFilter.FlightFilterCombine;
import com.gridnine.testing.flightFilter.impl.FlightFilterBeforeNow;
import com.gridnine.testing.flightFilter.impl.FlightFilterInvalidSegments;
import com.gridnine.testing.flightFilter.impl.FlightFilterLongGroundTime;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();

        FlightFilterCombine compositeFilter = new FlightFilterCombine();
        compositeFilter.addFilter(new FlightFilterBeforeNow());
        compositeFilter.addFilter(new FlightFilterInvalidSegments());
        compositeFilter.addFilter(new FlightFilterLongGroundTime());

        List<Flight> filteredFlights = compositeFilter.filterFlights(flights);

        System.out.println("Filtered Flights:");
        filteredFlights.forEach(System.out::println);
    }
}