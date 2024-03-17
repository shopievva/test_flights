import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import com.gridnine.testing.flightFilter.impl.FlightFilterInvalidSegments;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterInvalidSegmentsTest {

    @Test
    public void testFilterFlights(){
        FlightFilterInvalidSegments flightFilter = new FlightFilterInvalidSegments();

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(2)))));
        flights.add(new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().minusHours(1)))));
        flights.add(new Flight(List.of(new Segment(LocalDateTime.now(), LocalDateTime.now().plusDays(1)))));

        List<Flight> filteredFlights = flightFilter.filterFlights(flights);

        assertEquals(2, filteredFlights.size());


    }
}
