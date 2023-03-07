package web.Dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getUserList();

    public User show(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);
}
