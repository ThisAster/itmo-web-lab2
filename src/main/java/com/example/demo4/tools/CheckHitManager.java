package com.example.demo4.tools;

import com.example.demo4.models.Rectangle;
import com.example.demo4.models.Sector;
import com.example.demo4.models.Triangle;

public class CheckHitManager {
    private final double x;
    private final double y;
    private final int r;
    public CheckHitManager(double x, double y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
    public boolean hasHit(Sector sector, Rectangle rectangle, Triangle triangle) {
        if (sector.checkHit(x, y, r) || rectangle.checkHit(x, y, r) || triangle.checkHit(x, y, r)) {
            return true;
        } else {
            return false;
        }
    }

}
