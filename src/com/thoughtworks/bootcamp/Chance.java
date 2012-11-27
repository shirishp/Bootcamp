package com.thoughtworks.bootcamp;


public class Chance {

    public static final float CERTAIN = 1;
    private float value;

    public Chance(float value) {
        this.value = value;
    }

    public Chance not() {
        return new Chance(CERTAIN - value);
    }

    public Chance and(Chance anotherChance) {
        return new Chance(this.value * anotherChance.value);
    }

    //P(A||B) = P(A) + P(B) - P(A)*P(B)
    public Chance or(Chance anotherChance) {
        return this.not().and(anotherChance.not()).not();
    }

    @Override
    public boolean equals(Object anotherChance) {
        if (this == anotherChance) return true;
        if (anotherChance == null || getClass() != anotherChance.getClass()) return false;

        Chance chance = (Chance) anotherChance;

        if (Float.compare(chance.value, value) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (value != +0.0f ? Float.floatToIntBits(value) : 0);
    }


    @Override
    public String toString() {
        return String.valueOf(value);
    }


}
