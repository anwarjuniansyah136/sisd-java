package com.sisd.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisd.dto.auth.LoginRequestDto;
import com.sisd.dto.auth.LoginResponseDto;
import com.sisd.service.auth.LoginService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    
    public LoginResponseDto response(@RequestBody LoginRequestDto loginRequestDto){
        return loginService.login(loginRequestDto);
    }
}
