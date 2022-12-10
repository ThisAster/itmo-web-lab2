package com.example.demo4.tools;

public class ValidatorManager {

    public boolean validate(double x, double y, int r) {

        double x_min = -3D;
        double x_max = 5D;

        double y_min = -2D;
        double y_max = 2D;

        int r_min = 1;
        int r_max = 5;

        return x >= x_min && x <= x_max && y >= y_min && y <= y_max && r >= r_min && r <= r_max;
    }
}

