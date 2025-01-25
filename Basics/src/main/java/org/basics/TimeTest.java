package org.basics;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeTest {
    public static void main(String[] args) {
        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        String times = time.toString();
        times=times.replaceAll("\\W++","_");
        System.out.println(times);
    }
}
