import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    StationIndex stationIndex;
    List<Station> connectionStations;

    Line line1 = new Line(1, "Первая");
    Line line2 = new Line(2, "Вторая");
    Line line3 = new Line(2, "Третья");


    Station s11 ;
    Station s21 ;
    Station s31 ;
    Station s41 ;
    Station s51 ;

    Station s12 ;
    Station s22 ;
    Station s32 ;
    Station s42 ;

    Station s13 ;
    Station s23 ;
    Station s33 ;
    Station s43 ;


    @Override
    protected void setUp() throws Exception {
         route = new ArrayList<>();
         stationIndex = new StationIndex();
         connectionStations  = new ArrayList<>();

         route.add(new Station("Петровская", line1));
         route.add(new Station("Арбузная", line1));
         route.add(new Station("Морковная", line2));
         route.add(new Station("Яблочная", line2));


         s11 = new Station("Петровская", line1);
         s21 = new Station("Арбузная", line1);
         s31 = new Station("Советская", line1);
         s41 = new Station("Комсомольская", line1);
         s51 = new Station("Пересадочная", line1);

         s12 = new Station("Мультяшная", line2);
         s22 = new Station("Угольная", line2);
         s32 = new Station("Дверная", line2);
         s42 = new Station("Мониторная", line2);

         s13 = new Station("Студенческая", line3);
         s23 = new Station("Окольная", line3);
         s33 = new Station("Футбольная", line3);
         s43 = new Station("Зеркальная", line3);

         line1.addStation(s11);
         line1.addStation(s21);
         line1.addStation(s31);
         line1.addStation(s41);
         line1.addStation(s51);

         stationIndex.addStation(s11);
         stationIndex.addStation(s21);
         stationIndex.addStation(s31);
         stationIndex.addStation(s41);

         line2.addStation(s12);
         line2.addStation(s22);
         line2.addStation(s32);
         line2.addStation(s42);

         stationIndex.addStation(s12);
         stationIndex.addStation(s22);
         stationIndex.addStation(s32);
         stationIndex.addStation(s42);

        line3.addStation(s13);
        line3.addStation(s23);
        line3.addStation(s33);
        line3.addStation(s43);

        stationIndex.addStation(s13);
        stationIndex.addStation(s23);
        stationIndex.addStation(s33);
        stationIndex.addStation(s43);

         connectionStations.add(s51);
         connectionStations.add(s22);

         stationIndex.addConnection(connectionStations);

         connectionStations.clear();

        connectionStations.add(s32);
        connectionStations.add(s43);

        stationIndex.addConnection(connectionStations);

    }
    public void testCalculateDuration()
    {
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 8.5;
        assertEquals(expected, actual);
    }
    public void testGetRouteOnTheLine()
    {  RouteCalculator calculator = new RouteCalculator(stationIndex);
       List<Station> shortestRoute = calculator.getShortestRoute(s21, s23);

       String initialStation = shortestRoute.get(0).getName();
       String finalStation = shortestRoute.get(shortestRoute.size() - 1).getName();

       shortestRoute.forEach(f -> System.out.println(f));

       assertEquals( "Арбузная", initialStation);
       assertEquals( "Окольная", finalStation);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
