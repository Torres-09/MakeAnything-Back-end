package com.example.MakeAnything.domain.model.service;

import com.example.MakeAnything.domain.model.model.Model;
import com.example.MakeAnything.domain.model.repository.ModelRepository;
import com.example.MakeAnything.domain.model.service.dto.CreateModelResponse;
import com.example.MakeAnything.domain.model.service.dto.GetAllModelsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    @Override
    public Long save(Model model) {
        return modelRepository.save(model).getId();
    }
}
