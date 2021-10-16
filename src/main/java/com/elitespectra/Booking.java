package com.elitespectra;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Booking {

    private final List<String> SEATS;
    private final Map<String, String> BOOKED_SEATS = new HashMap<>();

    public Booking() {
        List<String> seatRows = Stream.of("A", "B", "C")
                .collect(Collectors.toList());
        List<String> seatColumns = Stream.of("1", "2", "3", "4", "5")
                .collect(Collectors.toList());
        SEATS = seatRows.stream()
                .flatMap(seatRow -> seatColumns.stream()
                        .map(seatColumn -> seatRow + seatColumn))
                .collect(Collectors.toList());
    }


    public String allocateSeats(String bookingName, int numberOfSeats) {
        if (numberOfSeats <=0 || numberOfSeats >3 )
            throw new IllegalArgumentException("Number of seats can't be zero or more than 3");

        StringBuilder seatsAllocated = new StringBuilder();

        var seatsAvailable = getAvailableSeats();

        for (int i = 0; i < numberOfSeats; i++) {
            var seatIndex = SEATS.indexOf(seatsAvailable.get(i));
            seatsAllocated.append(SEATS.get(i));
            BOOKED_SEATS.put(seatsAvailable.get(i), bookingName);
            SEATS.set(seatIndex, "R");

        }
        return seatsAllocated.toString();
    }

    public List<String> getAvailableSeats() {
        return SEATS.stream().filter(seat -> !seat.equals("R"))
                .collect(Collectors.toList());
    }

    public Map<String, String> getBOOKED_SEATS() {
        return new TreeMap<>(BOOKED_SEATS);
    }


}
