package com.clone.sansansgear.repository;

import com.clone.sansansgear.entity.Bucket;
import com.clone.sansansgear.entity.Post;
import com.clone.sansansgear.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
    List<Bucket> findByUserIdAndPostId(User user, Post post);
    Bucket findByIdAndUser(Long id, User user);
}
