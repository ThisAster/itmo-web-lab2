package com.example.demo4.models;

public class Triangle extends Shape{

    @Override
    public boolean checkHit(double x, double y, int r) {
        return x <= 0 &&
                y >= 0 &&
                y <= x + 0.5*r;
    }
}
