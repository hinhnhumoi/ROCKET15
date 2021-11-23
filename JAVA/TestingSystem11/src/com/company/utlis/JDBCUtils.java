package com.company.utlis;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    Connection connection;

     public Connection getConnection() throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/resource/database.properties"));
        String dbUrl = properties.getProperty("dbUrl");
        String user = properties.getProperty("user");
        String pass = properties.getProperty("pass");
        connection = DriverManager.getConnection(dbUrl,user,pass);
        return connection;
    }

    void closeConnection () throws SQLException {
         connection.close();
    }

    public JDBCUtils() {
    }
}
