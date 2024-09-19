package com.sisd.controller.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sisd.dto.student.StudentRegistrationRequestDto;
import com.sisd.service.student.RegistrationService;

@RestController
@RequestMapping("/student")
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestBody StudentRegistrationRequestDto dto){
        return registrationService.register(dto);
    }
}
