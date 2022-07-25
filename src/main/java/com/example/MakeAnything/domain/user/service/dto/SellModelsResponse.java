package com.example.MakeAnything.domain.user.service.dto;

import com.example.MakeAnything.domain.model.model.Model;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SellModelsResponse {

    private Long modelId;

    private String modelName;

    private Long userId;

    private String userName;

    private Long downloadCount;

    private Long price;

    private LocalDateTime paidAt;

    private SellModelsResponse(Long modelId, String modelName, Long userId, String userName, Long downloadCount, Long price, LocalDateTime paidAt) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.userId = userId;
        this.userName = userName;
        this.downloadCount = downloadCount;
        this.price = price;
        this.paidAt = paidAt;
    }

    public static SellModelsResponse of(Model model, Long downloadCount) {

        return new SellModelsResponse(model.getId(), model.getModelName(), model.getUser().getId(), model.getUser().getUserName(),
                downloadCount, model.getPrice(), LocalDateTime.now());
    }
}
