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

//package com.clone.sansansgear.controller;
//
//import com.clone.sansansgear.entity.Post;
//import com.clone.sansansgear.security.UserDetailsImpl;
//import org.springframework.data.domain.Page;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
//
////public class BucketController {
//
////  장바구니 인증 부분
////    @GetMapping("/api/bucket/{postId}")
////    public Page<Post> getPostsInFolder(
////            @PathVariable Long bucketId,
////            @RequestParam int price,
////            @RequestParam int productNum,
////            @RequestParam int size,
//////            @RequestParam String sortBy,      ---> 논의 필
//////            @RequestParam int page,           ---> 논의 필
////            @AuthenticationPrincipal UserDetailsImpl userDetails
////
////    ){
////        return bucketService.getPostsInFolder(
////                bucketId,
////                size,
////                price,
////                ProductNum,
//////                sortBy,       --->    논의 필
//////                page,         --->    논의 필
////                userDetails.getUser();
////
////
////        )
////    }
//
//}
