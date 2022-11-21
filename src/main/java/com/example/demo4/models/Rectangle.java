package com.example.demo4.models;

public class Rectangle extends Shape {

    @Override
    public boolean checkHit(double x, double y, int r) {
        return y >= 0 &&
                x >= 0 &&
                x <= r &&
                y <= (float)r / 2;
    }
}
