import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class FunctionUtil {

    //todo: Check this helper to calculate nights per reservations given checkIn/checkout. (don't modify)
    public static BiFunction<LocalDateTime, LocalDateTime, Long> diff = (cIn, cOut) ->
            ChronoUnit.DAYS.between(cIn, cOut);

    //todo: Hint:Implement this helper function. Feel free to use it in your functions if you like.
    /**
     * Convert list of persons to list of passengers
     */
    static Function<List<Person>, List<Passenger>> personsToPassengers = persons ->
            persons.stream()
                    .flatMap(p -> p.getRoles().stream())
                    .filter(p -> p instanceof Passenger)
                    .map(pa -> (Passenger) pa)
                    .collect(Collectors.toList());

    //todo: Implement the following function
    /**
     * Finds persons who stayed at a hotel during a year such that their first name starts with a prefix
     *
     * @param persons List of persons
     * @param prefix  a string to be matched against the prefix of the person first name
     * @param hotelName  name of the hotel
     * @param year  year of the reservation
     * @return list of capitalized last names of persons whose name begins with prefix
     * and have stayed at hotelName during a certain year.
     */
    static QuadFunction<List<Person>, String, String, Integer, List<String>> peopleWithFirstNameWhoReservedAtHotel =
            (persons, prefix, hotelName, year) ->
                    personsToPassengers.apply(persons).stream()
                            .flatMap(res -> res.getReservations().stream())
                            .filter(name -> name.getHotel().getName().equals(hotelName))
                            .filter(y -> y.getCheckIn().getYear() == year)
                            .filter(name -> name.getPassenger().getPerson().getFirstName().startsWith(prefix))
                            .map(cap -> cap.getPassenger().getPerson().getLastName().toUpperCase())
                            .distinct()
                            .collect(Collectors.toList());

    //todo: Implement the following function
    /**
     * A VIP is a person who reserves a suite and stays for a large number of nights overall, possibly
     * across several suite reservations.
     * Return the first names of VIPs who stayed at a specific hotel at least K nights overall.
     * The result should be sorted by the number of nights each VIP stayed at that hotel.
     * Nights per reservation are defined as the difference in days between checkIn and checkOut dates.
     *
     * @param persons List of persons
     * @param hotelName name of the hotel
     * @param year   year of reservation(s)
     * @param k   number of nights. VIP must stay number of nights >=k across his VIP reservations to be considered
     * @return list of VIP first names
     */
    static QuadFunction<List<Person>, String, Integer, Long, List<String>> vipPersonsWhoStayedAtLeastKNights =
            (persons, hotelName, year, k) ->
                    personsToPassengers.apply(persons).stream()
                            .flatMap(res -> res.getReservations().stream())
                            .filter(name -> name.getHotel().getName().equals(hotelName))
                            .filter(y -> y.getCheckIn().getYear() == year)
                            .filter(y -> y.isSuite() == true)
                            .collect(Collectors.groupingBy(rr -> rr.getPassenger().getPerson(),
                                    Collectors.summingLong(rr -> diff.apply(rr.getCheckIn(),rr.getCheckOut()))))
                            .entrySet()
                            .stream()
                            .filter(rr -> rr.getValue() >= k)
                            .sorted((e1,e2) -> (int)(e2.getValue() - e1.getValue()))
                            .map(m -> m.getKey().getFirstName())
                            //.distinct()
                            .collect(Collectors.toList());
}

