package org.VTI.Repository;

import org.VTI.Entity.Salary;
import org.VTI.Entity.TypeQuestion;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TypeQuestionRepository {
    private HibernateUtils hibernateUtils;

    public TypeQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<TypeQuestion> getAllTypeQuestiony(){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<TypeQuestion> query = session.createQuery("FROM TypeQuestion ");

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




    public void createTypeQuestion (TypeQuestion typeQuestion){
        Session session = null;

        try {
            session =hibernateUtils.openSession();

            session.save(typeQuestion);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            if (session != null) session.close();
        }
    }
}
