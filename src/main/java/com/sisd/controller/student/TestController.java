package com.sisd.controller.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("")
    @SecurityRequirement(name = "Bearer Authentication")
    public String test() {
        return "success";
    }
}
