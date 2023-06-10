package com.example.springbootdemo.service;

import com.example.springbootdemo.model.User;
import com.example.springbootdemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public String deleteUser(Long id) {
        userRepository.deleteById(id);
        return "deleted";
    }

    public User updateUser(Long id, User user) {
        User user1 = userRepository.findById(id).get();
        user1.setCountry(user.getCountry());
        user1.setName(user.getName());
        user1.setPassword(user.getPassword());
        user1.setEmailId(user.getEmailId());
        user1.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(user1);
    }

    public User partialUpdate(Long id, Map<String, Object> obj) {
        User user = userRepository.findById(id).get();
        obj.forEach((key,value)->{
            Field field = ReflectionUtils.findField(User.class,key);
            field.setAccessible(true);
            ReflectionUtils.setField(field,user,value);
        });
        return userRepository.save(user);
    }
}
