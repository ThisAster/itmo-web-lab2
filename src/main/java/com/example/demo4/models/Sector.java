package com.example.demo4.models;

public class Sector extends Shape {


    @Override
    public boolean checkHit(double x, double y, int r) {
        double radius = Math.sqrt(x * x +
                y * y);
        return x <= 0 &&
                y <= 0 &&
                radius <= r;
    }
}
