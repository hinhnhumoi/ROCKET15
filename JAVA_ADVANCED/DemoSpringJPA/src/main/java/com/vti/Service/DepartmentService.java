package com.vti.Service;

import com.vti.Entity.Department;
import com.vti.Repository.IDepartmentREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentREpository repository;

    @Override
    public List<Department> getAllDepartments() {
        return repository.findAll();
    }

    @Override
    public Department getDepartmentByID(short id) {
        return repository.findById(id).get();
    }

    @Override
    public Department getDepartmentByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void createDepartment(Department department) {
        repository.save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        repository.save(department);
    }

    @Override
    public void deleteDepartment(short id) {
        repository.deleteById(id);
    }

    @Override
    public boolean isDepartmentExistsByID(short id) {
        return repository.existsById(id);
    }

    @Override
    public boolean isDepartmentExistsByName(String name) {
        return repository.existsByName(name);
    }
}
