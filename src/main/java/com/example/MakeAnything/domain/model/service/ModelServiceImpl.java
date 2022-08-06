package com.example.MakeAnything.domain.model.service;

import com.example.MakeAnything.domain.model.model.Model;
import com.example.MakeAnything.domain.model.repository.ModelRepository;
import com.example.MakeAnything.domain.model.service.dto.CreateModelRequest;
import com.example.MakeAnything.domain.model.service.dto.CreateModelResponse;
import com.example.MakeAnything.domain.model.service.dto.GetAllModelsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements ModelService{

    private final ModelRepository modelRepository;

    @Override
    public List<GetAllModelsResponse> getAllModels(){
        return null;
    }

    @Override
    public CreateModelResponse createModel() {
        return null;
    }

    // 모델 생성
    @Override
    @Transactional
    public Long save(CreateModelRequest modelRequest) {
        return modelRepository.save(modelRequest.toEntity()).getId();
    }
}
