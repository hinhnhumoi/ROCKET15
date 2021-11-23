import org.VTI.entity.TestingCategory;
import org.VTI.entity.Users;
import org.VTI.entity.UsersRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class HibernateProgram {
    public static void main(String[] args) {
        UsersRepository usersRepository = new UsersRepository();

        List<Users> users= usersRepository.getAllUsers();

        for (Users user: users) {
            System.out.println(user);
        }
    }
}
