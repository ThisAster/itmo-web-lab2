package com.example.demo4.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class Point {

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Setter @Getter
    private Double x;
    @Setter @Getter
    private Double y;
    @Setter @Getter
    private Integer r;
    @Setter @Getter
    private LocalDateTime attemptTime;
    @Setter @Getter
    private Double processTime;
    @Setter @Getter
    private Boolean hit;
    @Setter @Getter
    private Boolean isClick;

    public String block() {
        return
                "<td class=\"xResult\">" + x + "</td>" +
                        "<td class=\"yResult\">" + y + "</td>" +
                        "<td class=\"rResult\">" + r + "</td>" +
                        "<td>" + (isClick ? "click" : "form") + "</td>" +
                        "<td>" + (hit ? "HIT" : "MISS") + "</td>" +
                        "<td>" + attemptTime.format(formatter) + "</td>" +
                        "<td>" + processTime/1000 + "ms" + "</td>"
                ;
    }
}
