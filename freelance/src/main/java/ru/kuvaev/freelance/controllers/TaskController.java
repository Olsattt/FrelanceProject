package ru.kuvaev.freelance.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kuvaev.freelance.models.Task;
import ru.kuvaev.freelance.services.TaskService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Task")
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping("/findAll")
    public ResponseEntity<List<Task>> findAll(){
        return ResponseEntity.ok(service.findAll()); // Возврат списка с HTTP статусом 200 OK
    }

    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<List<Task>> findByTitle(@PathVariable String title){
        return ResponseEntity.ok(service.findByTitle(title));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Task> findById(@PathVariable Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

//    @PostMapping("/createTask")
//    public ResponseEntity<String> createTask(@RequestBody  Task task){
//         // Вызов сервисного метода для сохранения задачи
//        return ResponseEntity.ok(service.taskCreate(task)); // Возврат HTTP статуса 200 OK с сообщением о результате
//    }

    @PostMapping("/createTaskWithUser")
    public ResponseEntity<String> createTaskWithUser(@RequestBody Map<String, Object> requestMap){
        Task task = new ObjectMapper().convertValue(requestMap.get("task"), Task.class); // Преобразование части запроса в объект Task
        int userId = (int) requestMap.get("userId"); // Получение ID пользователя из запроса
        return ResponseEntity.ok(service.taskCreate(task, userId)); // Создание задачи с указанием пользователя
    }

    @PutMapping("/updateTask")
    public ResponseEntity<String> updateTask(@RequestBody Task task){
        return ResponseEntity.ok(service.taskUpdate(task));
    }

    @DeleteMapping("/deleteTask")
    public ResponseEntity<String> deleteTask(@RequestBody Task task){
        return ResponseEntity.ok(service.taskDelete(task));
    }
}
