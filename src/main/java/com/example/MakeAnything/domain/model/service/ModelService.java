package com.example.MakeAnything.domain.model.service;

import com.example.MakeAnything.domain.model.model.Model;
import com.example.MakeAnything.domain.model.service.dto.CreateModelResponse;
import com.example.MakeAnything.domain.model.service.dto.GetAllModelsResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ModelService {

    List<GetAllModelsResponse> getAllModels();

    CreateModelResponse createModel();

    Long save(Model model);
}
