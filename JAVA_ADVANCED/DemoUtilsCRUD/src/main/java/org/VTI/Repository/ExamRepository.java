package org.VTI.Repository;

import org.VTI.Entity.Account;
import org.VTI.Entity.Exam;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ExamRepository {

    private HibernateUtils hibernateUtils;

    public ExamRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Exam> getAllExam (){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Exam> query = session.createQuery("FROM Exam ");

            return query.list();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (session != null){
                session.close();
            }
        }
    }


    public void createExam (Exam exam){
        Session session = null;

        try {
            session =hibernateUtils.openSession();
            session.beginTransaction();

            session.save(exam);
            session.getTransaction().commit();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally {
            if (session != null) session.close();
        }
    }

    public short getCountOfExamCode (short duration ){
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Query<Short> query = session.createQuery("SELECT COUNT(*) FROM Exam WHERE duration >= : durationPara");

            query.setParameter("durationPara", duration);

            return query.uniqueResult();

        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }finally {
            if (session != null){
                session.close();
            }
        }
    }
}
