package com.clone.sansansgear.repository;

import com.clone.sansansgear.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAllByOrderByCreatedAtDesc();

//    List<Post> findAllByCategoryOrderByCreatedAtDesc();


    List<Post> findAllByOrderByCreatedAtDesc(Pageable pageable);

    boolean existsByIdAndUserId(Long id, String userId);

    void deleteAllByUserId(String userId);


    Optional<Post> findById(Long postId);

    List<Post> findByCategoryOrderByCreatedAtDesc(String category);

}
