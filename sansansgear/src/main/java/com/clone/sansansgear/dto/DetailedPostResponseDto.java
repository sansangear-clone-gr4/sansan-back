package com.clone.sansansgear.dto;

import com.clone.sansansgear.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailedPostResponseDto {
    private Long postId;
    private String title;
    private String content;
    private String imageUrl;
    private Long price;

    public DetailedPostResponseDto(Post post){
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.imageUrl = post.getImageUrl();
        this.price = post.getPrice();
    }
}
