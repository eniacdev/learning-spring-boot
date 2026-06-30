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
public class UserServiceImpl implements IUserService{

    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> dbUserList = userRepository.findAll();
        List<UserResponse> userDtoList = new ArrayList<>();
        for (User user : dbUserList){
            UserResponse userResponse = UserMapper.toResponse(user);
            userDtoList.add(userResponse);
        }
        return userDtoList;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User newUser = UserMapper.toEntity(userRequest);
        newUser.setCreatedTime(LocalDateTime.now());
        userRepository.save(newUser);
        return UserMapper.toResponse(newUser);
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
    public UserResponse userFindById(Integer id) throws Exception{
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            User user = optional.get();
            return UserMapper.toResponse(user);
        }
        throw new Exception("istenilen bir id değerine bağlı kullanıcı bulunamadı.");
    }

    @Override
    public UserResponse updateUserById(UserRequest newUser, Integer id) throws Exception{
        Optional<User> dbUser = userRepository.findById(id);
        if (dbUser.isPresent()){
            UserMapper.updateEntity(newUser, dbUser.get());
            return UserMapper.toResponse(userRepository.save(dbUser.get()));
        }
        throw new Exception("kullanıcı bulunamadı");
    }
}
