package com.example.cont.demo.mapper;

import com.example.cont.demo.dto.UserRequest;
import com.example.cont.demo.dto.UserResponse;
import com.example.cont.demo.model.User;

public  class UserMapper {

    public static User toEntity(UserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        return user;
    }

    public static UserResponse toResponse(User user){
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setLastname(user.getLastname());
        response.setCreatedTime(user.getCreatedTime());

        return response;
    }

    public static void updateEntity(UserRequest request, User user){
        user.setName(request.getName());
        user.setLastname(request.getLastname());
        user.setPassword(request.getPassword());
    }

}
