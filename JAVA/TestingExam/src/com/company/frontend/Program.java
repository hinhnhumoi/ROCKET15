package com.company.frontend;

import com.company.backend.presentationlayer.UserController;
import com.company.utils.ScannerUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Program {
    public static void main(String[] args) throws SQLException, IOException {
        UserController userController = new UserController();

        while (true){
            System.out.println("Mời bạn nhập tính năng muốn chọn:");
            System.out.println("1. Tra các nhân viên và quản lý của một dự án:");
            System.out.println("2. Tra tất cả các quản lý của các dự án:");
            System.out.println("3. Đăng nhập: ");
            System.out.println("4. Thoát.");
            int i = ScannerUtils.inputIntPositive(1,4);
            switch (i){
                case 1:
                    System.out.println("Bạn đã chọn 1, Mời nhập vào id dự án :");
                    int id = ScannerUtils.inputIntPositive();
                    userController.getUserProject(id);
                    break;
                case 2:
                    System.out.println("Bạn đã chọn 2, Các quản lý của các dự án là: ");
                    userController.getProjectManager();
                    break;
                case 3:
                    System.out.println("Bạn đã chọn 3, mời nhập email và mật khẩu hợp lệ:");
                    System.out.print("Email: ");
                    String email = ScannerUtils.inputEmail();
                    System.out.print("\nPassword: ");
                    String pass = ScannerUtils.inputPassword();
                    userController.login(email,pass);
                    break;
                case 4:
                    return;
            }
        }

    }
}
