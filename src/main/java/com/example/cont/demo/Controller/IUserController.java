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
    public ResponseEntity<UserResponse> userFindById(Integer id) throws Exception;
    public ResponseEntity<UserResponse> updateUserById(UserRequest user, Integer id) throws Exception;
}
