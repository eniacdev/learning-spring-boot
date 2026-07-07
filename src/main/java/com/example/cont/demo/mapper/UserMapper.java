package com.example.cont.demo.mapper;

import com.example.cont.demo.dto.UserRequest;
import com.example.cont.demo.dto.UserResponse;
import com.example.cont.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = UserProfileMapper.class)
public interface UserMapper {
    User toEntity(UserRequest request);
    UserResponse toResponse(User user);
    UserResponse toResponseList(User user);
    void updateEntity(UserRequest request, @MappingTarget User user);
}
