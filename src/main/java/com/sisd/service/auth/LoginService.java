package com.sisd.service.auth;

import com.sisd.dto.auth.LoginRequestDto;
import com.sisd.dto.auth.LoginResponseDto;

public interface LoginService {
    LoginResponseDto login(LoginRequestDto dto);
}
