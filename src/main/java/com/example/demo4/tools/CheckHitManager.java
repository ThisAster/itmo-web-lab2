package com.example.demo4.tools;

import com.example.demo4.models.Rectangle;
import com.example.demo4.models.Sector;
import com.example.demo4.models.Triangle;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CheckHitManager {

    private final double x;
    private final double y;
    private final int r;

    public boolean hasHit(Sector sector, Rectangle rectangle, Triangle triangle) {
        return sector.checkHit(x, y, r) || rectangle.checkHit(x, y, r) || triangle.checkHit(x, y, r);
    }

}
