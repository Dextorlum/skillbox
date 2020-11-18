import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        int currHour = c.get(Calendar.HOUR)+2;

        c.set(Calendar.HOUR, currHour);

        Date dateBefore = c.getTime();
        Date dateCurr =  new Date ();

        System.out.println(dateBefore);

        Airport airport = Airport.getInstance();

        airport.getTerminals()
                .stream()
                 .map(t -> t.getFlights())
                 .flatMap(List::stream)
                 .filter(f -> f.getDate().after(dateCurr) && f.getDate().before(dateBefore))
                 .forEach(System.out::println)
        ;

    }
}
