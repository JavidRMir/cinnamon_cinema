package com.elitespectra;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BookingTest {

    Booking booking = new Booking();

    @Test
    public void checkAvailableSeatsBeforeAnyBooking() {
        assertEquals(15, booking.getAvailableSeats().size());
    }

    @Test
    public void checkIfOneSeatRequested() {
        assertEquals("A1", booking.allocateSeats("John Doe", 1));
    }

    @Test
    public void checkIfTwoSeatsRequested() {
        assertEquals("A1A2", booking.allocateSeats("John Doe",2));
    }

    @Test
    public void checkIfThreeSeatsRequested() {
        assertEquals("A1A2A3", booking.allocateSeats("John Doe",3));
    }

    @Test
    public void checkIfMoreThanThreeSeatsRequestedThrowsException(){
        assertThrows(IllegalArgumentException.class, () ->
                booking.allocateSeats("John Doe",0));
        assertThrows(IllegalArgumentException.class, () ->
                booking.allocateSeats("John Doe",4));
    }
}
