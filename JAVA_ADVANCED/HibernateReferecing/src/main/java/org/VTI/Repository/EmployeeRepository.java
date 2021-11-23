package org.VTI.Repository;

import org.VTI.Entity.Account;
import org.VTI.Entity.Employee;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeRepository {
    private HibernateUtils hibernateUtils;

    public EmployeeRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public List<Employee> getAllEmployee(){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Employee> query = session.createQuery("FROM Employee ");

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




    public void createEmployee (Employee employee){
        Session session = null;

        try {
            session =hibernateUtils.openSession();
            session.beginTransaction();

            session.save(employee);
            session.getTransaction().commit();

        }catch (Exception e) {
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }finally {
            if (session != null) session.close();
        }
    }

}
