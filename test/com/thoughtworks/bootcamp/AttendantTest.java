package com.thoughtworks.bootcamp;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.*;

public class AttendantTest {
    @Test
    public void shouldBeAbleToParkCar() {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(1));
        Attendant attendant = new Attendant(parkingLots);
        Object token = attendant.park(new Object());
        assertNotNull(token);
    }

    @Test
    public void shouldBeAbleToParkAACarInTheNextLotIfFirstIsFull() {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        ParkingLot two = new ParkingLot(1);
        parkingLots.add(two);
        Attendant attendant = new Attendant(parkingLots);
        attendant.park(new Object());
        assertFalse(two.hasFreeSlots());
    }

    @Test(expected = ParkingLotFullException.class)
    public void shouldNotBeAbleToParkIfAllSlotsAreFull() {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(0));
        Attendant attendant = new Attendant(parkingLots);
        attendant.park(new Object());
    }

    @Test
    public void shouldBeAbleToUnParkFromWhereverCarWasParked() {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(1));
        Attendant attendant = new Attendant(parkingLots);
        Object car = new Object();
        Object token = attendant.park(car);
        Object parkedCar = attendant.unPark(token);
        assertEquals(car, parkedCar);
    }

    @Test(expected = CarAlreadyParkedException.class)
    public void shouldNoBeAbleToParkSameCarTwice() {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(2));
        Attendant attendant = new Attendant(parkingLots);
        Object car = new Object();
        attendant.park(car);
        attendant.park(car);
    }

    @Test(expected = CarNotFoundException.class)
    public void shouldNoBeAbleToUnParkSameCarTwice() {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(1));
        Attendant attendant = new Attendant(parkingLots);
        Object car = new Object();
        Object token = attendant.park(car);
        Object parkedCar = attendant.unPark(token);
        assertEquals(car, parkedCar);
        attendant.unPark(token);
    }

    @Test(expected = CarNotFoundException.class)
    public void shouldNotBeAbleToUnParkIfCarWasNeverParked() {
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot(0));
        parkingLots.add(new ParkingLot(0));
        Attendant attendant = new Attendant(parkingLots);
        Object car = new Object();
        attendant.unPark(car);
    }


}
