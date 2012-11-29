package com.thoughtworks.bootcamp;


import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private int size;
    private Map<Object, Object> occupiedSlots;

    public ParkingLot(int size) {
        this.size = size;
        occupiedSlots = new HashMap<Object, Object>(size);
    }

    public Object park(Object car) {
        if (!hasFreeSlots()) throw new ParkingLotFullException();
        if (occupiedSlots.values().contains(car)) throw new CarAlreadyParkedException();
        Object token = new Object();
        occupiedSlots.put(token, car);
        return token;
    }

    public Object unPark(Object token) {
        if (!occupiedSlots.containsKey(token)) throw new CarNotFoundException();
        return occupiedSlots.remove(token);
    }

    public boolean hasFreeSlots() {
        return (occupiedSlots.size() < size);

    }

    public boolean hasCar(Object token) {
        return occupiedSlots.containsKey(token);
    }
}
