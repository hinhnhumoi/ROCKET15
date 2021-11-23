package com.company.backend;

import com.company.entity.Department;
import com.company.util.SQLutil;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Ex2 {
    public static List<Department> getDepartments () throws SQLException, IOException {
        Statement statement = SQLutil.connectDataBase().createStatement();
        String sql = "SELECT * FROM department";
        ResultSet resultSet = statement.executeQuery(sql);
        List<Department> departments = new ArrayList<>();

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            departments.add(new Department(id,name));
        }
        return departments;
    }
    public static void departmentById (int id) throws SQLException, IOException {
        String sql = "SELECT * FROM department WHERE departmentID = ? ";
        PreparedStatement preparedStatement = SQLutil.connectDataBase().prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            System.out.println("Department cần tìm:" + new Department(resultSet.getInt(1),resultSet.getString(2)));
        }
        else System.out.println("không có department có id cần tìm");
    }

    public static boolean isDepNameExists (String name) throws SQLException, IOException {
        String sql = "SELECT * FROM department WHERE departmentName = ? ";
        PreparedStatement preparedStatement = SQLutil.connectDataBase().prepareStatement(sql);
        preparedStatement.setString(1,name);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) return true;
        else  return false;
    }

    public static boolean isDepIdExists (int id) throws SQLException, IOException {
        String sql = "SELECT * FROM department WHERE departmentID = ? ";
        PreparedStatement preparedStatement = SQLutil.connectDataBase().prepareStatement(sql);
        preparedStatement.setInt(1,id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) return true;
        else return false;
    }

    public static void createDep (String name) throws SQLException, IOException {
        if (isDepNameExists(name)==true) {
            System.out.println("Tên phòng đã tồn tại!"); return;
        }
        else {
            String sql = "INSERT INTO department (departmentName) VALUES (?) ";
            PreparedStatement preparedStatement =SQLutil.connectDataBase().prepareStatement(sql);
            preparedStatement.setString(1,name);
            int afectedRow = preparedStatement.executeUpdate();
            System.out.println("Đã nhập thành công "+afectedRow+" bản ghi!");
        }
    }
}
