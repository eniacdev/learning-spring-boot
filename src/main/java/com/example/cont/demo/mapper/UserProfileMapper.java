package com.example.cont.demo.mapper;

import com.example.cont.demo.dto.UserProfileRequest;
import com.example.cont.demo.dto.UserProfileResponse;
import com.example.cont.demo.model.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserProfileMapper {
    UserProfileResponse toResponse(UserProfile userProfile);
    UserProfile toEntity(UserProfileRequest userProfileRequest);
}
