package fr.utbm.lo54.primeProject;

import fr.utbm.lo54.primeProject.entity.Course;
import fr.utbm.lo54.primeProject.entity.User;
import fr.utbm.lo54.primeProject.repository.CourseRepository;
import fr.utbm.lo54.primeProject.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * Created by Victor on 11/06/2017.
 */
public class App0 {

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<User> result = session.createQuery("from User").list();
        session.getTransaction().commit();
        session.close();

        UserRepository userRepository = applicationContext.getBean(UserRepository.class);

        List<User> users = userRepository.findAll();

    }
}
