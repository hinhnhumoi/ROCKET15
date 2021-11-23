package com.company.Frontend;

import com.company.Backend.Exercise3;
import com.company.Entity.Ex3Student;

public class Program3 {
    public static void main(String[] args) {
        Ex3Student ex3Student1 = new Ex3Student<Integer>(1,"Đào Thanh Tùng");
        Ex3Student ex3Student2 = new Ex3Student<Float>(2.0f,"Nguyễn Văn A");
        Ex3Student ex3Student3 = new Ex3Student<Double>(2.0d,"Nguyễn Văn B");

        Exercise3.Ex3Print(1);
        Exercise3.Ex3Print("Đào Thanh Tùng");
        Exercise3.Ex3Print(ex3Student1);
    }
}
