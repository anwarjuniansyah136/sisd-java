package com.sisd.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sisd.dto.auth.LoginRequestDto;
import com.sisd.dto.auth.LoginResponseDto;
import com.sisd.entity.Users;
import com.sisd.repository.UsersRepository;
import com.sisd.util.JwtUtil;

public class LoginServiceImpl implements LoginService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public LoginResponseDto login(LoginRequestDto dto) {
        Users user = usersRepository
                .findByUserName(dto.getUserName());
                // .orElse(null);
        if (user != null) {
            boolean isMatch = passwordEncoder.matches(dto.getPassword(),
                    user.getPassword());
            if (isMatch) {
                LoginResponseDto loginResponseDto = new LoginResponseDto();
                loginResponseDto.setUsername(user.getUserName());
                loginResponseDto.setRole(user.getRoles().getRoleName());
                loginResponseDto.setToken(jwtUtil.generateToken(user));
                return loginResponseDto;
            }
        }
        throw new BadCredentialsException("Invalid username or password");
    }

}
