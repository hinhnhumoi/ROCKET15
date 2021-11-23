package org.VTI.Repository;

import org.VTI.Entity.Answer;
import org.VTI.Entity.Group;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AnswerRepository {
    private HibernateUtils hibernateUtils;

    public AnswerRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Answer> getAllAnswer(){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Answer> query = session.createQuery("FROM Answer ");

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




    public void createGroup (Answer answer){
        Session session = null;

        try {
            session =hibernateUtils.openSession();
            session.beginTransaction();

            session.save(answer);
            session.getTransaction().commit();

        }catch (Exception e) {
            System.out.println(e.getMessage());

            session.getTransaction().rollback();
        }finally {
            if (session != null) session.close();
        }
    }

}
