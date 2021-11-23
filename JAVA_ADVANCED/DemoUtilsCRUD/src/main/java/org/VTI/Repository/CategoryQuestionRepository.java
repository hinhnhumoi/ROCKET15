package org.VTI.Repository;

import org.VTI.Entity.CategoryQuestion;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryQuestionRepository {
    private HibernateUtils hibernateUtils;

    public CategoryQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<CategoryQuestion> getAllCategory(){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<CategoryQuestion> query = session.createQuery("FROM CategoryQuestion ");

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




    public void createCategory (CategoryQuestion categoryQuestion){
        Session session = null;

        try {
            session =hibernateUtils.openSession();
            session.beginTransaction();

            session.save(categoryQuestion);
            session.getTransaction().commit();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally {
            if (session != null) session.close();
        }
    }
}
