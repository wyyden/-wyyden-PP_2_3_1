package web.service;

import org.springframework.stereotype.Service;
import web.Dao.UserDao;
import web.model.User;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService{

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getList() {
        return (List<User>) userDao.getAllUsers();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public User get(Long id) {
        return userDao.getUser(id);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }
}
