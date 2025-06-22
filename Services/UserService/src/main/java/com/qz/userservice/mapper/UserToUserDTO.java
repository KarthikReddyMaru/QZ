package com.qz.userservice.mapper;

import com.qz.userservice.dto.UserDTO;
import com.qz.userservice.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserToUserDTO implements Mapper<User, UserDTO> {
    @Override
    public UserDTO map(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        return userDTO;
    }
}
