package com.vti.Repository;

import com.vti.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentREpository extends JpaRepository<Department,Short> {

    public Department findByName (String name) ;

    public boolean existsByName (String name) ;

}
