import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import com.gridnine.testing.flightFilter.impl.FlightFilterLongGroundTime;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterLongGroundTimeTest {

    @Test
    public void testFilterFlights(){
        FlightFilterLongGroundTime flightFilter = new FlightFilterLongGroundTime();

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(4), LocalDateTime.now().plusHours(5)))));
        flights.add(new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(2), LocalDateTime.now().plusHours(3)))));
        flights.add(new Flight(List.of(
                new Segment(LocalDateTime.now(), LocalDateTime.now().plusHours(1)),
                new Segment(LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(4)),
                new Segment((LocalDateTime.now().plusHours(5)), LocalDateTime.now().plusHours(6)))));

        List<Flight> filteredFlights = flightFilter.filterFlights(flights);

        assertEquals(1, filteredFlights.size());
    }

}
