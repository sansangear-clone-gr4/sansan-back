package com.clone.sansansgear.dto;

import java.util.ArrayList;
import java.util.List;

public class CateResponseDto {
    List<PostResponseDto> list = new ArrayList<>();
    public void addList(PostResponseDto postResponseDto){
        list.add(postResponseDto);
    }
}
