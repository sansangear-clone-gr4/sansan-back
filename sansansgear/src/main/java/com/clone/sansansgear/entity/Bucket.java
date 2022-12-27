package com.clone.sansansgear.entity;

import com.clone.sansansgear.dto.BucketRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@NoArgsConstructor
@Entity
@Getter
public class Bucket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productNum;

    @Column(nullable = false)
    private Long size;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public Bucket(Long postId, BucketRequestDto bucketRequestDto, User user) {
        this.productNum = bucketRequestDto.getProductNum();
        this.size = bucketRequestDto.getSize();
        this.user = user;
    }

    public void updateBucket(BucketRequestDto bucketRequestDto){
        this.productNum = bucketRequestDto.getProductNum();
        this.size = bucketRequestDto.getSize();
    }
}
