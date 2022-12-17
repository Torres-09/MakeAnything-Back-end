package com.example.MakeAnything.domain.auth.model;

import java.util.Map;

public class NaverOAuth2UserInfo extends OAuth2UserInfo {

    protected Map<String, Object> attributesResponse;

    public NaverOAuth2UserInfo(Map<String, Object> attributes) {
        super(attributes);
        this.attributesResponse = (Map<String, Object>) attributes.get("response");
    }

    @Override
    public String getId() {
        return (String) attributesResponse.get("id");
    }
    @Override
    public String getName() {
        return (String) attributesResponse.get("name");
    }
    @Override
    public String getNickName() {
        return (String) attributesResponse.get("nickname");
    }
    @Override
    public String getEmail() {
        return (String) attributesResponse.get("email");
    }
    @Override
    public String getPhoneNumber() {
        return (String) attributesResponse.get("mobile");
    }
    @Override
    public String getImageUrl() {
        return (String) attributesResponse.get("profile_image");
    }
}
