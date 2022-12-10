package com.example.demo4.tools;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ValidateManager {

    public boolean validate(double x, double y, int r) {

        double x_min = -3;
        double x_max = 5;

        double y_min = -2;
        double y_max = 2;

        int r_min = 1;
        int r_max = 5;

        return x >= x_min && x <= x_max && y >= y_min && y <= y_max && r >= r_min && r <= r_max;
    }
}

