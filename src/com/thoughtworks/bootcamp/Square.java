package com.thoughtworks.bootcamp;

public class Square {

    private final float width;
    private final float height;

    public Square(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getArea() {
        return width * height;
    }

    public float getPerimeter() {
        return 2 * (width + height);
    }
}
