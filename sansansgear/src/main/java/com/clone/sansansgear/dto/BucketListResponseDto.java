package com.clone.sansansgear.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class BucketListResponseDto {
    private List<BucketResponseDto> bucketList = new ArrayList<>();

    public void addBucketList(BucketResponseDto bucketResponseDto){
        bucketList.add(bucketResponseDto);
    }
}
