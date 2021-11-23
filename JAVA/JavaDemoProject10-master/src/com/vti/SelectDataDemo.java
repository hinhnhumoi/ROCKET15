package com.vti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class SelectDataDemo {

    public static void main(String[] args) throws SQLException, IOException {
        //Đọc từ file
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/resource/database.properties"));

//        Load từ file ra thông tin cấu hình
        String dbUrl = properties.getProperty("dbUrl");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        // Khởi tạo connection tới DB thông qua host, username và password
        Connection connection = DriverManager.getConnection(dbUrl, username, password);
        System.out.println("Connection Successfully !");

        // Khởi tạo đối tượng Statement
        Statement statement = connection.createStatement();

        // Viết câu lệnh truy vấn:
        String sql = "SELECT TraineeID, Full_Name, Gender FROM trainee;";

        // Tạo đối tượng ResultSet để hứng kết quả trả về khi truy vấn:
        ResultSet resultSet = statement.executeQuery(sql);

        // In kết quả thực hiện truy vấn về:
        while(resultSet.next()){
            System.out.print(resultSet.getInt("TraineeID") + " | ");
            System.out.print(resultSet.getString("Full_Name") + " | ");
            System.out.print(resultSet.getString("Gender"));
            System.out.println();
        }
    }
}
