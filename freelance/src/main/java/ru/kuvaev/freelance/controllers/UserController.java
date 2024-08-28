package ru.kuvaev.freelance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kuvaev.freelance.models.User;
import ru.kuvaev.freelance.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<User>> findByName(@PathVariable String name){
        return ResponseEntity.ok(userService.findByName(name));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping ("/userCreate")
    public ResponseEntity<User> userCreate(@RequestBody User user){
        return ResponseEntity.ok(userService.userCreate(user));
    }

    @DeleteMapping("/userDelete")
    public ResponseEntity<String> userDelete(@RequestBody User user){
        return ResponseEntity.ok(userService.userDelete(user));
    }

    @PutMapping("/userUpdate")
    public ResponseEntity<User> userUpdate(@RequestBody User user){
        return ResponseEntity.ok(userService.userUpdate(user));
    }
}
