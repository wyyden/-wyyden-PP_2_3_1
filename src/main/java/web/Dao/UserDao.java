package web.Dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUsers();

    public void save(User user);
    public void delete(Long id);

    public User update(User user);

    public User getUser(Long id);
}
