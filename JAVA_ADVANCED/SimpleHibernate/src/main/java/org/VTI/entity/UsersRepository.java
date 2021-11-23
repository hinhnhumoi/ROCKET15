package org.VTI.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class UsersRepository {
    // Khởi tạo session factory chung
    private SessionFactory sessionFactory;

    // hàm khởi tạo SessionFactory  dùng buildSessionFactory bên dưới
    public UsersRepository() {
        sessionFactory = buildSessionFactory();
    }

    // lấy kết nối DB thông qua file config
    private SessionFactory buildSessionFactory (){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        configuration.addAnnotatedClass(Users.class);
        configuration.addAnnotatedClass(Address.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();

        return configuration.buildSessionFactory(serviceRegistry);
    }

    @SuppressWarnings("unchecked")
    public List<Users> getAllUsers (){
        Session session = null;

        try {
            session = sessionFactory.openSession();

            Query<Users> query = session.createQuery("FROM Users ");

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
}
