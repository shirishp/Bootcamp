package com.thoughtworks.bootcamp;

import java.util.List;

public class Attendant {
    private List<ParkingLot> parkingLots;

    public Attendant(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Object park(Object car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasFreeSlots()) {
                return parkingLot.park(car);
            }
        }
        throw new ParkingLotFullException();
    }


    public Object unPark(Object token) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.hasCar(token)){
                return parkingLot.unPark(token);
            }
        }
        throw new CarNotFoundException();
    }
}
