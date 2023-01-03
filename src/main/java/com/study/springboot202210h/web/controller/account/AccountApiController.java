package com.study.springboot202210h.web.controller.account;

import com.study.springboot202210h.aop.annotation.ParamsAspect;
import com.study.springboot202210h.aop.annotation.TimerAspect;
import com.study.springboot202210h.aop.annotation.ValidAspect;
import com.study.springboot202210h.service.UserService;
import com.study.springboot202210h.web.dto.CMRespDto;
import com.study.springboot202210h.web.dto.UserDto;
import com.study.springboot202210h.web.dto.UsernameDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    // Simple Log Fasade
//    private static final Logger LOG = LoggerFactory.getLogger(AccountApiController.class);

    @Autowired
    private UserService userService;

    @ParamsAspect
    @TimerAspect
    @ValidAspect
    @GetMapping("/username")
    public ResponseEntity<?> duplicateUsername(@Valid UsernameDto usernameDto, BindingResult bindingResult) {
        userService.duplicateUsername(usernameDto.getUsername());

        return ResponseEntity.ok().body(new CMRespDto<>("가입 가능한 사용자이름", true));
    }

    @ParamsAspect
    @PostMapping("/user")
    public ResponseEntity<?> register(@RequestBody @Valid UserDto userDto, BindingResult bindingResult) {
        return ResponseEntity
                .created(URI.create("/account/login"))
                .body(new CMRespDto<>("회원가입 완료", null));
    }

}