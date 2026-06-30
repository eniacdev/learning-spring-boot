package com.example.cont.demo.Controller;

import com.example.cont.demo.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {

    public ResponseEntity<List<User>> getAllUsers();
    public ResponseEntity<User> addUser(User newUser);
    public ResponseEntity<Boolean> deleteUserById(Integer id);
    public ResponseEntity<User> userFindById(Integer id) throws Exception;
    public ResponseEntity<User> updateUserById(User user, Integer id) throws Exception;
}
