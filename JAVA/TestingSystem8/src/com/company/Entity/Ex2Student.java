package com.company.Entity;

import java.time.LocalDate;

public class Ex2Student implements Comparable<Ex2Student>{
    private int id;
    private String name;
    private LocalDate dOB;
    private int score;


    public Ex2Student(int id, String name, LocalDate dOB, int score) {
        this.id = id;
        this.name = name;
        this.dOB = dOB;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getdOB() {
        return dOB;
    }

    public void setdOB(LocalDate dOB) {
        this.dOB = dOB;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Ex2Student o) {
        int flagCompare = this.name.compareTo(o.getName());
        if (flagCompare == 0) {
            if (this.score > o.score) {
                return 1;
            } else if (this.score < o.score) {
                return -1;
            } else if (this.score == o.score) {
                return this.dOB.compareTo(o.dOB);
            }
        } else {
            return flagCompare;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Ex2Student:" + id + ", name: " + name +
                ", Ngay Sinh: " + dOB + ", Diem: " + score;
    }
}
