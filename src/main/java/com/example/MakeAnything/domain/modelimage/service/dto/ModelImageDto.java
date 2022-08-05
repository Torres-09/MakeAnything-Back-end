package com.example.MakeAnything.domain.modelimage.service.dto;

import com.example.MakeAnything.domain.model.model.Model;
import com.example.MakeAnything.domain.modelimage.model.ModelImage;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ModelImageDto {
    private String originalImageName;
    private String imageFullPath;
    private Model model;

    public ModelImage toEntity() {
        return ModelImage.builder()
                .originalImageName(this.originalImageName)
                .imageFullPath(this.imageFullPath)
                .model(this.model)
                .build();
    }

    @Builder
    public ModelImageDto(String originalImageName, String imageFullPath, Model model) {
        this.originalImageName = originalImageName;
        this.imageFullPath = imageFullPath;
        this.model = model;
    }
}
