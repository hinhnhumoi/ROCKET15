package com.company.utils;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {
    private Connection connection;

    public Connection getConnection() throws SQLException, IOException {
        if (connection==null || connection.isClosed()){

            Properties properties = new Properties();
            properties.load( new FileInputStream("resource/database.properties"));

            String dbUrl = properties.getProperty("dbUrl");
            String user = properties.getProperty("user");
            String pass = properties.getProperty("pass");

            connection = DriverManager.getConnection(dbUrl,user,pass);

        }
        return connection;
    }

    public void disconnect () throws SQLException {
        if (connection != null && connection.isClosed())
            connection.close();
    }
}
