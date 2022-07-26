package com.example.MakeAnything.domain.model.controller;

import com.example.MakeAnything.domain.common.ApiResponse;
import com.example.MakeAnything.domain.model.service.ModelService;
import com.example.MakeAnything.domain.model.service.dto.GetAllModelsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @GetMapping("/models")
    public ApiResponse<List<GetAllModelsResponse>> getAllModels(){
        return ApiResponse.success(modelService.getAllModels());
    }
}
