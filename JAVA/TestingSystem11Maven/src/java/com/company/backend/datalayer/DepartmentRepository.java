package com.company.backend.datalayer;

import com.company.entity.Department;
import com.company.utils.JDBCUtils;

import java.sql.*;

public class DepartmentRepository {
    private JDBCUtils jdbcUtils;

    public DepartmentRepository() {
        jdbcUtils = new JDBCUtils();
    }

    public Department departmentById (int id) throws SQLException, ClassNotFoundException {
        Connection connection = jdbcUtils.getConnection();

        String sql = "SELECT * FROM department where departmentID = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            Department department = new Department();
            department.setId(resultSet.getInt(1));
            department.setName(resultSet.getString(2));
            jdbcUtils.disconnect();
            return department;
        }
        else {
            System.out.printf("Không tồn tại dep có id là: " + id);
            jdbcUtils.disconnect();
            return null;
        }
    }
}
