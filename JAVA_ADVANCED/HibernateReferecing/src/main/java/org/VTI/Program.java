package org.VTI;

import org.VTI.Entity.*;
import org.VTI.Entity.Enumerate.PositionName;
import org.VTI.Entity.Enumerate.SalaryName;
import org.VTI.Repository.*;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {
//        AccountRepository accountRepository = new AccountRepository();
        ExamRepository examRepository = new ExamRepository();

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

//        System.out.println(departmentRepository.isDepExistsById((short) 10));
//
//        System.out.println(departmentRepository.isDepExistsByName("Tùng"));


//        Position positionCreate = new Position();
//        positionCreate.setName(PositionName.PM);
//        positionRepository.createPosition(positionCreate);
//
//        List<Position> positions= positionRepository.getAllPosition();
//
//        for (Position position: positions) {
//            System.out.println(position);
//        }

//        Salary salaryCreate = new Salary();
//        salaryCreate.setSalary(SalaryName.PM);
//        salaryRepository.createSalary(salaryCreate);
//
//        List<Salary> salaries= salaryRepository.getAllSalary();
//
//        for (Salary salary: salaries) {
//            System.out.println(salary);
//        }


//        Account accountCreate = new Account();
//        accountCreate.setFirstName("dao");
//        accountCreate.setLastName("Tung");
//        accountCreate.setUserName("Tung01");
//        accountCreate.setEmail("hinhnhumoi@gmail.com");
//
//        accountRepository.createAccount(accountCreate);
//
//        List<Account> accounts= accountRepository.getAllAccount();
//
//        for (Account account: accounts) {
//            System.out.println(account);
//        }

        Exam examCreate = new Exam();
        examCreate.setTitle("Bai thi 1");
        examCreate.setDuration((short) 185);

        examRepository.createExam(examCreate);

        List<Exam> exams= examRepository.getAllExam();

        for (Exam exam: exams) {
            System.out.println(exam);
        }
    }
}
