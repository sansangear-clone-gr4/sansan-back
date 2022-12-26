package com.clone.sansansgear.controller;

import com.clone.sansansgear.security.UserDetailsImpl;
import com.clone.sansansgear.service.BucketService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bucket")
public class BucketController {

    private final BucketService bucketService;

    // 장바구니 확인
    @GetMapping()
    public ResponseEntity<?> getBucket(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return bucketService.getBucket(userDetails.getUserId() ) ;
    }

    // 장바구니 담기
    @PostMapping("/{postId}")
    public ResponseEntity<?> putInBucket(@PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {

    }

    // 장바구니 수량 변경
    @PutMapping("/{bucketId}")
    public ResponseEntity<?> updateBucket(@PathVariable Long bucketId, @AuthenticationPrincipal UserDetailsImpl userDetails) {

    }

    // 장바구니 물품등록 삭제
    @DeleteMapping("/{bucketId}/{postId}")
    public ResponseEntity<?> deleteBucket(@PathVariable Long bucketId, @PathVariable Long postId, @AuthenticationPrincipal UserDetailsImpl userDetails) {

    }




}
