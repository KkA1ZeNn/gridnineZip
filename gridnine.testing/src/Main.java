import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("Все перелеты:");
        printFlights(flights);

        FlightFilter departureBeforeNowFilter = new DepartureBeforeNowFilter();
        FlightFilter arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
        FlightFilter groundTimeExceedsTwoHoursFilter = new GroundTimeExceedsTwoHoursFilter();

        System.out.println("\nВылеты до текущего момента времени:");
        printFlights(departureBeforeNowFilter.filter(flights));

        System.out.println("\nИмеются сегменты с датой прилёта раньше даты вылета:");
        printFlights(arrivalBeforeDepartureFilter.filter(flights));

        System.out.println("\nОбщее время, проведённое на земле превышает два часа :");
        printFlights(groundTimeExceedsTwoHoursFilter.filter(flights));
    }

    private static void printFlights(List<Flight> flights) {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
        } else {
            flights.forEach(System.out::println);
        }
    }
}