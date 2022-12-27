package com.clone.sansansgear.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long kakaoId; //(숫자일껍니다)


    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String username;


    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bucket> bucketList = new ArrayList<>();

//    public User(String username, Long kakaoId, String password, String email, UserRoleEnum role) {
//        this.username = username;
//        this.kakaoId = kakaoId;
//        this.password = password;
//        userId = email;
//        this.role = role;
//    }

//    public User kakaoIdUpdate(Long kakaoId) {
//        this.kakaoId = kakaoId;
//        return this;
//    }
                                            //kakaoUserInfo.getNicknmae(), kakaoId, encodedPassword, email, UserRoleEnum.USER


    //    @Column
    public User(String userId, String password, String username, UserRoleEnum role) {
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public User(String nicknmae, Long kakaoId, String encodedPassword, String email, UserRoleEnum role) {
        username = nicknmae;
        this.kakaoId = kakaoId;
        this.password = encodedPassword;
        userId = email;
        this.role = role;
    }

    public User kakaoIdUpdate(Long kakaoId) {
        this.kakaoId = kakaoId;
        return this;
    }
}


    // 영문 대소문자, 숫자, 특수문자 다 포함해줄 것

//    @Column

//    private int phoneNumber;
//
//    @Column
//    private String email;




