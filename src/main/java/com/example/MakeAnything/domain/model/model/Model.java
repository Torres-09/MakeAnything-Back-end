package com.example.MakeAnything.domain.model.model;

import com.example.MakeAnything.domain.common.BaseTimeEntity;
import com.example.MakeAnything.domain.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Model extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long user_id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long category_id;

    private String modelName;

    private Long price;

    private String content;
}
