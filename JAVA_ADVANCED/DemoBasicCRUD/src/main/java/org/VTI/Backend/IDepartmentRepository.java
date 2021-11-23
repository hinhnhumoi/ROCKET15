package org.VTI.Backend;

import org.VTI.Entity.Department;

import java.util.List;

public interface IDepartmentRepository {

    public List<Department> getAllDepartment ();

    public Department getDepartmentById (short id);

    public Department getDepartmentByName ( String name);

    public void createDepartment (Department department);

    public void updateDepartment (short id, String newName);

    public void updateDepartment (Department department);

    public void deleteDepartment (short id);

    public boolean isDepExistsById (short id);

    public boolean isDepExistsByName (String name);

}
