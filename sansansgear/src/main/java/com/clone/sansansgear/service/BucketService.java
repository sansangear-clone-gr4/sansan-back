package com.clone.sansansgear.service;

import com.clone.sansansgear.dto.BucketListResponseDto;
import com.clone.sansansgear.entity.Bucket;
import com.clone.sansansgear.entity.Post;
import com.clone.sansansgear.entity.User;
import com.clone.sansansgear.repository.BucketRepository;
import com.clone.sansansgear.repository.PostRepository;
import com.clone.sansansgear.repository.UserRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BucketService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final BucketRepository bucketRepository;

    private final Post post;

    @Transactional
    public ResponseEntity<?> getBucket(User user) {
        Optional<BucketListResponseDto> bucket = bucketRepository.findByUserIdAndPostId(user, post);

        return bucket;
    }

}
