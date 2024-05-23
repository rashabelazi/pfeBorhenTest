package org.example.eshopfinal.service.impl;


import org.example.eshopfinal.dto.UserRequest;
import org.example.eshopfinal.dto.UserResponse;
import org.example.eshopfinal.entities.security.User;

import java.util.List;

public interface UserService {

    UserResponse saveUser(UserRequest userRequest);

    UserResponse getCurrentUser();

    List<UserResponse> getAllUser();
    User getUserById(Long id);
    //UserInfo getUserByRole(Role role);
    User FlagUser(Long id);
    void UpdateUser(Long Id, User u);


}