package com.vti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateDemo {
    public static void main(String[] args) throws SQLException {
        //Khởi tạo các biến lưu thông tin DB gồm host, username và password
        String dbUrl = "jdbc:mysql://localhost:3306/exam2";
        String username = "root";
        String password = "root";

        // Khởi tạo connection tới DB thông qua host, username và password
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        System.out.println("Connection Successfully !");

        // Viết câu lệnh truy vấn:
        String sql = "UPDATE trainee SET Full_Name = ? WHERE TraineeID = ?";

        // Tạo đối tượng preparedStatement để tạo truy vấn
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //Nhập từ bàn phím:
        int traineeId = 49;
        String fullName = "Nguyễn Văn C";

        // Xử lý gán dữ liệu vào statement
        preparedStatement.setString(1, fullName);
        preparedStatement.setInt(2, traineeId);

        //Thực hiện lệnh insert:
        int affectedRows = preparedStatement.executeUpdate();
        System.out.println("Số bản ghi bị tác động: " + affectedRows);
    }
}
