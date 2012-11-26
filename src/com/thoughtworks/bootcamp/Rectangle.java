package com.thoughtworks.bootcamp;

public class Rectangle {

    private final float width;
    private final float height;

    public Rectangle(float width, float height) {
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
