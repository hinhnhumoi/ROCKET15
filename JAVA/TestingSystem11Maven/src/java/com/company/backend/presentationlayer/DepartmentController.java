package com.company.backend.presentationlayer;

import com.company.backend.businesslayer.DepartmentService;
import com.company.entity.Department;
import com.company.utils.JDBCUtils;

import java.sql.SQLException;

public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController() {
        departmentService = new DepartmentService();
    }

    public Department departmentById (int id) throws SQLException, ClassNotFoundException {
        return departmentService.departmentById(id);
    }
}
