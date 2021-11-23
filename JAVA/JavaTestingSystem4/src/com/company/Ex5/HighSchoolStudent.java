package com.company.Ex5;

public class HighSchoolStudent extends Student {
    private String classes;
    private String desiredUniversity;


    public HighSchoolStudent(int id, String name, String classes, String desiredUniversity) {
        super(id, name);
        this.classes = classes;
        this.desiredUniversity =desiredUniversity;
    }
}
