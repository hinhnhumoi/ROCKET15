package org.VTI.Entity.Generator;

import org.VTI.Entity.Exam;
import org.VTI.Repository.ExamRepository;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;

public class ExamCodeGenerator implements IdentifierGenerator {

    ExamRepository examRepository ;

    public ExamCodeGenerator() {
        examRepository = new ExamRepository();
    }

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {

        Exam exam = (Exam) o;
        String prefix ;
        int count = 0;

        if (exam.getDuration() >= 180){
            prefix = "L";
        } else  if (exam.getDuration() >= 90) {
            prefix = "M";
        } else
            prefix = "S";

        return prefix + "-" +count;
    }
}
