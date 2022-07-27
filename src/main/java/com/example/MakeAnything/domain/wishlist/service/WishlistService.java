package com.example.MakeAnything.domain.wishlist.service;

import com.example.MakeAnything.domain.model.model.Model;
import com.example.MakeAnything.domain.user.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WishlistService {

    void toggleModelWish(Long userId, Long modelId);
}
