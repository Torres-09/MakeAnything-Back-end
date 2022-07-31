package com.example.MakeAnything.domain.model.controller;

import com.example.MakeAnything.domain.common.ApiResponse;
import com.example.MakeAnything.domain.model.service.ModelService;
import com.example.MakeAnything.domain.model.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/models")
public class ModelController {

    private final ModelService modelService;

    // 전체 모델 조회
    @GetMapping("")
    public ApiResponse<List<GetAllModelsResponse>> getAllModels(){
        return ApiResponse.success(modelService.getAllModels());
    }

    // 모델 ( 게시물 ) 생성
    @ResponseBody
    @PostMapping("")
    public ApiResponse<CreateModelResponse> createModel(@RequestBody CreateModelRequest createModelRequest) {
        return null;
    }

    // 모델을 카테고리로 조회
    
    // 모델을 태그로 조회 ( 검색 )
    
    // 모델 이름 조회 ( 검색 )
    
    // 인기 모델 상위 조회

    // 모델 상세 정보 조회


    // 모델 수정
    @ResponseBody
    @PatchMapping("/{modelId}")
    public ApiResponse<UpdateModelResponse> updateModel(@PathVariable ("modelId") Long modelId, @RequestBody UpdateModelRequest updateModelReqeust) {
        return null;
    }

    // 모델 삭제
    @DeleteMapping("/{modelId}")
    public ApiResponse<DeleteModelResponse> deleteModel(@PathVariable ("modelId") Long modelId) {
        return null;
    }
}
