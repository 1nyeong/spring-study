package com.study.springboot202210h.web.controller;

import com.study.springboot202210h.web.dto.CMRespDto;
import com.study.springboot202210h.web.dto.UserDto;
import com.study.springboot202210h.web.exception.CustomTestException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RestController1 {

    @GetMapping("/api/test/user-dto/obj")
    public ResponseEntity<?> getUserDtoObj(){
        UserDto userDto = UserDto.builder()
                .userId(100)
                .username("abc")
                .password("1234")
                .build();
        HttpHeaders headers = new HttpHeaders();
        headers.set("UserDto", userDto.toString());
        return ResponseEntity.ok()
                .headers(headers)
                .body(userDto);
//        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(userDto);
//      return new ResponseEntity<UserDto>(userDto, HttpStatus.INTERNAL_SERVER_ERROR);
//      response.setStatus(400);
//      return userDto;
    }

    @GetMapping("/api/test/user-dto/cm")
    public ResponseEntity<?> getUserDto(){
        UserDto userDto = UserDto.builder()
                .username("test")
                .password("1234")
                .build();
        return ResponseEntity.ok().body(new CMRespDto<>("test유저 정보 응답", null));
//        return ResponseEntity.ok().body(CMRespDto.builder().message("test유저 정보 응답").data(userDto)); 윗줄과 똑가틍
    }
    @PostMapping("api/test/user")
    public ResponseEntity<?> addUser(@RequestBody UserDto userDto){

        if(userDto.getUsername().isBlank()){
            Map<String, String> errorMap = new HashMap<>();
            errorMap.put("username", "아이디를 입력하세요.");

            throw new CustomTestException("유효성 검사 실패", errorMap);
        }

        userDto.setUserId(200);
        return ResponseEntity.created(null)
                .body(new CMRespDto<>(userDto.getUserId() + "사용자 추가 성공!", userDto));
    }

}
