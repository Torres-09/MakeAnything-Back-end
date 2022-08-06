package com.example.MakeAnything.domain.model.service.dto;

import com.example.MakeAnything.domain.model.model.Model;
import com.example.MakeAnything.domain.modelfile.model.ModelFile;
import com.example.MakeAnything.domain.modelimage.model.ModelImage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Getter
@NoArgsConstructor
public class CreateModelRequest {

    private String modelName;
    private Long price;
    private String content;
    private MultipartFile modelFile;
    private List<ModelImage> modelImage;
    // category
    // user
    // tag

    @Builder
    public CreateModelRequest(String modelName, Long price, String content, MultipartFile modelFile, List<ModelImage> modelImage) {
        this.modelName = modelName;
        this.price = price;
        this.content = content;
        this.modelFile = modelFile;
        this.modelImage = modelImage;
    }

    public Model toEntity() {
        return Model.builder()
                .modelName(modelName)
                .price(price)
                .content(content)
                .modelFile((ModelFile) modelFile)
                .modelImages(modelImage)
                .build();
    }
}