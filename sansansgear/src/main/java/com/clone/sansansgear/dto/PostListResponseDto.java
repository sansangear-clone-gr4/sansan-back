package com.clone.sansansgear.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class PostListResponseDto {
    List<PostResponseDto> postList = new ArrayList<>();

    public void addPostList(PostResponseDto postResponseDto){
        postList.add(postResponseDto);
    }
}
