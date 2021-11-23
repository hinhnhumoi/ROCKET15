package com.company.Ex2Q1;

public class Program {
    public static void main(String[] args) {
        try {
            float result = devide(7,0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Không chia được cho 0!");
        }
        catch (Exception e) {
            System.out.println("Lỗi chịu rồi");
        }
    }
    public  static float devide (int a, int b){
        return a/b;
    }
}
