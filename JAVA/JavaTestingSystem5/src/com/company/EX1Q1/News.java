package com.company.EX1Q1;

import java.time.LocalDate;
import java.util.Scanner;

public class News implements INews{
    private int ID ;
    private String title;
    private LocalDate publishDate;
    private String author ;
    private String  content;
    private double averageRate;

    @Override
    public void Display() {
        System.out.println("Title: "+ title+", Publish Date: "+publishDate +", Author: "+ author +", Rate: "+ averageRate);
    }

    @Override
    public double Calculate() {
        Scanner scanner =new Scanner(System.in);
        int[] rates= new int[3];
        for (int i=0;i<3;i++){
            System.out.println("Nhap danh gia thu "+(i+1)+": ");
            rates[i] = scanner.nextInt();
        }
        return (double) (rates[0]+rates[1]+rates[2])/3;
    }

    public void setAverageRate(double averageRate) {
        this.averageRate = averageRate;
    }

    public double getAverageRate() {
        return averageRate;
    }
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDate getPublishDate() {
        return publishDate;
    }
    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

}
