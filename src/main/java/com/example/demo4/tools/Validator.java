package com.example.demo4.tools;

public class Validator {
    private final Double x_max = 5D;
    private final Double x_min = -3D;
    private final Double y_max = 3D;
    private final Double y_min = -5D;
    private final Integer r_max = 5;
    private final Integer r_min = 1;

    public boolean validate(double x, double y, int r){
        return validateX(x, x_max, x_min) && validateY(y, y_max, y_min) && validateR(r, r_max, r_min);
    }
    private boolean validateX(double x, double x_max, double x_min) {
        return x >= x_min && x <= x_max;
    };
    private boolean validateY(double y, double y_max, double y_min){
        return y >= y_min && y <= y_max;
    };
    private boolean validateR(int r, int r_max, int r_min){
        return r >= r_min && r <= r_max;
    };

}
