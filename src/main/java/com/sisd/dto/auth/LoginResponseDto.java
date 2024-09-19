package com.sisd.dto.auth;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String username;
    private String role;
    private String token;
}
