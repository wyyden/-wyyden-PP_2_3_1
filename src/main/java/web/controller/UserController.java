package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.Dao.UserDao;
import web.Dao.UserDaoImp;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping(value = "/")
    public String printWelcome(ModelMap model) {
        model.addAttribute("users", userDao.getUserList());
        return "index";
    }

    @GetMapping(value = "/addUser")
    public String newUser(ModelMap model) {
		model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userDao.save(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("user", userDao.show(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDao.update(id, user);
        return "redirect:/";
    }

    @RequestMapping("/{id}/delete")
    public String delete(@PathVariable("id") int id) {
        userDao.delete(id);
        return "redirect:/";
    }
}