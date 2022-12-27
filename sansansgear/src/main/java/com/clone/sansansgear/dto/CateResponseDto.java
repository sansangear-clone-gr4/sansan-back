package com.clone.sansansgear.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CateResponseDto {
    List<PostResponseDto> list = new ArrayList<>();
    public void addList(PostResponseDto postResponseDto){
        list.add(postResponseDto);
    }
}
