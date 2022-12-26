package com.clone.sansansgear.dto;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CategoryResponseDto {
    List <PostResponseDto> Outer = new ArrayList<>();
    List <PostResponseDto> Top = new ArrayList<>();
    List <PostResponseDto> Bottom = new ArrayList<>();
    List <PostResponseDto> Accessories = new ArrayList<>();


    public void addOuter(PostResponseDto postResponseDto){
        Outer.add(postResponseDto);
    }
    public void addTop(PostResponseDto postResponseDto){
        Top.add(postResponseDto);
    }
    public void addBottom(PostResponseDto postResponseDto){
        Bottom.add(postResponseDto);
    }
    public void addAccessories(PostResponseDto postResponseDto){
        Accessories.add(postResponseDto);
    }

}
