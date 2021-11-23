package com.company.backend.datalayer;

import com.company.utils.JDBCUtils;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepository implements IUserRepository{
    private JDBCUtils jdbcUtils;

    public UserRepository() {
        jdbcUtils = new JDBCUtils();
    }


    @Override
    public void getUserProject(int id) throws SQLException, IOException {
        Connection connection = jdbcUtils.getConnection();

        String sql = "SELECT pau.projectId, u.`fullName`, pau.`Role` FROM `ProjectAndUser` as pau JOIN `User` as u ON u.id = pau.userId WHERE pau.projectId = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            int userId = resultSet.getInt(1);
            String fullName = resultSet.getString(2);
            String role = resultSet.getString(3);
            System.out.println(userId+ " | " + fullName+ " | " + role);
        }

        jdbcUtils.disconnect();
    }

    @Override
    public void getProjectManager() throws SQLException, IOException {
        Connection connection = jdbcUtils.getConnection();

        String sql = "SELECT pau.projectId, u.`fullName`, pau.`Role` FROM `ProjectAndUser` pau JOIN `User` u ON u.id = pau.userId WHERE `Role` = 'MANAGER' ";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            int userId = resultSet.getInt(1);
            String fullName = resultSet.getString(2);
            System.out.println(userId+ " | " + fullName);
        }
        jdbcUtils.disconnect();
    }

    @Override
    public boolean isUserExist(String email) throws SQLException, IOException {
        Connection connection = jdbcUtils.getConnection();
        String sql = "SELECT * FROM user WHERE email = ? ";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,email);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            jdbcUtils.disconnect();
            return true;
        }
        else {
            jdbcUtils.disconnect();
            return false;
        }
    }

    @Override
    public void login(String email, String password) throws SQLException, IOException {
        if (isUserExist(email)){
            Connection connection = jdbcUtils.getConnection();
            String sql = "SELECT  u.`fullName` FROM `User` u WHERE u.`email` = ? AND `password` = ?";
            PreparedStatement preparedStatement =connection.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Chúc mừng bạn "+ resultSet.getString(1) + "đã đăng nhập thành công!");
                jdbcUtils.disconnect();
            }
            else System.out.println("Mật khẩu không đúng!!");
            jdbcUtils.disconnect();
        }
        else System.out.println("Email không tồn tại!");

    }

    @Override
    public List<Integer> getListProjectId() throws SQLException, IOException {
        Connection connection = jdbcUtils.getConnection();
        String sql = "SELECT  id FROM project";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        List<Integer> integers = new ArrayList<>();
        while (resultSet.next()){
            Integer integer = new Integer(resultSet.getInt(1));
            integers.add(integer);
        }
        return integers;
    }
}
