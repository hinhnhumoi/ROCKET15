package com.vti.Controller;


import com.vti.Entity.Department;
import com.vti.Service.IDepartmentService;
import com.vti.DTO.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {
    @Autowired
    IDepartmentService service;

    @GetMapping()
    public ResponseEntity<?> getAllDepartments() {
        List<Department> entities = service.getAllDepartments();
        return new ResponseEntity<List<Department>>(entities, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getDepartmentByID(@PathVariable(name = "id") short id) {
        return new ResponseEntity<Department>(service.getDepartmentByID(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> createDepartment(@RequestBody DepartmentDTO dto) {
        service.createDepartment(dto.toEntity());
        return new ResponseEntity<String>("Create successfully!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateDepartment(@PathVariable(name = "id") String name, @RequestBody DepartmentDTO dto) {
        Department department = dto.toEntity();
        department.setName(name);
        service.updateDepartment(department);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteDepartment(@PathVariable(name = "id") short id) {
        service.deleteDepartment(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }
}
