package com.clone.sansansgear.entity;

import com.clone.sansansgear.dto.PostRequestDto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String imageUrl;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Bucket> bucketList = new ArrayList<>();



    public Post(PostRequestDto postRequestDto,  String imageUrl) {
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContent();
        this.price = postRequestDto.getPrice();
        this.category = postRequestDto.getCategory();
        this.imageUrl = imageUrl;

    }

   public void updatePost(PostRequestDto requestDto,String imageUrl){
       this.title = requestDto.getTitle();
       this.content = requestDto.getContent();
       this.price = requestDto.getPrice();
       this.category = requestDto.getCategory();
       this.imageUrl = imageUrl;
   }
}
