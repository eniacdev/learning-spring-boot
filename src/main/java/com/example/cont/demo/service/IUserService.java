package com.example.cont.demo.service;

import com.example.cont.demo.dto.UserRequest;
import com.example.cont.demo.dto.UserResponse;
import com.example.cont.demo.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    public List<UserResponse> getAllUsers();
    public UserResponse addUser(UserRequest newUser);
    public Boolean deleteUser(Integer id);
    public UserResponse userFindById(Integer id);
    public UserResponse updateUserById(UserRequest user, Integer id);
    public List<UserResponse> findByUserName(String name);
    public List<UserResponse> findByIdGreaterThan(Integer id);
    public List<UserResponse> findByOrderByName();
}
