package com.gridnine.testing.flightFilter.impl;

import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import com.gridnine.testing.flightFilter.FlightFilter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterLongGroundTime implements FlightFilter {
    @Override
    public List<Flight> filterFlights(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        int duration = 2;
        LocalDateTime arrivalDate = null;
        for (Flight flight: flights){
            boolean isFirst = true;
            Long sumTimeOnTheGround = 0L;
            for(Segment segment: flight.getSegments()){
                if(isFirst){
                    arrivalDate = segment.getArrivalDate();
                    isFirst = false;
                    continue;
                }
                Long groundTime = (long) (segment.getDepartureDate().getHour() - arrivalDate.getHour());
                arrivalDate = segment.getArrivalDate();
                sumTimeOnTheGround = sumTimeOnTheGround + groundTime;

            }
            if(sumTimeOnTheGround <= duration){
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }

}
