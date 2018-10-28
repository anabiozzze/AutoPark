package app;

import app.dao.UserDaoImpl;
import app.models.Auto;
import app.models.User;

import java.util.List;

public class UserService {
    // класс-прокладка между ДАО и мейном

    UserDaoImpl userDao = new UserDaoImpl();

    public UserService() {
    }

    public User findUser(int id) {
        return userDao.getUserByID(id);
    }

    public List<User> findAllUsers() {
        return userDao.getAllUsers();
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(User user) {
        userDao.delUser(user);
    }

    public void createUser(User user) {
        userDao.createUser(user);
    }

    public Auto findAutoByID(int id) {
        return userDao.findAutoByID(id);
    }
}
