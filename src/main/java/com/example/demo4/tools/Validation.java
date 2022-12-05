package com.example.demo4.tools;

public class Validation {
    private final Double x_max = 5D;
    private final Double x_min = -3D;
    private final Double y_max = 3D;
    private final Double y_min = -5D;
    private final Integer r_max = 5;
    private final Integer r_min = 1;

    public boolean validate(double x, double y, int r){
        return validateX(x, x_max, x_min, r) && validateY(y, y_max, y_min, r) && validateR(r, r_max, r_min);
    }
    private boolean validateX(double x, double x_max, double x_min, int r) {
        return x >= x_min && x <= x_max && x*x < r*r*1.51f*1.51f;
    }
    private boolean validateY(double y, double y_max, double y_min, int r){
        return y >= y_min && y <= y_max && y*y < r*r*1.51f*1.51f;
    }
    private boolean validateR(int r, int r_max, int r_min){
        return r >= r_min && r <= r_max;
    }
}

