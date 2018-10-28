package app;

import app.models.Auto;
import app.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class HibernateSessionFactoryUtil {
    // синглтон на фабрику сессий, которые мы далее будем использовать для дочступа к БД

    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory==null) {

            try {
                //считываем конфигурацию из Hibernate.cfg.xml, избегая указания параметров подключения вручную
                Configuration configuration = new Configuration().configure();
                //указываем конфигурации на наши классы
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Auto.class);

                //создаем фабрику сессий методом, актуальным для Hibernate 4.3
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
                builder.applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sessionFactory;
    }
}
