package org.VTI.Utils;

import org.VTI.Entity.Exam;
import org.VTI.Entity.Group;
import org.VTI.Entity.TypeQuestion;
import org.VTI.Repository.ExamRepository;
import org.VTI.Repository.GroupRepository;
import org.VTI.Repository.TypeQuestionRepository;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        TypeQuestionRepository typeQuestionRepository = new TypeQuestionRepository();

//        Group groupCreate = new Group();
//        groupCreate.setName("Tung");
//
//        groupRepository.createGroup(groupCreate);

        List<TypeQuestion> typeQuestions= typeQuestionRepository.getAllTypeQuestiony();

        for (TypeQuestion typeQuestion: typeQuestions) {
            System.out.println(typeQuestion);
        }
    }
}
