package com.company.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class ScannerUtils {
    private static Scanner sc = new Scanner(System.in);
    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(sc.next().trim());
            } catch (Exception e) {
                System.err.println("Nhập lại:");
            }
        }
    }
    public static int inputIntPositive() {
        while (true) {
            try {
                int intPositive = Integer.parseInt(sc.next());
                if (intPositive >= 0) {
                    return intPositive;
                } else {
                    System.err.println("Nhập lại số nguyên dương \n");
                }
            } catch (Exception e) {
                System.err.println("Nhập lại:\n");
            }
        }
    }

    public static int inputIntPositive(int n,int m) {
        while (true) {
            try {
                int intPositive = Integer.parseInt(sc.next());
                if (intPositive >= n && intPositive <=m) {
                    return intPositive;
                } else {
                    System.err.println("Nhập lại số nguyên trong khoảng "+ n +" và " + m +"\n");
                }
            } catch (Exception e) {
                System.err.println("Nhập lại:\n");
            }
        }
    }

    public static Float inputFloat() {
        while (true) {
            try {
                return Float.parseFloat(sc.next());
            } catch (Exception e) {
                System.err.println("Nhập lại:");
            }
        }
    }
    public static Double inputDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.next());
            } catch (Exception e) {
                System.err.println("Nhập lại:");
            }
        }
    }
    public static String inputString() {
        while (true) {
            String string = sc.next().trim();
            if (!string.isEmpty()) {
                return string;
            } else {
                System.err.println("Nhập lại:");
            }
        }
    }
    public static LocalDate inputLocalDate() {
        System.out.println("Nhập theo định dạng yyyy-MM-dd");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        while (true) {
            String localdate = sc.next().trim();
            try {
                if (format.parse(localdate) != null) {
                    LocalDate lc = LocalDate.parse(localdate);
                    return lc;
                }
            } catch (Exception e) {
                System.err.println("Nhập lại:");
            }
        }
    }
    public static String inputEmail() {
        while (true) {
            String email = ScannerUtils.inputString();
            if (email == null || !email.contains("@")) {
                System.out.print("Email không hợp lệ, vui lòng nhập lại :\n");
            } else {
                return email;
            }
        }
    }
    public static int inputFunction(int a, int b, String errorMessage) {
        while (true) {
            int number = ScannerUtils.inputInt();
            if (number >= a && number <= b) {
                return number;
            } else {
                System.err.println(errorMessage);
            }
        }
    }
    public static String inputPassword() {
        while (true) {
            String password = ScannerUtils.inputString();
            if (password.length() < 6 || password.length() > 12) {
                System.out.print("Mật khẩu phải có 6 đến 12 kí tự, vui lòng nhập lại:\n");
                continue;
            }
            boolean hasAtLeast1Character = false;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i)) == true) {
                    hasAtLeast1Character = true;
                    break;
                }
            }
            if (hasAtLeast1Character == true) {
                return password;
            } else {
                System.out.print("Mật khẩu phải có ít nhất 1 kí tự in hoa, vui lòng nhập lại:\n");
            }
        }
    }
    public static String inputPhoneNumber() {
        while (true) {
            String number = ScannerUtils.inputString();

            if (number.length() > 12 || number.length() < 9) {
                continue;
            }
            if (number.charAt(0) != '0') {
                continue;
            }
            boolean isNumber = true;
            for (int i = 0; i < number.length(); i++) {
                if (Character.isDigit(number.charAt(i)) == false) {
                    isNumber = false;
                    break;
                }
            }
            if (isNumber == true) {
                return number;
            } else {
                System.out.print("Nhập lại: ");
            }
        }
    }
}
