package com.company.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.io.FileInputStream;


public class SQLutil {
    public static Connection connectDataBase () throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/resource/database.properties"));
        String dbUrl = properties.getProperty("dbUrl");
        String user = properties.getProperty("user");
        String pass = properties.getProperty("pass");
        Connection connection = DriverManager.getConnection(dbUrl,user,pass);
        return connection;
    }
}
