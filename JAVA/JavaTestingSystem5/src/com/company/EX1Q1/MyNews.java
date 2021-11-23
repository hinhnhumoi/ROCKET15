package com.company.EX1Q1;

import java.time.LocalDate;
import java.util.Scanner;

public class MyNews {

    public static void main(String[] args) {
	int k=0;
	Scanner scanner = new Scanner(System.in);
	System.out.println("(1) Insert news\n" +
                "(2) View list news\n" +
                "(3) Average rate\n" +
                "(4) Exit");
    k= scanner.nextInt();
    switch (k) {
        case 1:
            News news = new News();
            news.setTitle("Đảng và Bác Hồ kính yêu");
            news.setPublishDate(LocalDate.of(2020,12,24));
            news.setAuthor(" Đào Thanh Tùng");
            news.setContent("Chủ Tịch Hồ Chí Minh vĩ đại sống mãi trong lòng chúng ta!!!");
            news.setAverageRate(news.Calculate());
            break;
        case 2:
            News news1 = new News();
            news1.setTitle("Đảng và Bác Hồ kính yêu");
            news1.setPublishDate(LocalDate.of(2020,12,24));
            news1.setAuthor(" Đào Thanh Tùng");
            news1.setContent("Chủ Tịch Hồ Chí Minh vĩ đại sống mãi trong lòng chúng ta!!!");
            news1.Display();
            break;
        case 3:
            News news2 = new News();
            news2.setTitle("Đảng và Bác Hồ kính yêu");
            news2.setPublishDate(LocalDate.of(2020,12,24));
            news2.setAuthor(" Đào Thanh Tùng");
            news2.setContent("Chủ Tịch Hồ Chí Minh vĩ đại sống mãi trong lòng chúng ta!!!");
            news2.Calculate();
            news2.Display();
            break;
        case 4:
            return;
        default:
            System.out.println("Chọn đúng số trên menu!");
            break;
        }
    }
}
