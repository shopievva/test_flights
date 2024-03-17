package com.gridnine.testing.flightFilter;
import com.gridnine.testing.Flight;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterCombine implements FlightFilter {
    private List<FlightFilter> filters;

    public FlightFilterCombine() {
        this.filters = new ArrayList<>();
    }

    public void addFilter(FlightFilter filter) {
        filters.add(filter);
    }

    public void removeFilter(FlightFilter filter) {
        filters.remove(filter);
    }

    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>(flights);
        for (FlightFilter filter : filters) {
            filteredFlights = filter.filterFlights(filteredFlights);
        }
        return filteredFlights;
    }
}
