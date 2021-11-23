package org.VTI.Test;

import org.VTI.Entity.DetailDepartment;
import org.VTI.Entity.Exam;
import org.VTI.Repository.DetailDepartmentRepository;
import org.VTI.Repository.ExamRepository;

import java.util.List;

public class DetailDEpartmentTest {
    public static void main(String[] args) {

        DetailDepartmentRepository departmentRepository = new DetailDepartmentRepository();

        DetailDepartment detailDepartmentCreate = new DetailDepartment();
        detailDepartmentCreate.setName("Phong moi tao");
        detailDepartmentCreate.setEmulationPoint((short) 15);

        departmentRepository.createDetailDepartment(detailDepartmentCreate);

        List<DetailDepartment> detailDepartments= departmentRepository.getAllDetailDepartment() ;

        for (DetailDepartment detailDepartment: detailDepartments) {
            System.out.println(detailDepartment);
        }
    }
}
