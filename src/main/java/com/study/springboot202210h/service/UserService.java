package com.study.springboot202210h.service;

import com.study.springboot202210h.repository.UserRepository;
import com.study.springboot202210h.web.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int addUser(UserDto userDto){
        int userId = 0;
        userId = userRepository.saveUser(userDto);

        return userId;
    }

    public UserDto getUser(int userId){
        UserDto userDto = null;
        userDto = userRepository.findUserByUserId(userId);

        return userDto;
    }

}
