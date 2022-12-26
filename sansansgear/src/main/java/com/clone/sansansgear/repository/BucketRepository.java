package com.clone.sansansgear.repository;

import com.clone.sansansgear.entity.Bucket;
import com.clone.sansansgear.entity.Post;
import com.clone.sansansgear.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
    Optional<Bucket> findByUserIdAndPostId(User user, Post post);
}
