package com.example.cont.demo.service;

import com.example.cont.demo.model.User;
import com.example.cont.demo.repository.IUserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{

    private final IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public User addUser(User newUser) {
        return userRepository.save(newUser);
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
    public User userFindById(Integer id) throws Exception{
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            User user = optional.get();
            return user;
        }
        throw new Exception("istenilen bir id değerine bağlı kullanıcı bulunamadı.");
    }

    @Override
    public User updateUserById(User newUser, Integer id) throws Exception{
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()){
            User dbUser = optional.get();
            dbUser.setName(newUser.getName());
            dbUser.setLastname(newUser.getLastname());
            userRepository.save(newUser);
            return newUser;
        }
        throw new Exception("kullanıcı bulunamadı");
    }
}
