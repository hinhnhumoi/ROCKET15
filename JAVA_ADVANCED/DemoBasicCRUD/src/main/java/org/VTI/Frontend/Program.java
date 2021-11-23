package org.VTI.Frontend;

import org.VTI.Backend.DepartmentRepository;

public class Program {
    public static void main(String[] args) {

        DepartmentRepository departmentRepository = new DepartmentRepository();

//        Department departmentCreate = new Department();
//        departmentCreate.setName("Test");
//        departmentRepository.createDepartment(departmentCreate);


//        List<Department> departments= departmentRepository.getAllDepartment();
//
//        for (Department department: departments) {
//            System.out.println(department);
//        }

//        Department departmentById = departmentRepository.getDepartmentById((short) 2 );
//        System.out.println(departmentById);

//        Department departmentByName = departmentRepository.getDepartmentByName("Test ");
//        System.out.println(departmentByName);

//        departmentRepository.updateDepartment((short) 11,"cái gì đó");

//        Department departmentUpdate = new Department();
//        departmentUpdate.setId((short) 11);
//        departmentUpdate.setName("tên mới");
//        departmentRepository.updateDepartment(departmentUpdate);

//        departmentRepository.deleteDepartment((short) 11);

        System.out.println(departmentRepository.isDepExistsById((short) 10));

        System.out.println(departmentRepository.isDepExistsByName("Tùng"));

    }
}
