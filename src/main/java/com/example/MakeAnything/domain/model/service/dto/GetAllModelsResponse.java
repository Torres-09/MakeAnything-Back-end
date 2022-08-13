package com.example.MakeAnything.domain.model.service.dto;

import com.example.MakeAnything.domain.model.model.Model;
import com.example.MakeAnything.domain.modelimage.model.ModelImage;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAllModelsResponse {
    private Long modelId;
    private String modelName;
    private Long price;
    private Long downloadCount;
    private String userNickName;
    private ModelImage modelImage;


    public static GetAllModelsResponse of(Model model) {
        return new GetAllModelsResponse(model.getId(), model.getModelName(), model.getPrice(), model.getDownloadCount()
                , model.getUser().getNickName(), model.getModelImages().get(0));
    }
}
