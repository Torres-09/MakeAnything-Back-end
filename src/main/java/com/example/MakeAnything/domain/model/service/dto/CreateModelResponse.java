package com.example.MakeAnything.domain.model.service.dto;

import com.example.MakeAnything.domain.common.exception.model.ErrorDTO;
import com.example.MakeAnything.domain.model.model.Model;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CreateModelResponse {
    private boolean success;
    private Model model;
    private ErrorDTO error;

    @Builder
    public CreateModelResponse(boolean success, Model model, ErrorDTO error) {
        this.success = success;
        this.model = model;
        this.error = error;
    }
}
