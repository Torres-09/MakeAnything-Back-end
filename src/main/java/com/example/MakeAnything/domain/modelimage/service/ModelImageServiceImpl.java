package com.example.MakeAnything.domain.modelimage.service;

import com.example.MakeAnything.domain.modelimage.repository.ModelImageRepository;
import com.example.MakeAnything.domain.modelimage.service.dto.ModelImageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelImageServiceImpl {
    private final ModelImageRepository modelImageRepository;

    public Long save(ModelImageDto modelImageDto) {
        return modelImageRepository.save(modelImageDto.toEntity()).getId();
    }
}
