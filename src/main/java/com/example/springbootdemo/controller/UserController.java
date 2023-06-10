package com.example.springbootdemo.controller;


import com.example.springbootdemo.model.User;
import com.example.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/get/all")
    public List<User> getAllUser(){
        return  userService.getAllUser();
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody @Valid User user){
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        return userService.deleteUser(id);
    }

    @PutMapping("/update/{id}")
    public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @PatchMapping("/partial/update/{id}")
    public User partialUpdate(@PathVariable("id") Long id, @RequestBody Map<String,Object> obj){
        return userService.partialUpdate(id,obj);

    }

}
