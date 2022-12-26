package com.clone.sansansgear.dto;

import java.util.ArrayList;
import java.util.List;

public class BucketListResponseDto {
    private List<BucketResponseDto> bucketList = new ArrayList<>();

    public void addBucketList(BucketResponseDto bucketResponseDto){
        bucketList.add(bucketResponseDto);
    }
}
