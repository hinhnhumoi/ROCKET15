package org.VTI.Repository;

import org.VTI.Entity.Department;
import org.VTI.Utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;



import java.util.List;

public class DepartmentRepository {
    private HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartment (){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Query<Department> query = session.createQuery("FROM Department");

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

    public Department getDepartmentById (short id){
        Session session = null;

        try {
            session = hibernateUtils.openSession();

            Department department = session.get(Department.class,id);

            return department;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (session !=null) session.close();
        }
    }

    public Department getDepartmentByName ( String name){

        Session session = null;

        try{
            session = hibernateUtils.openSession();

            Query<Department> query = session.createQuery("FROM Department where name=: name");

            query.setParameter("name", name);

            Department department = query.uniqueResult();

            return department;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (session !=null) session.close();
        }
    }

    public void createDepartment (Department department){
        Session session = null;

        try {
            session =hibernateUtils.openSession();

            session.save(department);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally {
            if (session != null) session.close();
        }
    }

    public void updateDepartment (short id, String newName){
        Session session = null;

        try {
            session =hibernateUtils.openSession();
            session.beginTransaction();

            Department department = (Department) session.load(Department.class,id);

            department.setName(newName);

            session.getTransaction().commit();

        }catch (Exception e) {
            System.out.println(e.getMessage());

        }finally {
            if (session != null) session.close();
        }
    }

    public void updateDepartment (Department department){
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.update(department);
            session.getTransaction().commit();
        }catch (Exception e) {
            System.out.println(e.getMessage());

        }finally {
            if (session != null) session.close();
        }
    }

    public void deleteDepartment (short id){
        Session session = null;

        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Department department = (Department) session.load(Department.class, id);

            session.delete(department);
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }finally {
            if (session != null) session.close();
        }
    }

    public boolean isDepExistsById (short id){
        Session session = null;
        try {
            session = hibernateUtils.openSession();

            Department department = session.get(Department.class,id);

            if (department == null) return false;
            return true;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (session != null) session.close();
        }
    }

    public boolean isDepExistsByName (String name){
        Department department= getDepartmentByName(name);

        if (department == null) return false;
        return true;
    }
}
