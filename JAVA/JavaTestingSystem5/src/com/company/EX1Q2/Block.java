package com.company.EX1Q2;

public class Block {
    private String name;
    private String subject;

    public Block(String name) {
        this.name = name;
    }

    public String getSubject() {
        switch (this.name){
            case "A":
                this.subject = "Toán, Lý, Hóa"; break;
            case "B":
                this.subject = "Toán, Hóa, Sinh"; break;
            case "C":
                this.subject = "Văn, Sử, Địa"; break;
        }

        return this.subject;
    }

    @Override
    public String toString() {
        return "name='" + name  +
                ", subject='" + subject ;
    }
}
