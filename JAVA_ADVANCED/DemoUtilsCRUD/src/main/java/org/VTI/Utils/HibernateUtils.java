package org.VTI.Utils;

import com.github.fluent.hibernate.cfg.scanner.EntityScanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static HibernateUtils hibernateUtils;

    private Configuration configuration;
    private SessionFactory sessionFactory;

    private HibernateUtils () {
        configure();
    }

    public static HibernateUtils getInstance() {
        if (hibernateUtils == null)
            hibernateUtils = new HibernateUtils();

        return hibernateUtils;
    }

    private void configure() {
        // load configuration
        configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // add entity
        EntityScanner.scanPackages("org.VTI.Entity").addTo(configuration);
    }

    private SessionFactory buildSessionFactory() {
        if (null == sessionFactory || sessionFactory.isClosed()) {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public void closeFactory() {
        if (null != sessionFactory && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }

    public Session openSession() {
        buildSessionFactory();
        return sessionFactory.openSession();
    }

}
