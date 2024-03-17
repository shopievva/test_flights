import com.gridnine.testing.Flight;
import com.gridnine.testing.Segment;
import com.gridnine.testing.flightFilter.impl.FlightFilterBeforeNow;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlightFilterBeforeNowTest {

    @Test
    public void testFilterFlights() {
        FlightFilterBeforeNow flightFilter = new FlightFilterBeforeNow();

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(List.of(new Segment(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2)))));
        flights.add(new Flight(List.of(new Segment(LocalDateTime.now().minusHours(1), LocalDateTime.now().minusMinutes(30)))));
        flights.add(new Flight(List.of(new Segment(LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(2)))));

        List<Flight> filteredFlights = flightFilter.filterFlights(flights);

        assertEquals(2, filteredFlights.size());
    }
}
