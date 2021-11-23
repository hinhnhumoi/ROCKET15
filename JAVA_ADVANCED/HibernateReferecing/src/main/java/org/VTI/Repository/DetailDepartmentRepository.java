package org.VTI.Repository;

import org.VTI.Entity.DetailDepartment;
import org.VTI.Entity.Group;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DetailDepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DetailDepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<DetailDepartment> getAllDetailDepartment(){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment ");

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




    public void createDetailDepartment (DetailDepartment detailDepartment){
        Session session = null;

        try {
            session =hibernateUtils.openSession();
            session.beginTransaction();

            session.save(detailDepartment);
            session.getTransaction().commit();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally {
            if (session != null) session.close();
        }
    }
}
