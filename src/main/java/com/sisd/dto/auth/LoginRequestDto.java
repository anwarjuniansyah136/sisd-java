package com.sisd.dto.auth;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    private String userName;
    private String password;
}
