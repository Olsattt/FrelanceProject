package ru.kuvaev.freelance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuvaev.freelance.models.Task;
import ru.kuvaev.freelance.models.User;
import ru.kuvaev.freelance.repositories.TaskRepos;
import ru.kuvaev.freelance.repositories.UserRepos;

import java.util.List;

@Service
public class UserService {

    User user = new User();

    @Autowired
    UserRepos userRepos;

    public User userCreate(User user){
        return userRepos.save(user);
    }

    public String userDelete(User user){
        userRepos.delete(user);
        return "Пользователь удален";
    }
    public User userUpdate(User user){
        return userRepos.save(user);
    }
    public List<User> findAll(){
        return userRepos.findAll();
    }
    public List<User> findByName(String name){
        return userRepos.findByName(name);
    }

    public User findById(int id){
        return userRepos.findById(id).orElse(user);
    }
}
