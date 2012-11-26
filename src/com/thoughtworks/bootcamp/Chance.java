package com.thoughtworks.bootcamp;

public class Chance {

    public static final float COMPLETE_PROBABILITY = 1f;
    private final float value;

    public Chance(float value) {
        this.value = value;
    }

    public Chance not() {
        return new Chance(COMPLETE_PROBABILITY - value);
    }

    @Override
    public boolean equals(Object that) {
        if (that instanceof Chance) {
            return this.value == ((Chance) that).value;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public Chance and(Chance anotherChance) {
        return new Chance(this.value * anotherChance.value);
    }

    public Chance or(Chance anotherChance) {
        return (this.not().and(anotherChance.not())).not();
        //return new Chance(this.value + anotherChance.value - and(anotherChance).value);
    }
}