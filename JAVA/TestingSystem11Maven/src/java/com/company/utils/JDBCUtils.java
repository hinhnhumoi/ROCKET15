package com.company.utils;

import java.sql.*;

public class JDBCUtils {

    private Connection connection;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        if (connection == null || connection.isClosed() ){
            String url = "jdbc:mysql://localhost:3306/congtyabc";
            String username = "root";
            String password = "root";

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(url,username,password);
        }

        return connection;
    }

    public void disconnect () throws SQLException {
        if (connection != null && connection.isClosed())
            connection.close();
    }
}


