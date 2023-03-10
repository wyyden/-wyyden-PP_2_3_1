package web.service;

import web.model.User;

import java.util.List;

public interface UserService {

    public List<User> getList();

    public void save(User user);
    public void delete(Long id);

    public User get(Long id);

}
