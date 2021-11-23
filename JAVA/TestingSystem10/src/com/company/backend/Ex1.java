package com.company.backend;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Ex1 {
    public static void Ex1 () throws IOException, SQLException {
        //Q1
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/resource/database.properties"));
        String dbUrl = properties.getProperty("dbUrl");
        String user = properties.getProperty("user");
        String pass = properties.getProperty("pass");

        Connection connection = DriverManager.getConnection(dbUrl,user,pass);
        System.out.println("Connection Successful!");
        //Q2
        Statement statement = connection.createStatement();
        String sql ="select positionID, positionName from position";
        ResultSet resultSet= statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.print(resultSet.getInt(1)+"|");
            System.out.print(resultSet.getString(2)+"\n");
            }
        //Q3
        Scanner scanner =new Scanner(System.in);
        String sql3 = "insert into position (positionID, positionName)"+ "values  ( ? , ? )";

        PreparedStatement preparedStatement =connection.prepareStatement(sql3);

        System.out.println("Nhập position ID:");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println(" Nhập position Name: ");
        String positionName = scanner.nextLine();

        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,positionName);

        int afectedRow = preparedStatement.executeUpdate();
        System.out.println("Q3: Số bản ghi bị tác động : "+ afectedRow);

        //Q4
        String sql4 = "Update position SET positionName = ? where positionID = ?";
        preparedStatement =connection.prepareStatement(sql4);
        int id4=5;
        String name4 = "DEV";

        preparedStatement.setString(1,name4);
        preparedStatement.setInt(2, id4);

        afectedRow = preparedStatement.executeUpdate();
        System.out.println(" Q4 : Số bản ghi bị tác động : "+ afectedRow);

        //Q5
        String sql5 = "delete from position where  positionID = ? ";
        preparedStatement =connection.prepareStatement(sql5);

        System.out.println("Nhập vào ID muốn xóa: ");
        int id5= scanner.nextInt();

        preparedStatement.setInt(1,id5);

        afectedRow = preparedStatement.executeUpdate();
        System.out.println(" Q5 : Số bản ghi bị tác động : "+ afectedRow);
    }
    }

