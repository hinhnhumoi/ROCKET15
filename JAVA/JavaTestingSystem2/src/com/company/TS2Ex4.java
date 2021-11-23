package com.company;

import java.time.LocalDate;
import java.util.Random;
import java.util.function.DoubleToIntFunction;

public class TS2Ex4 {
    public static void main(String[] args) {
        Random random = new Random();
        int x= random.nextInt();
        System.out.println("So nguyen random" + x);
        //Q2
        double y= random.nextDouble();
        System.out.println("So thuc random" + y);
        //Q3 lay ngau nhien 1 ten trong 1 mang
        String[] ten ={"Tung","Tien","Tuan"};
        int i= random.nextInt(ten.length);
        System.out.println("Ten random" + ten[i]);
        //Q4 lay ngay nhien 1 ngay
        int minDay = (int) LocalDate.of(1995,07,24).toEpochDay();
        int maxDay = (int) LocalDate.of(1995,12,20).toEpochDay();
        long randomDate = random.nextInt(maxDay-minDay) +minDay;
        LocalDate randomDay = LocalDate.ofEpochDay(randomDate);
        System.out.println(" Ngay random la: " + randomDay);
        //Q5 1 ngay ngau nhien trong 1 nam tro lai day
        int minDay5 = (int) LocalDate.now().toEpochDay();
        int maxDay5 = (int) LocalDate.now().toEpochDay()- (int) LocalDate.of(1,0,0).toEpochDay();
        long randomDate5 = random.nextInt(maxDay-minDay) +minDay;
        LocalDate randomDay5 = LocalDate.ofEpochDay(randomDate);
        System.out.println(" Ngay random la: " + randomDay5);
        //Q6:
        int now = (int) LocalDate.now().toEpochDay();
        long randomDate6 = random.nextInt(now);
        LocalDate randomDay6 = LocalDate.ofEpochDay(randomDate6);
        //Q7 ngau nhien 1 so co 3 chu so: ??????
        double tam =900;
        double a = random.nextDouble();
        double a1= a+100;
        System.out.println("So ngau nhien co 3 chu so: "+a1);
    }
}
