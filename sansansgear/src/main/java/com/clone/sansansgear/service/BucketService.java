package com.clone.sansansgear.service;

import com.clone.sansansgear.dto.BucketListResponseDto;
import com.clone.sansansgear.dto.BucketRequestDto;
import com.clone.sansansgear.dto.BucketResponseDto;
import com.clone.sansansgear.dto.ResponseDto;
import com.clone.sansansgear.entity.Bucket;
import com.clone.sansansgear.entity.Post;
import com.clone.sansansgear.entity.User;
import com.clone.sansansgear.repository.BucketRepository;
import com.clone.sansansgear.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BucketService {
    private final PostRepository postRepository;
    private final BucketRepository bucketRepository;

    // 장바구니 가져오기
    @Transactional
    public ResponseEntity<?> getBucket(User user) {
        BucketListResponseDto bucketListResponseDto = new BucketListResponseDto();
        List<Bucket> bucketList = bucketRepository.findByUser(user);
//        log.info("{}",bucketList);

        for(Bucket bucket : bucketList) {
            bucketListResponseDto.addBucketList(new BucketResponseDto(bucket));
        }

        return ResponseEntity.ok(bucketListResponseDto);
    }

    // 장바구니 넣기
    @Transactional
    public ResponseEntity<?> putInBucket(Long postId, BucketRequestDto bucketRequestDto, User user) {
        Post post = postRepository.findById(postId).orElseThrow();
        Bucket bucket = new Bucket(post, bucketRequestDto, user);

        bucketRepository.saveAndFlush(bucket);
        return ResponseEntity.ok(new ResponseDto("장바구니 담기 완료", HttpStatus.OK.value()));
    }

    // 장바구니 수량 변경
    @Transactional
    public ResponseEntity<?> updateBucket(Long bucketId, BucketRequestDto bucketRequestDto, User user) {
        Bucket bucket = bucketRepository.findByIdAndUser(bucketId, user);
        bucket.updateBucket(bucketRequestDto);

        return ResponseEntity.ok(new ResponseDto("장바구니 수량, 사이즈 변경 완료", HttpStatus.OK.value()));
    }

    // 장바구니 지우기
    @Transactional
    public ResponseEntity<?> deleteBucket(Long bucketId, User user) {
        Bucket bucket = bucketRepository.findByIdAndUser(bucketId, user);

        bucketRepository.delete(bucket);

        return ResponseEntity.ok(new ResponseDto("삭제 완료", HttpStatus.OK.value()));
    }

}
