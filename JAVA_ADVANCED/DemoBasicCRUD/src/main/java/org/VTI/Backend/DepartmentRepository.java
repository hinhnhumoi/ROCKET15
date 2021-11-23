package org.VTI.Backend;

import org.VTI.Entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class DepartmentRepository implements IDepartmentRepository{
    // Khởi tạo session factory chung
    private SessionFactory sessionFactory;
    // hàm khởi tạo SessionFactory  dùng buildSessionFactory bên dưới
    public DepartmentRepository() {
        sessionFactory = buildSessionFactory();
    }
    // lấy kết nối DB thông qua file config
    private SessionFactory buildSessionFactory (){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Department.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Department> getAllDepartment (){
        Session session = null;

        try {
            session = sessionFactory.openSession();

            Query<Department> query = session.createQuery("FROM Department");

            return query.list();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public Department getDepartmentById (short id){
        Session session = null;

        try {
            session = sessionFactory.openSession();

            Department department = session.get(Department.class,id);

            return department;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        } finally {
            if (session !=null) session.close();
        }
    }

    @Override
    public Department getDepartmentByName ( String name){

        Session session = null;

        try{
            session = sessionFactory.openSession();

            Query<Department> query = session.createQuery("FROM Department where name=: name");

            query.setParameter("name", name);

            Department department = query.uniqueResult();

            return department;
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            if (session !=null) session.close();
        }
    }

    @Override
    public void createDepartment (Department department){
        Session session = null;

        try {
            session =sessionFactory.openSession();

            session.save(department);

        }catch (Exception e){
            session.getTransaction().rollback();

            System.out.println(e.getMessage());

        }finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updateDepartment (short id, String newName){
        Session session = null;

        try {
            session =sessionFactory.openSession();
            session.beginTransaction();

            Department department = (Department) session.load(Department.class,id);

            department.setName(newName);

            session.getTransaction().commit();

        }catch (Exception e){
            session.getTransaction().rollback();

            System.out.println(e.getMessage());
        }finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updateDepartment (Department department){
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            session.update(department);
            session.getTransaction().commit();
        }catch (Exception e){
            session.getTransaction().rollback();

            System.out.println(e.getMessage());

        }finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deleteDepartment (short id){
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();

            Department department = (Department) session.load(Department.class, id);

            session.delete(department);
            session.getTransaction().commit();

        }catch (Exception e){
            session.getTransaction().rollback();

            System.out.println(e.getMessage());

        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public boolean isDepExistsById (short id){
        Session session = null;
        try {
            session = sessionFactory.openSession();

            Department department = session.get(Department.class,id);

            if (department == null) return false;
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public boolean isDepExistsByName (String name){
        Department department= getDepartmentByName(name);

        if (department == null) return false;
        return true;
    }
}
