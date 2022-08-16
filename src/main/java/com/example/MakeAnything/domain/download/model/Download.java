package com.example.MakeAnything.domain.download.model;

import com.example.MakeAnything.domain.order.model.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Download {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean downloadStatus;

    @Builder
    public Download(Boolean downloadStatus) {
        this.downloadStatus = downloadStatus;
    }

    public void downloadDone() {
        this.downloadStatus = true;
    }
}