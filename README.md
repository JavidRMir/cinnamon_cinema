# Cinnamon Cinema Movie Theatre

## Introduction

A team of professionals is tasked with the development of a program to allocate tickets to customers purchasing tickets for a movie theatre.  

## Problem
Allocate seats to customers from the total of 15 seats arranged in 3 rows and 5 columns.

## Solution
Develop a booking system that will be in charge of booking, allocating and recording each seat allocation.

## Requirements
🧋 a customer should be able to request some tickets

🧋 a customer can request a number of seats between 1 and 3 for a movie

🧋 a customer should be allocated the required number of seats
   from the available seats on the seating plan starting from seat A1 and filling the auditorium from
   left to right, front to back

🧋 all seats are available for sale when the program starts


## Validations
🧋 Number of seats to be booked per booking can't be zero, negative or more than 3.


## Execution
🧋 Create and run unit tests in BookingTest.

🧋 Implement the unit tests and other logic in the Booking class.

🧋 Booking class contains all the code to book each seat and record it accordingly.

🧋 App class runs an instance of Booking class to allocate seats between 1 and 3
   selected randomly.

🧋 once the seats are allocated the program terminates.

