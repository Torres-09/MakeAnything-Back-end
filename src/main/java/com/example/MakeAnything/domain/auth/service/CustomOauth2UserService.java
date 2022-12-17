package com.example.MakeAnything.domain.auth.service;

import com.example.MakeAnything.domain.auth.model.*;
import com.example.MakeAnything.domain.common.exception.BaseException;
import com.example.MakeAnything.domain.common.exception.type.ErrorCode;
import com.example.MakeAnything.domain.user.model.User;
import com.example.MakeAnything.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomOauth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);

        return process(userRequest, oAuth2User);
    }

    private OAuth2User process(OAuth2UserRequest oAuth2UserRequest, OAuth2User oAuth2User) {

        AuthProvider authProvider = AuthProvider.valueOf(
                oAuth2UserRequest.getClientRegistration().getRegistrationId().toUpperCase());
        
        OAuth2UserInfo userInfo = OAuth2UserInfoFactory.getOAuth2UserInfo(authProvider, oAuth2User.getAttributes());

        if (userInfo.getEmail().isEmpty()) {
            throw new BaseException(ErrorCode.INVALID);
        }

        Optional<User> userOptional = userRepository.findByEmail(userInfo.getEmail());

        User user;

        if (userOptional.isPresent()) {
            user = userOptional.get();

            if (authProvider != user.getAuthProvider()) {
                throw new BaseException(ErrorCode.INVALID);
            }
        } else {
            user = createUser(userInfo, authProvider);
        }

        return CustomUserDetails.create(user, oAuth2User.getAttributes());
    }

    private User createUser(OAuth2UserInfo userInfo, AuthProvider authProvider) {

        User user = User.builder()
                .userName(userInfo.getName())
                .email(userInfo.getEmail())
                .nickName(userInfo.getNickName())
                .phoneNumber(userInfo.getPhoneNumber())
                .role(UserRole.USER)
                .authProvider(authProvider)
                .build();

        return userRepository.save(user);
    }
}
