package com.vti.controller;

import com.vti.dto.AccountDTO;
import com.vti.dto.DepartmentDTO;
import com.vti.dto.DetailDepartmentDTO;
import com.vti.entity.Department;
import com.vti.form.DepartmentFormForCreating;
import com.vti.form.DepartmentFormForFilter;
import com.vti.form.DepartmentFormForUpdating;
import com.vti.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping(value = "api/v1/departments")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping
    public ResponseEntity<?> getAllDepartments (Pageable pageable, @RequestParam(required = false) String search, DepartmentFormForFilter filter){
        Page<Department> entitiesPage = service.getAllDepartments(pageable, search, filter);

        //convert entities -> dto
        Page<DepartmentDTO> dtoPage = entitiesPage.map( new Function<Department, DepartmentDTO>() {
            @Override
            public DepartmentDTO apply(Department entity) {
                AccountDTO accountDTO = new AccountDTO(entity.getAuthor().getId(), entity.getAuthor().getFullName());
                DepartmentDTO dto = new DepartmentDTO(
                        entity.getId(),
                        entity.getName(),
                        accountDTO,
                        entity.getCreateDate());
                return dto;
            }
        });
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<?> getDepartmentById (@PathVariable (name = "id") short id){
        Department entity = service.getDepartmentById(id);

        AccountDTO accountDTO = new AccountDTO(entity.getAuthor().getId(), entity.getAuthor().getFullName());
        DetailDepartmentDTO dto = new DetailDepartmentDTO(
                entity.getId(),
                entity.getName(),
                accountDTO,
                entity.getCreateDate());

        return  new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @GetMapping (value = "/name/{name}/exists")
    public ResponseEntity<?> existsByName (@PathVariable (name = "name") String name){

        return  new ResponseEntity<>(service.isDepartmentExistsByName(name), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<?> createDepartment (@RequestBody DepartmentFormForCreating form){
        service.createDepartment(form);
        return new ResponseEntity<String>("Created successfully!!", HttpStatus.CREATED);
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<?> updateDepartment (@PathVariable (name = "id") short id, @RequestBody DepartmentFormForUpdating form){
        service.updateDepartment(id,form);
        return new ResponseEntity<String>("updated successfully!!", HttpStatus.OK);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<?> deleteDepartment (@PathVariable(name = "id") short id){
        service.deleteDepartment(id);
        return new ResponseEntity<String>("delete successfully!!", HttpStatus.OK) ;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteDepartments (@RequestParam(name = "ids") List<Short> ids){
        service.deleteDepartments(ids);
        return new ResponseEntity<String>("delete successfully!!", HttpStatus.OK) ;
    }
}
