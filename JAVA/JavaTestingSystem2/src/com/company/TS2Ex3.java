package com.company;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class TS2Ex3 {
    public static void main(String[] args) {
        // Tao Exam
        exam exam1 = new exam();
        exam1.examID = 1;
        exam1.createDate = LocalDate.of(1997, 01,28);
        //Q1
        System.out.println("Truoc: "+ exam1.createDate);
        Locale vnLocale = new Locale("vi","VI");
        String date= exam1.createDate.format(DateTimeFormatter.ofPattern("EEEE,dd,MM,yyyy",vnLocale));
        System.out.println("Sau:  "+ date);

//        //Q2
//        String pattern ="yyyy,MM,dd - HH,mm,ss";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern,new Locale("vi","VI"));
//        String date2 = simpleDateFormat.format(exam1.createDate);
//        System.out.println("Q2 :"+ date2);

//        String pattern = "EEEEE MMMMM yyyy HH:mm:ss.SSSZ";
//        SimpleDateFormat simpleDateFormat =new SimpleDateFormat(pattern, new Locale("vi", "VI"));
//        String date = simpleDateFormat.format(new Date());
//        System.out.println(date);
    }
}
