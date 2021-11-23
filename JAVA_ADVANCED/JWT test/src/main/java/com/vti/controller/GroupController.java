package com.vti.controller;

import com.vti.dto.UserDTO;
import com.vti.dto.GroupDTO;
import com.vti.dto.DetailGroupDTO;
import com.vti.entity.Group;
import com.vti.form.GroupFormForCreating;
import com.vti.form.GroupFormForFilter;
import com.vti.form.GroupFormForUpdating;
import com.vti.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Function;

@RestController
@RequestMapping(value = "api/v1/groups")
@CrossOrigin("*")
public class GroupController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private GroupService service;

    @GetMapping
    @PreAuthorize("@appAuthorizer.authorize(authentication, 'VIEW', this)")
    public ResponseEntity<?> getAllGroups (Pageable pageable, @RequestParam(required = false) String search, GroupFormForFilter filter){
        Page<Group> entitiesPage = service.getAllGroups(pageable, search, filter);

        //convert entities -> dto
        Page<GroupDTO> dtoPage = entitiesPage.map( new Function<Group, GroupDTO>() {
            @Override
            public GroupDTO apply(Group entity) {
                UserDTO userDTO = new UserDTO(entity.getCreator().getId(), entity.getCreator().getFullName());
                GroupDTO dto = new GroupDTO(
                        entity.getId(),
                        entity.getName(),
                        userDTO,
                        entity.getCreateDate());
                return dto;
            }
        });
        return new ResponseEntity<>(dtoPage, HttpStatus.OK);
    }

    @GetMapping (value = "/{id}")
    public ResponseEntity<?> getGroupById (@PathVariable (name = "id") short id){
        Group entity = service.getGroupById(id);

        UserDTO userDTO = new UserDTO(entity.getCreator().getId(), entity.getCreator().getFullName());
        DetailGroupDTO dto = new DetailGroupDTO(
                entity.getId(),
                entity.getName(),
                userDTO,
                entity.getCreateDate());

        return  new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @GetMapping (value = "/name/{name}/exists")
    public ResponseEntity<?> existsByName (@PathVariable (name = "name") String name){

        return  new ResponseEntity<>(service.isGroupExistsByName(name), HttpStatus.OK);
    }

    @PostMapping
    public  ResponseEntity<?> createGroup (@RequestBody GroupFormForCreating form){
        service.createGroup(form);
        return new ResponseEntity<String>("Created successfully!!", HttpStatus.CREATED);
    }

    @PutMapping (value = "/{id}")
    public ResponseEntity<?> updateGroup (@PathVariable (name = "id") short id, @RequestBody GroupFormForUpdating form){
        service.updateGroup(id,form);
        return new ResponseEntity<String>("updated successfully!!", HttpStatus.OK);
    }

    @DeleteMapping (value = "/{id}")
    public ResponseEntity<?> deleteGroup (@PathVariable(name = "id") short id){
        service.deleteGroup(id);
        return new ResponseEntity<String>("delete successfully!!", HttpStatus.OK) ;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteGroups (@RequestParam(name = "ids") List<Short> ids){
        service.deleteGroups(ids);
        return new ResponseEntity<String>("delete successfully!!", HttpStatus.OK) ;
    }
}
