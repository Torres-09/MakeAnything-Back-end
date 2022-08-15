package com.example.MakeAnything.domain.download.controller;

import com.example.MakeAnything.domain.auth.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/downloads")
public class downloadController {
    private final JwtService jwtService;
}
