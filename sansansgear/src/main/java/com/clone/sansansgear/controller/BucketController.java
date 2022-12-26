package com.clone.sansansgear.controller;

import com.clone.sansansgear.dto.BucketRequestDto;
import com.clone.sansansgear.security.UserDetailsImpl;
import com.clone.sansansgear.service.BucketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/bucket")
public class BucketController {

    private final BucketService bucketService;

    // 장바구니 확인
    @GetMapping()
    public ResponseEntity<?> getBucket(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return bucketService.getBucket(userDetails.getUser()) ;
    }

    // 장바구니 담기
    @PostMapping("/{postId}")
    public ResponseEntity<?> putInBucket(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody BucketRequestDto bucketRequestDto) {
        return bucketService.putInBucket(postId, bucketRequestDto, userDetails.getUser());
    }

    // 장바구니 수량 변경
    @PutMapping("/{bucketId}")
    public ResponseEntity<?> updateBucket(@PathVariable Long bucketId, @RequestBody BucketRequestDto bucketRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return bucketService.updateBucket(bucketId, bucketRequestDto, userDetails.getUser());
    }

    // 장바구니 물품등록 삭제
    @DeleteMapping("/{bucketId}")
    public ResponseEntity<?> deleteBucket(@PathVariable Long bucketId, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return bucketService.deleteBucket(bucketId, userDetails.getUser());
    }
}
