package com.example.MakeAnything.domain.user.controller;

import com.example.MakeAnything.domain.common.ApiResponse;
import com.example.MakeAnything.domain.user.service.UserService;
import com.example.MakeAnything.domain.user.service.dto.ModelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/users/{userId}/sell")
    public ApiResponse<List<ModelResponse>> getSellModels(@PathVariable Long userId) {
        return ApiResponse.success(userService.getWishModels(userId));
    }

    @GetMapping("/users/{userId}/buy")
    public ApiResponse<List<ModelResponse>> getBuyModels(@PathVariable Long userId) {
        return ApiResponse.success(userService.getWishModels(userId));
    }

    @GetMapping("/users/{userId}/wish")
    public ApiResponse<List<ModelResponse>> getWishModels(@PathVariable Long userId) {
        return ApiResponse.success(userService.getWishModels(userId));
    }

}
