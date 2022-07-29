package com.example.MakeAnything.domain.auth.repository;

import com.example.MakeAnything.domain.auth.model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
}
