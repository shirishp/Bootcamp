package com.thoughtworks.bootcamp;

public class Rectangle {
    private int length;
    private int breadth;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }

    public int area() {
        return length * breadth;
    }

    public int perimeter() {
        return 2 * (length + breadth);
    }

}
