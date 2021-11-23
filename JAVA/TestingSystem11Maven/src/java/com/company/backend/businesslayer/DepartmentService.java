package com.company.backend.businesslayer;

import com.company.backend.datalayer.DepartmentRepository;
import com.company.entity.Department;

import java.sql.SQLException;

public class DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentService() {
        departmentRepository = new DepartmentRepository();
    }

    public Department departmentById (int id) throws SQLException, ClassNotFoundException {
        return departmentRepository.departmentById(id);
    }
}
