package com.example.demo4.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Point {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private double x;
    private double y;
    private int r;
    private final LocalDateTime attemptTime;
    private final double processTime;
    private final boolean hit;

    public Point(double x, double y, int r, LocalDateTime attemptTime, double processTime, boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.attemptTime = attemptTime;
        this.processTime = processTime;
        this.hit = hit;
    }

    public double getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public LocalDateTime getAttemptTime() {
        return attemptTime;
    }

    public double getProcessTime() {
        return processTime;
    }

    public boolean getHit() {
        return hit;
    }

    public String toJSON() {
        return "{" +
                "\"x\":" + "\"" + this.getX() + "\"" + "," +
                "\"y\":" + "\"" + this.getY() + "\"" + "," +
                "\"r\":" + "\"" + this.getR() + "\"" + "," +
                "\"attemptTime\":" + "\"" + this.getAttemptTime() + "\"" + "," +
                "\"processTime\":" + "\"" + String.valueOf(this.processTime) + "\"" + "," +
                "\"hit\":" + "\"" + this.getHit() + "\"" +
                "}";
    }

    public String block() {
        return
                "<td class=\"xResult\">" + x + "</td>" +
                        "<td class=\"yResult\">" + y + "</td>" +
                        "<td class=\"rResult\">" + r + "</td>" +
                        "<td>" + (hit ? "HIT" : "MISS") + "</td>" +
                        "<td>" + attemptTime.format(formatter) + "</td>" +
                        "<td>" + processTime/1000 + "ms" + "</td>"
                ;
    }
}
