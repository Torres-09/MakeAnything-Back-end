package com.example.MakeAnything.domain.model.service.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GetAllModelsResponse {
    private Long modelId;
    private String modelName;
    private Long price;
    private String content;
    private Long downloadCount;
    private Long userId;
    private String userName;

    public GetAllModelsResponse(Long modelId, String modelName, Long price, String content, Long downloadCount, Long userId, String userName) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.price = price;
        this.content = content;
        this.downloadCount = downloadCount;
        this.userId = userId;
        this.userName = userName;
    }
}
