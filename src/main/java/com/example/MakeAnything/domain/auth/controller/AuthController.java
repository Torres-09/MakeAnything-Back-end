package com.example.MakeAnything.domain.auth.controller;

import com.example.MakeAnything.domain.auth.service.AuthServiceFinder;
import com.example.MakeAnything.domain.auth.service.LocalAuthService;
import com.example.MakeAnything.domain.auth.service.dto.LoginLocalRequest;
import com.example.MakeAnything.domain.auth.service.dto.LoginResponse;
import com.example.MakeAnything.domain.auth.service.dto.RefreshTokenRequest;
import com.example.MakeAnything.domain.auth.service.dto.SignUpLocalRequest;
import com.example.MakeAnything.domain.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceFinder authServiceFinder;

    private final LocalAuthService localAuthService;

    @PostMapping("auth/login/local")
    public ApiResponse<LoginResponse> loginLocal(@RequestBody LoginLocalRequest request) {

        return ApiResponse.success(localAuthService.login(request));
    }

    @PostMapping("auth/signup/local")
    public ApiResponse<LoginResponse> signUpLocal(@RequestBody SignUpLocalRequest request) {

        return ApiResponse.success(localAuthService.signUp(request));
    }

    @PostMapping("/refresh/token")
    public ApiResponse<LoginResponse> refreshAccessToken(@RequestBody RefreshTokenRequest request) {
        return ApiResponse.success(localAuthService.refreshAccessToken(request));
    }

}
