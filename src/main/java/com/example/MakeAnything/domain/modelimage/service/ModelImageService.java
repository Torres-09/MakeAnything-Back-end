package com.example.MakeAnything.domain.modelimage.service;

import com.example.MakeAnything.domain.modelimage.service.dto.ModelImageDto;
import org.springframework.stereotype.Service;

@Service
public interface ModelImageService {
    Long save(ModelImageDto modelImageDto);
}
