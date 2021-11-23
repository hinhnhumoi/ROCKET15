package org.VTI.Repository;

import org.VTI.Entity.Account;
import org.VTI.Entity.Group;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class GroupRepository {
    private HibernateUtils hibernateUtils;

    public GroupRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Group> getAllGroup(){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Group> query = session.createQuery("FROM Group ");

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




    public void createGroup (Group group){
        Session session = null;

        try {
            session =hibernateUtils.openSession();
            session.beginTransaction();

            session.save(group);
            session.getTransaction().commit();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally {
            if (session != null) session.close();
        }
    }
}
