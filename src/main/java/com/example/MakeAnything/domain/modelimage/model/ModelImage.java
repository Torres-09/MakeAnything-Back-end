package com.example.MakeAnything.domain.modelimage.model;

import com.example.MakeAnything.domain.model.model.Model;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelImage {
    @Id
    @GeneratedValue
    @Column(name = "modelImageId")
    private Long id;

    private String modelImageUrl;

    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;

    @Builder(access = AccessLevel.PRIVATE)
    public ModelImage(String modelImageUrl, Model model) {
        this.modelImageUrl = modelImageUrl;
        this.model = model;
    }
}