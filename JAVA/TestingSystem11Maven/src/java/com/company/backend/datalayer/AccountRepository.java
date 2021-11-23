package com.company.backend.datalayer;

import com.company.entity.Account;
import com.company.entity.Department;
import com.company.utils.JDBCUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private JDBCUtils jdbcUtils;

    public AccountRepository() {
        jdbcUtils = new JDBCUtils();
    }

    public List<Account> getListAccounts () throws SQLException, ClassNotFoundException {
        List<Account> accounts = new ArrayList<>();

        Connection connection = jdbcUtils.getConnection();

        String sql = "SELECT * FROM account";
        Statement statement =connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Account account = new Account();
            account.setId(resultSet.getInt(1));
            account.setEmail(resultSet.getString(2));
            account.setUserName(resultSet.getString(3));
            account.setFullName(resultSet.getString(4));

            DepartmentRepository departmentRepository = new DepartmentRepository();
            Department department = new Department();
            department = departmentRepository.departmentById(resultSet.getInt(5));
            account.setDepartment(department);

            LocalDate localDate = resultSet.getDate(7).toLocalDate();
            account.setCreateDate(localDate);
            accounts.add(account);
        }
        jdbcUtils.disconnect();
        return accounts;
    }
}
