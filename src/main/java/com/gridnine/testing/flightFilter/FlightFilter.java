package com.gridnine.testing.flightFilter;

import com.gridnine.testing.Flight;

import java.util.List;

public interface FlightFilter {
    List<Flight> filterFlights(List<Flight> flights);
}
