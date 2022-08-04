package com.example.MakeAnything.domain.modelfile.service;

import com.example.MakeAnything.domain.modelfile.repository.ModelFileRepository;
import com.example.MakeAnything.domain.modelfile.service.dto.ModelFileDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModelFileServiceImpl {

    private final ModelFileRepository modelFileRepository;

    public Long save(ModelFileDto modelFileDto) {
        return modelFileRepository.save((modelFileDto.toEntity())).getId();
    }
}
