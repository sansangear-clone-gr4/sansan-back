package com.clone.sansansgear.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
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

    @Column(nullable = false, unique = true)
    @Size(min = 4, max= 16, message = "최소 4자 이상, 16자 이하를 입력하셔야 합니다.")
    private String userId;

    @Column(nullable = false)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{10,16}", message = "비밀번호는 10~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
//    @Size(min=10, max=16)
    private String password;


    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bucket> bucketList = new ArrayList<>();

    public User(String userId, String password, String username, UserRoleEnum role){
        this.userId = userId;
        this.password = password;
        this.username = username;
        this.role = role;
    }



    // 영문 대소문자, 숫자, 특수문자 다 포함해줄 것

//    @Column
//    private int phoneNumber;
//
//    @Column
//    private String email;


}
