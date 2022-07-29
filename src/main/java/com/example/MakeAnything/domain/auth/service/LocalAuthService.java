package com.example.MakeAnything.domain.auth.service;

import com.example.MakeAnything.domain.auth.service.dto.LoginLocalRequest;
import com.example.MakeAnything.domain.auth.service.dto.LoginResponse;
import com.example.MakeAnything.domain.auth.service.dto.SignUpLocalRequest;
import org.springframework.stereotype.Service;

@Service
public interface LocalAuthService {

    LoginResponse login(LoginLocalRequest request);

    LoginResponse signUp(SignUpLocalRequest request);

}
