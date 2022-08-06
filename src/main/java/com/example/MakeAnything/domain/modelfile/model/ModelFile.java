package com.example.MakeAnything.domain.modelfile.model;

import com.example.MakeAnything.domain.model.model.Model;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ModelFile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFileName;

    private String fileFullPath;

    @OneToOne
    @JoinColumn(name = "modelId")
    private Model model;


    @Builder
    public ModelFile(String originalFileName, String fileFullPath,Model model) {
        this.originalFileName = originalFileName;
        this.fileFullPath = fileFullPath;
        this.model = model;
    }
}