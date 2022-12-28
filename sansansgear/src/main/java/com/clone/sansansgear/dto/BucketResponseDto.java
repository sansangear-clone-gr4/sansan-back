package com.clone.sansansgear.dto;

import com.clone.sansansgear.entity.Bucket;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BucketResponseDto {
    private Long id;
    private Long postId;
    private String title;
    private String imageFile;
    private Long productNum;
    private Long price;
    private Long size;

    public BucketResponseDto(Bucket bucket) {
        this.id = bucket.getId();
        this.postId = bucket.getPost().getId();
        this.title = bucket.getPost().getTitle();
        this.imageFile = bucket.getPost().getImageUrl();
        this.productNum = bucket.getProductNum();
        this.size = bucket.getSize();
        this.price = bucket.getPost().getPrice();
    }
}
