package com.clone.sansansgear.service;

import com.clone.sansansgear.dto.*;
import com.clone.sansansgear.entity.Post;
import com.clone.sansansgear.entity.User;
import com.clone.sansansgear.entity.UserRoleEnum;
import com.clone.sansansgear.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final FileProcessService fileProcessService;

    //제품등록
    @Transactional
    public ResponseDto uploadPost(PostRequestDto postRequestDto, User user) throws IOException {
        if (user.getRole() == UserRoleEnum.ADMIN) {
            String imageUrl = null;

            if (!postRequestDto.getFile().isEmpty()) {
                imageUrl = fileProcessService.uploadFile(postRequestDto.getFile());
            }
            Post post = postRepository.saveAndFlush(new Post(postRequestDto, imageUrl));
            return new ResponseDto("제품 등록 성공", 200);
        }
        return new ResponseDto("관리자만 상품등록을 할 수 있습니다.", 400);

    }

    //메인페이지상품조회
    @Transactional(readOnly = true)
    public PostListResponseDto getPosts() {
        PostListResponseDto postListResponseDto = new PostListResponseDto();
        List<Post> postList = postRepository.findAllByOrderByCreatedAtDesc();
        for (Post post : postList) {
            postListResponseDto.addPostList(new PostResponseDto(post));
        }
        return postListResponseDto;
    }


    @Transactional(readOnly = true)
    public ResponseEntity<?> getPost(Long id) {
        if (!postRepository.existsById(id)) {
            return ResponseEntity.ok(new ResponseDto("존재하지 않는 상품입니다.", HttpStatus.BAD_REQUEST.value()));
        }
        Post post = postRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new DetailedPostResponseDto(post));
    }

    @Transactional
    public ResponseEntity<?> updatePost(Long id, PostRequestDto postRequestDto,User user) {
        if (user.getRole() == UserRoleEnum.ADMIN) {
            if (!postRepository.existsById(id)) {
                return ResponseEntity.ok(new ResponseDto("존재하지 않는 상품입니다.", HttpStatus.BAD_REQUEST.value()));
            }
            Post post = postRepository.findById(id).orElseThrow();
            String imageUrl = null;
            if (!postRequestDto.getFile().isEmpty()) {
                String fileName = post.getImageUrl().split(".com/")[1];
                fileProcessService.deleteFile(fileName);
                imageUrl = fileProcessService.uploadFile(postRequestDto.getFile());
            }
            post.updatePost(postRequestDto, imageUrl);
            return ResponseEntity.ok(new PostResponseDto(post));
        }
        return new ResponseDto("관리자만 상품등록을 할 수 있습니다.", 400);
    }

    @Transactional
    public ResponseDto deletePost(Long id) {
        if (!postRepository.existsById(id)){
            return new ResponseDto("존재하지 않는 상품입니다.",HttpStatus.BAD_REQUEST.value());
        }else{
           Post post = postRepository.findById(id).orElseThrow();
           if(post.getImageUrl() != null){
               String fileName = post.getImageUrl().split(".com/")[1];
               fileProcessService.deleteFile(fileName);
           }
           postRepository.delete(post);
            return new ResponseDto("상품삭제완료", 200);
        }

    }



    public CateResponseDto showCate(String category) {
        CateResponseDto cateResponseDto = new CateResponseDto();
        List <Post> cateList = postRepository.findByCategoryOrderByCreatedAtDesc(category);
        for(Post post : cateList){
            cateResponseDto.addList(new PostResponseDto(post));
        }
        return cateResponseDto;
    }
}
