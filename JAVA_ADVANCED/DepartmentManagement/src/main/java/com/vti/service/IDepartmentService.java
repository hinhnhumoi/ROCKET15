package com.vti.service;

import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForFilter;
import com.vti.form.DepartmentFormForUpdating;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IDepartmentService {
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFormForFilter filter);

    public Department getDepartmentById(short id);

    public Department getDepartmentByName(String name);

    public void createDepartment(DepartmentFormForCreating form);

    public void updateDepartment(short id, DepartmentFormForUpdating form);

    public void deleteDepartment (short id);

    public boolean isDepartmentExistsById (short id);

    public boolean isDepartmentExistsByName (String name);

    public void deleteDepartments(List<Short> ids);
}
