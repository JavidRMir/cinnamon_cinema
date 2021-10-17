package com.elitespectra;

import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) {

        Booking booking = new Booking();

        var bookingNameList = List.of(
                "John", "Mary", "Lucy", "Steve", "Peter", "Ann");

        int numberOfSeats;
        int bookingNameIndex;

        while (booking.getAvailableSeats().size() > 0) {

            bookingNameIndex = new Random().nextInt(bookingNameList.size());
            numberOfSeats = new Random().nextInt(3) + 1;

            try {
                booking.allocateSeats(bookingNameList.get(bookingNameIndex), numberOfSeats);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                break;
            }

        }

        System.out.println("Seats Booked: " + booking.getBOOKED_SEATS());

    }
}
