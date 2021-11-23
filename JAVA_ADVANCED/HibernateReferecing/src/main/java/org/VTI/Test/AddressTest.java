package org.VTI.Test;

import org.VTI.Entity.Address;
import org.VTI.Entity.DetailDepartment;
import org.VTI.Repository.AddressRepository;
import org.VTI.Repository.DetailDepartmentRepository;

import java.util.List;

public class AddressTest {
    public static void main(String[] args) {

        AddressRepository addressRepository = new AddressRepository();

//        Exam examCreate = new Exam();
//        examCreate.setTitle("Bai thi 1");
//        examCreate.setDuration((short) 185);

//        departmentRepository.createExam(examCreate);

        List<Address> addresses= addressRepository.getAllAddress() ;

        for (Address address: addresses) {
            System.out.println(address);
        }
    }
}
