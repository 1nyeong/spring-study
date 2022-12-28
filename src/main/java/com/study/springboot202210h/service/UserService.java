package com.study.springboot202210h.service;

import com.study.springboot202210h.repository.UserRepository;
import com.study.springboot202210h.web.dto.UserDto;
import com.study.springboot202210h.web.exception.CustomDuplicateUsernameException;
import com.study.springboot202210h.web.exception.CustomValidException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int addUser(UserDto userDto) {
        System.out.println("데이터베이스에 insert 전 : " + userDto);
        userRepository.saveUser(userDto);
        System.out.println("데이터베이스에 insert 후 : " + userDto);
        return userDto.getUserId();
    }

    public UserDto getUser(int userId) {
        UserDto userDto = null;
        userDto = userRepository.findUserByUserId(userId);
        return userDto;
    }

    public void duplicateUsername(String username) {
        UserDto userDto = userRepository.findUserByUsername(username);
        if(userDto != null) {
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "이미 존재하는 사용자이름 입니다.");
            throw new CustomValidException(errorMap);
        }
    }


}