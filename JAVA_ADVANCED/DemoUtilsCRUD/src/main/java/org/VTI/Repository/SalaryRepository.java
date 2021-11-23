package org.VTI.Repository;

import org.VTI.Entity.Position;
import org.VTI.Entity.Salary;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class SalaryRepository {
    private HibernateUtils hibernateUtils;

    public SalaryRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Salary> getAllSalary(){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Salary> query = session.createQuery("FROM Salary ");

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




    public void createSalary (Salary salary){
        Session session = null;

        try {
            session =hibernateUtils.openSession();

            session.save(salary);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            if (session != null) session.close();
        }
    }
}
