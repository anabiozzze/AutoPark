package app.dao;

import app.HibernateSessionFactoryUtil;
import app.models.Auto;
import app.models.User;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDaoImpl implements UserDao {
    // класс, отвечающий исключительно за получение информации из БД

    public void createUser(User user) {
        // сперва создадим сессию подключения к БД, затем - отпроем и проведем транзакцию нового пользователя в БД
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction1 = session.beginTransaction();

        session.save(user);
        transaction1.commit();
        session.close();
    }

    public User getUserByID(int id) {
        // через фабрику открываем новую сессию доступа к БД и берем сущность нужного класса под нужным id
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();

        return user;
    }

    public List<User> getAllUsers() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<User> users = session.createQuery("From User").list();
        session.close();

        return users;
    }


    public void delUser(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction2 = session.beginTransaction();

        session.delete(user);
        transaction2.commit();
        session.close();
    }

    public void update(User user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction3 = session.beginTransaction();

        session.update(user);
        transaction3.commit();
        session.close();
    }

    public Auto findAutoByID(int id) {
        // через фабрику открываем новую сессию доступа к БД и берем сущность нужного класса под нужным id
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Auto auto = session.get(Auto.class, id);
        session.close();

        return auto;
    }


}
