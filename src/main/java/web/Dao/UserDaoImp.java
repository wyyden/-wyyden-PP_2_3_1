package web.Dao;

import org.springframework.stereotype.Component;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImp implements UserDao{

    static int id = 0;
    List<User> users;

    {
        users = new ArrayList<>();
        users.add(new User(++id,"user1", "user1fam", "user1@mail"));
        users.add(new User(++id,"user2", "user2fam", "user2@mail"));
        users.add(new User(++id,"user3", "user3fam", "user3@mail"));
        users.add(new User(++id, "user4", "user4fam", "user4@mail"));
        users.add(new User(++id, "user5", "user5fam", "user5@mail"));
    }

    @Override
    public List<User> getUserList() {
        return users;
    }

    @Override
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }


    @Override
    public void save(User user) {
        user.setId(++id);
        users.add(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToUpdate = show(id);
        userToUpdate.setName(updatedUser.getName());
        userToUpdate.setLastName(updatedUser.getLastName());
        userToUpdate.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(int id) {
        users.removeIf(usr -> usr.getId() == id);
    }


}
