package com.example.MakeAnything.domain.user.service;

import com.example.MakeAnything.domain.user.service.dto.BuyModelsResponse;
import com.example.MakeAnything.domain.user.service.dto.SellModelsResponse;
import com.example.MakeAnything.domain.user.service.dto.WishModelsResponse;
import com.example.MakeAnything.domain.wishlist.repository.WishlistRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final WishlistRepository wishlistRepository;

    @Override
    public List<SellModelsResponse> getSellModels(Long userId) {
        return null;
    }

    @Override
    public List<BuyModelsResponse> getBuyModels(Long userId) {
        return null;
    }


    @Override
    public List<WishModelsResponse> getWishModels(Long userId) {
        return wishlistRepository.findAllByUserId(userId).stream()
                .map(wishlist -> WishModelsResponse.of(wishlist.getModel(), wishlist.getUser(), 0L))
                .collect(Collectors.toList());
    }
}
