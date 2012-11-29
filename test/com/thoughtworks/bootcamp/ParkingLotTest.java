package com.thoughtworks.bootcamp;


import org.junit.Test;

import static junit.framework.Assert.*;

public class ParkingLotTest {
    @Test
    public void shouldParkaVehicleIfSlotsAreAvailable() {
        ParkingLot parkingLot = new ParkingLot(10);
        Object token = parkingLot.park(new Object());
        assertNotNull(token);
    }

    @Test(expected = ParkingLotFullException.class)
    public void shouldNotBeAbleToParkIfSlotsAreNotAvailable() {
        ParkingLot parkingLot = new ParkingLot(0);
        parkingLot.park(new Object());
    }

    @Test
    public void shouldBeAbleToUnParkaParkedCar() {
        ParkingLot parkingLot = new ParkingLot(10);
        Object car = new Object();
        Object token = parkingLot.park(car);
        Object parkedCar = parkingLot.unPark(token);
        assertEquals(car, parkedCar);
    }

    @Test(expected = CarNotFoundException.class)
    public void shouldNotBeAbleToUnParkACarThatWasNeverParked() {
        ParkingLot parkingLot = new ParkingLot(10);
        assertNull(parkingLot.unPark(new Object()));
    }

    @Test
    public void shouldCheckForAvailabilityForSlots() {
        ParkingLot parkingLot = new ParkingLot(0);
        assertFalse(parkingLot.hasFreeSlots());

    }

    @Test
    public void shouldReturnTrueIfCarIsParked() {
        ParkingLot parkingLot = new ParkingLot(1);
        Object token = parkingLot.park(new Object());
        assertTrue(parkingLot.hasCar(token));
    }

    @Test
    public void shouldIndicateIFCarIsNotParked() {
        ParkingLot parkingLot = new ParkingLot(1);
        assertFalse(parkingLot.hasCar(new Object()));
    }


}
