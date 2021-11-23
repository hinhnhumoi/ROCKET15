package com.company.Ex4;

public class Student {
    private int id;
    private String name;
    private String homeTown;
    private int mark;

    public Student(int id, String name, String homeTown) {
        this.id = id;
        this.name = name;
        this.homeTown = homeTown;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }
    public void addMark(int add) {
        this.mark += add;
    }

    public String printStudent() {
        String hocLuc;
        if (0>= mark && mark<4) hocLuc ="yeu";
        else if ( mark<6) hocLuc ="Trung Binh";
        else if (mark <8) hocLuc = "Kha";
        else if (mark <=10) hocLuc = "Gioi";
        else hocLuc = "Diem khong hop le";

        return "Student " +
                     + id +
                " name= " + name + '\t' +
                " homeTown= " + homeTown + '\t' +
                " mark= " + hocLuc;
    }
}
