package com.hotelbookingapp.service;

import java.util.List;

import com.hotelbookingapp.model.User;
import com.hotelbookingapp.model.dto.ResetPasswordDTO;
import com.hotelbookingapp.model.dto.UserDTO;
import com.hotelbookingapp.model.dto.UserRegistrationDTO;

public interface UserService {

    User saveUser(UserRegistrationDTO registrationDTO);

    // For registration
    User findUserByUsername(String username);

    UserDTO findUserDTOByUsername(String username);

    UserDTO findUserById(Long id);

    List<UserDTO> findAllUsers();

    void updateUser(UserDTO userDTO);

    void updateLoggedInUser(UserDTO userDTO);

    void deleteUserById(Long id);

    User resetPassword(ResetPasswordDTO resetPasswordDTO);

}
