package app.dao;

import app.models.Auto;
import app.models.User;

import java.util.List;

public interface UserDao {

    void createUser(User user);

    User getUserByID(int id);

    List<User> getAllUsers();

    void delUser(User user);

    public void update (User user);

    Auto findAutoByID(int id);

}
