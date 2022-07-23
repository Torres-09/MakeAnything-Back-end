package com.example.MakeAnything.domain.user.service;

import com.example.MakeAnything.domain.user.model.User;
import com.example.MakeAnything.domain.user.service.dto.ModelResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<ModelResponse> getSellModels(Long userId);

    public List<ModelResponse> getBuyModels(Long userId);

    public List<ModelResponse> getWishModels(Long userId);
}
