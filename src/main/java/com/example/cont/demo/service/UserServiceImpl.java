package com.example.cont.demo.service;

import com.example.cont.demo.dto.UserRequest;
import com.example.cont.demo.dto.UserResponse;
import com.example.cont.demo.mapper.UserMapper;
import com.example.cont.demo.mapper.UserProfileMapper;
import com.example.cont.demo.model.User;
import com.example.cont.demo.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final UserMapper userMapper;
    private final UserProfileMapper profileMapper;

    public UserServiceImpl(IUserRepository userRepository, UserMapper userMapper, UserProfileMapper profileMapper){
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.profileMapper = profileMapper;
    }

    private List<UserResponse> responseToList(List<User> userList){
        if (userList.isEmpty()){
            throw new RuntimeException("The list must not be empty.");
        }
        List<UserResponse> userDtoList = new ArrayList<>();
        for (User user : userList){
            userDtoList.add(userMapper.toResponseList(user));
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
        User newUser = userMapper.toEntity(userRequest);
        if (userRequest.getUserProfile() != null){
            newUser.getUserProfile().setUser(newUser);
        }
        userRepository.save(newUser);
        return userMapper.toResponse(newUser);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public UserResponse userFindById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No users were found associated with the requested id value."));
        return userMapper.toResponse(user);
    }

    @Override
    public UserResponse updateUserById(UserRequest newUser, Integer id){
        User dbUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User is not found"));
       userMapper.updateEntity(newUser, dbUser);
       if (newUser.getUserProfile() != null) {
           profileMapper.updateEntity(newUser.getUserProfile(), dbUser.getUserProfile());
       }
       return userMapper.toResponse(userRepository.save(dbUser));
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

    @Override
    public List<UserResponse> findAllUser() {
        List<User> userList = userRepository.findAllUser();
        return responseToList(userList);
    }

    @Override
    public List<String> findAllUserName() {
        return userRepository.findAllUserName();
    }


}
