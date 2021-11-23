package com.company.backend;

import com.company.util.SQLutil;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.SQLException;

public class Ex3 {
    public static void deleteDep (int id) throws SQLException, IOException {
    if (Ex2.isDepIdExists(id)== false){
        System.out.println("không tồn tại department muốn xóa!");
     }
    else {
        String sql = "CALL sp_delete_dep (?)";
        CallableStatement callableStatement = SQLutil.connectDataBase().prepareCall(sql);
        callableStatement.setInt(1,id);
        int affectedRow = callableStatement.executeUpdate();
        System.out.println("Sô bản ghi bị ảnh hưởng: "+affectedRow);
    }
    }
}
