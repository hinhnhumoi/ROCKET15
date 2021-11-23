package com.vti;

import java.sql.*;

public class CallProcedureDemo {
    public static void main(String[] args) throws SQLException {
        //Khởi tạo các biến lưu thông tin DB gồm host, username và password
        String dbUrl = "jdbc:mysql://localhost:3306/exam2";
        String username = "root";
        String password = "root";

        // Khởi tạo connection tới DB thông qua host, username và password
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        System.out.println("Connection Successfully !");

        String sql = "{CALL insert_trainee(?, ?)}";
        CallableStatement callableStatement = connection.prepareCall(sql);

        int traineeId = 123;
        String fullName = "Đức Anh cười lằm cười lốn";

        callableStatement.setInt(1, traineeId);
        callableStatement.setString(2, fullName);

        //Thực hiện Call
        int affectedRows = callableStatement.executeUpdate();
        System.out.println("Số bản ghi bị tác động: " + affectedRows);
    }
}
