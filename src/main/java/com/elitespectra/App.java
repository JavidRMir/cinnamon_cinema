package com.elitespectra;

public class App {

    public static void main(String[] args) {

        Booking booking = new Booking();

        System.out.println(booking.getAvailableSeats());

        booking.allocateSeats("John Doe", 3);
        System.out.println(booking.getBOOKED_SEATS());
        System.out.println(booking.getBOOKED_SEATS());


        System.out.println(booking.getAvailableSeats());
        booking.allocateSeats("Mary Doe", 3);
        System.out.println(booking.getBOOKED_SEATS());

        System.out.println(booking.getAvailableSeats());
        booking.allocateSeats("Lucy", 3);
        System.out.println(booking.getBOOKED_SEATS());


    }
}
