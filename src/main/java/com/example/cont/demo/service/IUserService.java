package com.example.cont.demo.service;

import com.example.cont.demo.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    public List<User> getAllUsers();
    public User addUser(User newUser);
    public Boolean deleteUser(Integer id);
    public User userFindById(Integer id) throws Exception;
    public User updateUserById(User user, Integer id) throws Exception;
}
