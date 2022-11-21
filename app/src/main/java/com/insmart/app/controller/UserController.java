package com.insmart.app.controller;

import com.insmart.app.model.User;
import com.insmart.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }
    @GetMapping("/get/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }
    @GetMapping("/get")
    public List<User> findAll() {
        return userService.findAll();
    }
    @PutMapping("/update/{id}")
    public User update(@PathVariable User user,@PathVariable Long id) {
        return userService.update(user,id);
    }
}
