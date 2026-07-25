package com.example.cont.demo.Controller;

import com.example.cont.demo.dto.UserRequest;
import com.example.cont.demo.dto.UserResponse;
import com.example.cont.demo.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserController {

    public ResponseEntity<List<UserResponse>> getAllUsers();
    public ResponseEntity<UserResponse> createUser(UserRequest newUser);
    public ResponseEntity<Boolean> deleteUserById(Integer id);
    public ResponseEntity<UserResponse> userFindById(Integer id);
    public ResponseEntity<UserResponse> updateUserById(UserRequest user, Integer id);
    public ResponseEntity<List<UserResponse>> findByUserName(String name);
    public ResponseEntity<List<UserResponse>> findByIdGreaterThan(Integer id);
    public ResponseEntity<List<UserResponse>> findByOrderByName();
    public ResponseEntity<List<UserResponse>> findAllUser();
    public ResponseEntity<List<String>> findAllUserName();
}
