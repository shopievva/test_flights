package com.gridnine.testing.flightFilter.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.flightFilter.FlightFilter;

import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterInvalidSegments implements FlightFilter {
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        return flights.stream()
                .filter(flight -> flight.getSegments().stream()
                        .noneMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
