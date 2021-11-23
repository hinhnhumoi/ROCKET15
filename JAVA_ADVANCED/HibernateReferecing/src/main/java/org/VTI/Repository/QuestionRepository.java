package org.VTI.Repository;

import org.VTI.Entity.Group;
import org.VTI.Entity.Question;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class QuestionRepository {
    private HibernateUtils hibernateUtils;

    public QuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Question> getAllQuestion (){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Question> query = session.createQuery("FROM Question ");

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




    public void createQuestion  (Question question){
        Session session = null;

        try {
            session =hibernateUtils.openSession();
            session.beginTransaction();

            session.save(question);
            session.getTransaction().commit();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally {
            if (session != null) session.close();
        }
    }
}
