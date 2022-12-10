package com.example.MakeAnything.domain.auth.controller;

import com.example.MakeAnything.domain.auth.model.CustomUserDetails;
import com.example.MakeAnything.domain.auth.service.dto.*;
import com.example.MakeAnything.domain.auth.service.noSecurity.*;
import com.example.MakeAnything.domain.common.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceFinder authServiceFinder;

    private final JwtService jwtService;

    private final LocalAuthService localAuthService;

    private final RefreshTokenService refreshTokenService;

    @PostMapping("/auth/login/local")
    public ApiResponse<LoginResponse> loginLocal(@RequestBody LoginLocalRequest request) {

        return ApiResponse.success(localAuthService.login(request));
    }

    @PostMapping("/auth/signup/local")
    public ApiResponse<LoginResponse> signUpLocal(@RequestBody SignUpLocalRequest request) {

        return ApiResponse.success(localAuthService.signUp(request));
    }

    @PostMapping("/auth/login/social")
    public ApiResponse<LoginResponse> loginSocial(@RequestBody LoginSocialRequest request) {

        SocialAuthService socialAuthService = authServiceFinder.getAuthService(request.getSocialType());

        return ApiResponse.success(socialAuthService.login(request));
    }

    @PostMapping("/auth/signup/social")
    public ApiResponse<LoginResponse> signUpSocial(@RequestBody SignUpSocialRequest request) {

        SocialAuthService socialAuthService = authServiceFinder.getAuthService(request.getSocialType());

        return ApiResponse.success(socialAuthService.signUp(request));
    }

    @PostMapping("/refresh/token")
    public ApiResponse<LoginResponse> refreshAccessToken(@RequestBody RefreshTokenRequest request) {
        return ApiResponse.success(refreshTokenService.refreshAccessToken(request));
    }

    @PostMapping("/auth/logout")
    public ApiResponse<Object> logout() {
        Long userId = jwtService.getUserId();

        refreshTokenService.logout(userId);

        return ApiResponse.success(null);
    }

    @PostMapping("/auth/find-email")
    public ApiResponse<FindEmailResponse> findEmailByPhoneNumber(@RequestBody FindEmailRequest request) {

        return ApiResponse.success(localAuthService.findEmailByPhoneNumber(request));
    }

    @PatchMapping("/auth/update-pw")
    public ApiResponse<UpdatePWResponse> updatePWByEmail(@RequestBody UpdatePWRequest request) {

        return ApiResponse.success(localAuthService.updatePWByEmail(request));
    }

    @GetMapping("auth/me")
    public ApiResponse<Object> log(@AuthenticationPrincipal CustomUserDetails user) {
        
        return ApiResponse.success(user);
    }

}
