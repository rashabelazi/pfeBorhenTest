package org.example.eshopfinal.service;


import org.example.eshopfinal.dto.UserRequest;
import org.example.eshopfinal.dto.UserResponse;

import java.util.List;


public interface UserService {

    UserResponse saveUser(UserRequest userRequest);

    UserResponse getUser();

    List<UserResponse> getAllUser();


}