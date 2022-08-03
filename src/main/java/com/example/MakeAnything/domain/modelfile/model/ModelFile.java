package com.example.MakeAnything.domain.modelfile.model;

import com.example.MakeAnything.domain.model.model.Model;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class ModelFile {
    @Id
    @GeneratedValue
    @Column(name = "modelFileId")
    private Long id;


    private String modelFileUrl;

    @OneToOne
    @JoinColumn(name = "modelId")
    private Model model;

    @Builder(access = AccessLevel.PRIVATE)
    public ModelFile(String modelFileUrl, Model model) {
        this.modelFileUrl = modelFileUrl;
        this.model = model;
    }
}