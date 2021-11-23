package com.company.backend.dataLayer;

import com.company.entity.Account;
import com.company.utlis.JDBCUtils;

import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    public AccountRepository() throws SQLException, IOException {
    }
    JDBCUtils jdbcUtils = new JDBCUtils();
    Connection connection = jdbcUtils.getConnection();

    List<Account> accounts = new ArrayList<>();

    public List<Account> getListAccount () throws SQLException {
        Statement statement = connection.createStatement();
        String sql ="select * from `account`";
        ResultSet resultSet= statement.executeQuery(sql);

        while (resultSet.next()){
            Account account =new Account(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),
                    resultSet.getString(4),resultSet.getDate(5) );
            accounts.add(account);
        }
            return accounts;
    }
}
