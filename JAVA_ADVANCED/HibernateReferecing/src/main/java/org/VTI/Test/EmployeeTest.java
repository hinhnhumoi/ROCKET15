package org.VTI.Test;

import org.VTI.Entity.Account;
import org.VTI.Entity.Employee;
import org.VTI.Repository.AccountRepository;
import org.VTI.Repository.EmployeeRepository;

import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) {

        EmployeeRepository employeeRepository = new EmployeeRepository();

//        Exam examCreate = new Exam();
//        examCreate.setTitle("Bai thi 1");
//        examCreate.setDuration((short) 185);

//        departmentRepository.createExam(examCreate);

        List<Employee> employees= employeeRepository.getAllEmployee() ;

        for (Employee employee: employees) {
            System.out.println(employee);
        }
    }
}
