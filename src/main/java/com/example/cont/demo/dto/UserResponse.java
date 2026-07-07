package com.example.cont.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Integer userId;
    private String userName;
    private String email;
    private LocalDateTime createdTime;
    private UserProfileResponse userProfile;
}
