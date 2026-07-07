package com.example.cont.demo.dto;

import com.example.cont.demo.model.UserProfile;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {


    private String userName;
    private String password;
    private String email;
    private UserProfileRequest userProfile;
}
