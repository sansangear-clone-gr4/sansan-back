package com.clone.sansansgear.dto;

import com.clone.sansansgear.entity.Bucket;

public class BucketResponseDto {
    private Long id;
    private Long postId;
    private String title;
    private String imageFile;
    private Long productNum;
    private Long price;

    public BucketResponseDto(Bucket bucket) {
        this.id = bucket.getId();
        this.postId = bucket.getPost().getId();
        this.title = bucket.getPost().getTitle();
        this.imageFile = bucket.getPost().getUrl();
        this.productNum = bucket.getProductNum();
        this.price = bucket.getPost().getPrice();
    }
}
