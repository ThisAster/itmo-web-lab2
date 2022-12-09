package com.example.demo4.models;

import com.example.demo4.tools.CheckHitManager;

import java.time.LocalDateTime;

public class Service {
    Triangle triangle = new Triangle();
    Rectangle rectangle = new Rectangle();
    Sector sector = new Sector();
    public Point createPoint(Double x, Double y, Integer r, long start, Boolean isClick) {
        Point point = new Point();

        point.setX(x);
        point.setY(y);
        point.setR(r);
        point.setClicked(isClick);
        point.setProcessTime(System.nanoTime()-start);
        point.setAttemptTime(LocalDateTime.now());
        point.setHit(new CheckHitManager(x, y, r).hasHit(sector, rectangle, triangle));
        return point;
    }
}
