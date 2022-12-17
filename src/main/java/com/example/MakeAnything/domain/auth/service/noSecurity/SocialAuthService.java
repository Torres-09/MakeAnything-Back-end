package com.example.MakeAnything.domain.auth.service.noSecurity;

import com.example.MakeAnything.domain.auth.service.dto.*;

public interface SocialAuthService {

    LoginResponse login(LoginSocialRequest request);

    LoginResponse signUp(SignUpSocialRequest request);
}
