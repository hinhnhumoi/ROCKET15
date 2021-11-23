package com.vti.service;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForFilter;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.DepartmentSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class DepartmentService implements IDepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFormForFilter filter) {

        Specification<Department> where = null;

        if(!StringUtils.isEmpty(search)){
            DepartmentSpecification searchSpecification = new DepartmentSpecification("name", "LIKE", search );
            DepartmentSpecification authorSpecification = new DepartmentSpecification("author.fullName", "LIKE", search );

            where = Specification.where(searchSpecification).or(authorSpecification);
        }

        if(filter != null && filter.getMinDate() != null) {
            DepartmentSpecification minDateSpecification = new DepartmentSpecification("createDate", ">=", filter.getMinDate());
            if(where == null){
                where = Specification.where(minDateSpecification);
            }else {
                where = where.and(minDateSpecification);
            }
        }

        if(filter != null && filter.getMaxDate() != null) {
            DepartmentSpecification maxDateSpecification = new DepartmentSpecification("createDate", "<=", filter.getMaxDate());
            if(where == null){
                where = Specification.where(maxDateSpecification);
            }else {
                where = where.and(maxDateSpecification);
            }
        }
        return departmentRepository.findAll(where ,pageable);
    }

    @Override
    public Department getDepartmentById(short id) {
        return departmentRepository.findById(id).get();
    }

    @Override
    public Department getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public void createDepartment(DepartmentFormForCreating form) {

        //get author
        Account author = accountRepository.getById(form.getAuthorId());

        //convert form to entity
        Department department = new Department(form.getName());
        department.setAuthor(author);
        departmentRepository.save(department);
    }

    @Override
    public void updateDepartment(short id,DepartmentFormForUpdating form) {
        //convert
        Department department = departmentRepository.findById(id).get();

        department.setName(form.getName());
        department.setModifiedDate(new Date());
        departmentRepository.save(department);

    }

    @Override
    public void deleteDepartment(short id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public boolean isDepartmentExistsById(short id) {
        return departmentRepository.existsById(id);
    }

    @Override
    public boolean isDepartmentExistsByName(String name) {
        return departmentRepository.existsByName(name);
    }

    @Override
    public void deleteDepartments(List<Short> ids) {
        departmentRepository.deleteByIds(ids);
    }
}
