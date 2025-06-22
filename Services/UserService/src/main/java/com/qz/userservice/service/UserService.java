package com.qz.userservice.service;

import com.qz.userservice.dto.UserDTO;
import com.qz.userservice.exception.UserNotFoundException;
import com.qz.userservice.mapper.UserToUserDTO;
import com.qz.userservice.model.User;
import com.qz.userservice.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepo userRepo;
    private UserToUserDTO mapper;

    public UserDTO findByUserName(String username) throws UserNotFoundException {
        User user = userRepo.findByUsername(username)
                            .orElseThrow(() -> new UserNotFoundException("User not found with the username "+username));
        return mapper.map(user);
    }

    public UserDTO save(User newUser) {
        User user = userRepo.save(newUser);
        return mapper.map(user);
    }
}
