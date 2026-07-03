package com.example.cont.demo.service;

import com.example.cont.demo.dto.UserRequest;
import com.example.cont.demo.dto.UserResponse;
import com.example.cont.demo.mapper.UserMapper;
import com.example.cont.demo.model.User;
import com.example.cont.demo.repository.IUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final UserMapper mapper;

    public UserServiceImpl(IUserRepository userRepository, UserMapper mapper){
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> dbUserList = userRepository.findAll();
        List<UserResponse> userDtoList = new ArrayList<>();
        for (User user : dbUserList){
            UserResponse userResponse = mapper.toResponse(user);
            userDtoList.add(userResponse);
        }
        return userDtoList;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User newUser = mapper.toEntity(userRequest);
        newUser.setCreatedTime(LocalDateTime.now());
        userRepository.save(newUser);
        return mapper.toResponse(newUser);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserResponse userFindById(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            User user = optional.get();
            return mapper.toResponse(user);
        }
        throw new RuntimeException("No users were found associated with the requested id value.");
    }

    @Override
    public UserResponse updateUserById(UserRequest newUser, Integer id){
        Optional<User> dbUser = userRepository.findById(id);
        if (dbUser.isPresent()){
            mapper.updateEntity(newUser, dbUser.get());
            return mapper.toResponse(userRepository.save(dbUser.get()));
        }
        throw new RuntimeException("User not found.");
    }

    @Override
    public List<UserResponse> findByUserName(String name){
        List<User> userList = userRepository.findByName(name);
        if (userList.isEmpty()) {
            throw new RuntimeException("No user was found with the requested name.: " + name);
        }

        List<UserResponse> dtoList = new ArrayList<>();
        for (User user : userList){
            UserResponse userDto = mapper.toResponse(user);
            dtoList.add(userDto);
        }

        return dtoList;
    }

    // same-same, but different... but still same!
    // findByUserName and findByIdGreaterThan methods is same.

    @Override
    public List<UserResponse> findByIdGreaterThan(Integer id){
        List<User> userList = userRepository.findByIdGreaterThan(id);
        if (userList.isEmpty()) {
            throw new RuntimeException("No users of the desired value were found.: " + id);
        }

        List<UserResponse> dtoList = new ArrayList<>();
        for (User user : userList){
            UserResponse userDto = mapper.toResponse(user);
            dtoList.add(userDto);
        }
        return dtoList;
    }
}
