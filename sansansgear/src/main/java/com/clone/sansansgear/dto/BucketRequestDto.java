package com.clone.sansansgear.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BucketRequestDto {
    private Long productNum;
    private Long size;

    public BucketRequestDto(Long productNum, Long size) {
        this.productNum = productNum;
        this.size = size;
    }
}
