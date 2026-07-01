package com.example.cont.demo.mapper;

import com.example.cont.demo.dto.UserRequest;
import com.example.cont.demo.dto.UserResponse;
import com.example.cont.demo.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserRequest request);
    UserResponse toResponse(User user);
    void updateEntity(UserRequest request, @MappingTarget User user);
}
