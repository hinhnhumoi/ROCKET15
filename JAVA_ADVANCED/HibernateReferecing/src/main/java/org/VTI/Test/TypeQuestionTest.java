package org.VTI.Test;

import org.VTI.Entity.Position;
import org.VTI.Entity.TypeQuestion;
import org.VTI.Repository.PositionRepository;
import org.VTI.Repository.TypeQuestionRepository;

import java.util.List;

public class TypeQuestionTest {
    public static void main(String[] args) {

        TypeQuestionRepository typeQuestionRepository = new TypeQuestionRepository();

//
//        Position positionCreate = new Position();
//        positionCreate.setName(PositionName.PM);
//        positionRepository.createPosition(positionCreate);

        List<TypeQuestion> typeQuestions= typeQuestionRepository.getAllTypeQuestiony();

        for (TypeQuestion typeQuestion: typeQuestions) {
            System.out.println(typeQuestion);
        }
    }
}
