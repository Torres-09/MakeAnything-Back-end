package com.example.MakeAnything.domain.auth.service.dto;

import lombok.*;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class LoginResponse {

    private String token;

    private Long userId;

    public static LoginResponse of(String token, Long userId) {
        return new LoginResponse(token, userId);
    }
}
