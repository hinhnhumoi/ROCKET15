package com.company.EX1Q2;

public class Student {
    private int ID;
    private String fullName;
    private String address;
    private Block block;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Student(int id, String fullName, String address, Block block){
        this.ID=id; this.fullName=fullName; this.address = address; this.block = block;
    };

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                ", fullName='" + fullName + '\'' +
                ", address='" + address + '\'' +
                ", block=" + block + block.getSubject() +
                '}';
    }
}
