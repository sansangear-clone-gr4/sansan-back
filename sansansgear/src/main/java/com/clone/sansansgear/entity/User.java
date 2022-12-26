package com.clone.sansansgear.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long kakaoId; //(숫자일껍니다)

    @Column
    private String userId; //(email들어가야함)

    @Column
    private String password; //UUID로 랜덤하게 겹치지않게 넣어줌

    @Column
    private String username; // 닉네임 기입

    @Column
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;  //권한 무조건 USER

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bucket> bucketList = new ArrayList<>();

    public User(String username, Long kakaoId, String password,String email, UserRoleEnum role) {
        this.username = username;
        this.kakaoId = kakaoId;
        this.password = password;
        userId = email;
        this.role = role;
    }

    public User kakaoIdUpdate(Long kakaoId) {
        this.kakaoId = kakaoId;
        return this;
    }


    //    @Column
//    private int phoneNumber;
//
//    @Column
//    private String email;


}

