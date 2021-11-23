package com.company;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.util.Random;
import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
    //Q1
            double a=5240.5;
            double b = 10970.055;
            System.out.println("Luong cua a : "+ (int) a);
            System.out.println("Luong cua b : "+ (int) b);
    //Q2 in ra random 1 so luon co 5 chu so ( co 0 o dau`)
            Random random = new Random(100000);
            int x = random.nextInt();
            String s = String.valueOf(x);
            int numb = 5 - s.length();
            String zero = "";
            for (int i=0;i<numb;i++)    zero+="0";
            System.out.println(x+zero);
    //Q3    in ra 2 so cuoi cua day
            System.out.println("hai so cuoi: "+ s.substring(3));
    //Q4
            Q4();
    }
    private static void Q4 (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap vao a va b");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        System.out.println("a:b = "+ a/b);
    }
}
