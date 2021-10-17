package com.elitespectra;

import com.elitespectra.helper.RandomStub;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BookingTest {

    Booking booking = new Booking();

    @BeforeEach
    public void setUp() {
        booking.reset();
    }


    @Test
    public void checkAvailableSeatsBeforeAnyBooking() {
        assertEquals(15, booking.getAvailableSeats().size());
    }


    @Test
    public void checkIfOneSeatRequested() {
        // RandomStub will always return 1 in this case
        RandomStub randomNumberOfSeats = new RandomStub(1);
        booking.allocateSeats("John Doe", randomNumberOfSeats.nextInt(3));
        assertEquals(Set.of("A1"), booking.getBOOKED_SEATS().keySet());
    }


    @Test
    public void checkIfTwoSeatsRequested() {
        // RandomStub will always return 2 in this case
        RandomStub randomNumberOfSeats = new RandomStub(2);
        booking.allocateSeats("John Doe", randomNumberOfSeats.nextInt(3));
        assertEquals(Set.of("A1", "A2"), booking.getBOOKED_SEATS().keySet());
    }


    @Test
    public void checkIfThreeSeatsRequested() {
        // RandomStub will always return 3 in this case
        RandomStub randomNumberOfSeats = new RandomStub(3);
        booking.allocateSeats("John Doe", randomNumberOfSeats.nextInt(3));
        assertEquals(Set.of("A1", "A2", "A3"), booking.getBOOKED_SEATS().keySet());
    }


    @Test
    public void checkIfMoreZeroOrLessSeatsRequestedThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                booking.allocateSeats("John Doe", 0));
        assertThrows(IllegalArgumentException.class, () ->
                booking.allocateSeats("John Doe", -2));
    }


    @Test
    public void checkIfMoreThanThreeSeatsRequestedThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                booking.allocateSeats("John Doe", 4));
    }


    @Test
    public void checkIfSeatsRequestedMoreThanAvailableThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
                booking.allocateSeats("John Doe", 16));
    }

}
