package com.elitespectra;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Booking {

    private List<String> SEATS;
    private final Map<String, String> BOOKED_SEATS = new HashMap<>();


    public Booking() {
        reset();
    }

    public void reset() {

        List<String> seatRows = Stream.of("A", "B", "C")
                .collect(Collectors.toList());
        List<String> seatColumns = Stream.of("1", "2", "3", "4", "5")
                .collect(Collectors.toList());

        SEATS = seatRows.stream()
                .flatMap(seatRow -> seatColumns.stream()
                        .map(seatColumn -> seatRow + seatColumn))
                .collect(Collectors.toList());
    }


    public void allocateSeats(String bookingName, int numberOfSeats) {
        if (numberOfSeats <=0 || numberOfSeats >3 )
            throw new IllegalArgumentException("Number of seats can't be zero or more than 3");

        var seatsAvailable = getAvailableSeats();

        if (numberOfSeats > seatsAvailable.size())
            throw new IllegalArgumentException(numberOfSeats + " seats requested. Only " +
                    seatsAvailable.size() + " seat(s) available");

        for (int i = 0; i < numberOfSeats; i++) {
            var seatIndex = SEATS.indexOf(seatsAvailable.get(i));
            BOOKED_SEATS.put(seatsAvailable.get(i), bookingName);
            SEATS.set(seatIndex, "");
        }
    }

    public List<String> getAvailableSeats() {
        return SEATS.stream().filter(seat -> !seat.equals(""))
                .collect(Collectors.toList());
    }

    public Map<String, String> getBOOKED_SEATS() {
        return new TreeMap<>(BOOKED_SEATS);
    }


}
