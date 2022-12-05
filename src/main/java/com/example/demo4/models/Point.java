package com.example.demo4.models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Point {
    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private Double x;
    private Double y;
    private Integer r;
    private LocalDateTime attemptTime;
    private Double processTime;
    private Boolean hit;

    public Point(double x, double y, int r, LocalDateTime attemptTime, double processTime, boolean hit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.attemptTime = attemptTime;
        this.processTime = processTime;
        this.hit = hit;
    }

    public Point(){}

    public void setProcessTime(long l) {
        this.processTime = (double) l;
    }

    public void setHit(Boolean hit) {
        this.hit = hit;
    }

    public void setAttemptTime(LocalDateTime now) {

        this.attemptTime = now;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Integer getR() {
        return r;
    }

    public void setR(Integer r) {
        this.r = r;
    }

    public LocalDateTime getAttemptTime() {
        return attemptTime;
    }

    public Double getProcessTime() {
        return processTime;
    }

    public Boolean getHit() {
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
