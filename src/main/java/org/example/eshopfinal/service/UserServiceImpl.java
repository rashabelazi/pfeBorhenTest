package org.example.eshopfinal.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.eshopfinal.dto.UserRequest;
import org.example.eshopfinal.dto.UserResponse;
import org.example.eshopfinal.entities.Role;
import org.example.eshopfinal.entities.UserInfo;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.example.eshopfinal.repository.UserRepository;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();



    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        if(userRequest.getUsername() == null){
            throw new RuntimeException("Parameter username is not found in request..!!");
        } else if(userRequest.getPassword() == null){
            throw new RuntimeException("Parameter password is not found in request..!!");
        }


//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
//        String usernameFromAccessToken = userDetail.getUsername();
//
//        UserInfo currentUser = userRepository.findByUsername(usernameFromAccessToken);

        UserInfo savedUser = null;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = userRequest.getPassword();
        String encodedPassword = encoder.encode(rawPassword);

        UserInfo user = modelMapper.map(userRequest, UserInfo.class);
        user.setPassword(encodedPassword);
        user.setRoles(userRequest.getRoles().stream().findFirst().get());
        if(userRequest.getId() != null){
            UserInfo oldUser = userRepository.findFirstById(userRequest.getId());
            if(oldUser != null){
                oldUser.setId(user.getId());
                oldUser.setPassword(user.getPassword());
                oldUser.setUsername(user.getUsername());
                oldUser.setRoles(user.getRoles());

                savedUser = userRepository.save(oldUser);
                userRepository.refresh(savedUser);
            } else {
                throw new RuntimeException("Can't find record with identifier: " + userRequest.getId());
            }
        } else {
//            user.setCreatedBy(currentUser);
            savedUser = userRepository.save(user);
        }
          userRepository.refresh(savedUser);

        UserResponse userResponse = modelMapper.map(savedUser, UserResponse.class);
        userResponse.setRoles(userRequest.getRoles());
        return userResponse;
    }

    @Override
    public UserResponse getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetail = (UserDetails) authentication.getPrincipal();
        String usernameFromAccessToken = userDetail.getUsername();
        UserInfo user = userRepository.findByUsername(usernameFromAccessToken);
        UserResponse userResponse = modelMapper.map(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<UserInfo> users = (List<UserInfo>) userRepository.findAll();
        Type setOfDTOsType = new TypeToken<List<UserResponse>>(){}.getType();
        List<UserResponse> userResponses = modelMapper.map(users, setOfDTOsType);
        return userResponses;
    }
    @Override
    public UserInfo getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserInfo FlagUser(Long id) {
        UserInfo user = userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        user.setFlag(!user.isFlag());
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void UpdateUser(Long id, UserInfo u) {
        UserInfo userEntityToUpdate = userRepository.findById(id).orElseThrow(()->
                new ResponseStatusException(HttpStatus.NOT_FOUND,"User existe pas dans la base de données")

        );
        if (u.getUsername() != null && !u.getUsername().isEmpty()){
            userEntityToUpdate.setUsername(u.getUsername());
        }

        if (u.getMail() != null && !u.getMail().isEmpty()){
            userEntityToUpdate.setMail(u.getMail());
        }
        if (u.getNumTel() != null ){
            userEntityToUpdate.setNumTel(u.getNumTel());
        }

        if (u.getPassword() != null && !u.getPassword().isEmpty()){
            userEntityToUpdate.setPassword(u.getPassword());
        }

    }

}


/*
    @Override
    public UserInfo getUserByRole(Role role) {
        return userRepository.findByRole(role);
    }

 */


