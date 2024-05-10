package org.example.eshopfinal.service;


import org.example.eshopfinal.dto.UserRequest;
import org.example.eshopfinal.dto.UserResponse;
import org.example.eshopfinal.entities.Role;
import org.example.eshopfinal.entities.UserInfo;
import org.springframework.security.core.userdetails.User;

import java.util.List;


public interface UserService {

    UserResponse saveUser(UserRequest userRequest);

    UserResponse getUser();

    List<UserResponse> getAllUser();
    UserInfo getUserById(Long id);
    //UserInfo getUserByRole(Role role);


}