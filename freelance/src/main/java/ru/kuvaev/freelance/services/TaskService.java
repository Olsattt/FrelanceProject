package ru.kuvaev.freelance.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kuvaev.freelance.models.Task;
import ru.kuvaev.freelance.models.User;
import ru.kuvaev.freelance.repositories.TaskRepos;
import ru.kuvaev.freelance.repositories.UserRepos;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService{

    Task task = new Task();
    @Autowired
    TaskRepos taskRepos;
    @Autowired
    UserRepos userRepos;

//    public String taskCreate(Task task){
//        taskRepos.save(task);
//        return "Объявление создано";
//    }
public String taskCreate(Task task, int userId){
    Optional<User> optionalUser = userRepos.findById(userId); // Предполагается, что у вас есть UserRepository
    if(optionalUser.isPresent()){
        User user = optionalUser.get();
        task.setUser(user); // Устанавливаем пользователя для задачи
    } else {
        return "Пользователь не найден";
    }
    taskRepos.save(task);
    return "Объявление создано";
}



    public String taskDelete(Task task){
        taskRepos.delete(task);
        return "Запись удалена";
    }
    public String taskUpdate(Task task){
        taskRepos.save(task);
        return "Запись обновлена";
    }
    public List<Task> findAll(){
       return taskRepos.findAll();
    }
    public List<Task> findByTitle(String title){
        return taskRepos.findByTitle(title);
    }
    public Task findById(int id){
        return taskRepos.findById(id).orElse(task);
    }

}
