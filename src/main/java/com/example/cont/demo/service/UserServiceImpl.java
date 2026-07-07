package com.example.cont.demo.service;

import com.example.cont.demo.dto.UserRequest;
import com.example.cont.demo.dto.UserResponse;
import com.example.cont.demo.mapper.UserMapper;
import com.example.cont.demo.model.User;
import com.example.cont.demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

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

    private List<UserResponse> responseToList(List<User> userList){
        List<UserResponse> userDtoList = new ArrayList<>();
        if (userList.isEmpty()){
            throw new RuntimeException("The list must not be empty.");
        }
        for (User user : userList){
            userDtoList.add(mapper.toResponseList(user));
        }
        return userDtoList;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> dbUserList = userRepository.findAll();
        return responseToList(dbUserList);
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User newUser = mapper.toEntity(userRequest);
        if(userRequest.getUserProfile() != null){
            newUser.getUserProfile().setUser(newUser);
        }
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
        List<User> userList = userRepository.findByUserName(name);
        return responseToList(userList);
    }

    @Override
    public List<UserResponse> findByIdGreaterThan(Integer id){
        List<User> userList = userRepository.findByUserIdGreaterThan(id);
        return responseToList(userList);
    }

    @Override
    public List<UserResponse> findByOrderByName() {
        List<User> userList = userRepository.findAllByOrderByUserName();
        return responseToList(userList);
    }


}
