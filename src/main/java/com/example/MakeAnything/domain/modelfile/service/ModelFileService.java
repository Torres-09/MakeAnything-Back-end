package com.example.MakeAnything.domain.modelfile.service;

import com.example.MakeAnything.domain.modelfile.service.dto.ModelFileDto;
import org.springframework.stereotype.Service;

@Service
public interface ModelFileService {
    Long save(ModelFileDto modelFileDto);
}
