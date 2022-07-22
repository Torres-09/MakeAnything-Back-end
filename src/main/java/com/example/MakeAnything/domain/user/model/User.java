package com.example.MakeAnything.domain.user.model;

import com.example.MakeAnything.domain.common.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String socialId;

    private String userName;

    private String email;

    private String nickName;

    private String password;

    private String phoneNumber;

    private String address;
}
