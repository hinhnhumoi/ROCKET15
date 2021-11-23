package org.VTI.Test;

import org.VTI.Entity.Address;
import org.VTI.Entity.Group;
import org.VTI.Repository.AddressRepository;
import org.VTI.Repository.GroupRepository;

import java.util.List;

public class GroupTest {
    public static void main(String[] args) {

        GroupRepository groupRepository = new GroupRepository();

//        Exam examCreate = new Exam();
//        examCreate.setTitle("Bai thi 1");
//        examCreate.setDuration((short) 185);

//        departmentRepository.createExam(examCreate);

        List<Group> groups= groupRepository.getAllGroup() ;

        for (Group group: groups) {
            System.out.println(group);
        }
    }
}
