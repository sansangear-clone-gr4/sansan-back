package com.clone.sansansgear.dto;

import com.clone.sansansgear.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostResponseDto {
    private Long postId;
    private String title;
    private String imageUrl;
    private Long price;

    public PostResponseDto(Post post){
        this.postId = post.getId();
        this.title = post.getTitle();
        this.imageUrl = post.getImageUrl();
        this.price = post.getPrice();
    }

}
