package com.clone.sansansgear.controller;

import com.clone.sansansgear.dto.CateResponseDto;
import com.clone.sansansgear.dto.PostListResponseDto;
import com.clone.sansansgear.dto.PostRequestDto;
import com.clone.sansansgear.dto.ResponseDto;
import com.clone.sansansgear.security.UserDetailsImpl;
import com.clone.sansansgear.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    //상품등록
    @PostMapping("/posts")
    public ResponseDto uploadPost(@ModelAttribute PostRequestDto postRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails)throws IOException {
        return postService.uploadPost(postRequestDto, userDetails.getUser());
    }
    //메인페이지상품조회
    @GetMapping("/posts")
    public PostListResponseDto getPosts(){
        return postService.getPosts();
    }
    //제품상세조회
    @GetMapping("/posts/{postId}")
    public ResponseEntity<?> getPost(@PathVariable Long postId){

        return postService.getPost(postId);
    }
    //제품정보수정
    @PutMapping("/posts/{postId}")
    public ResponseEntity<?> updatePost(@PathVariable Long postId, @ModelAttribute PostRequestDto postRequestDto,@AuthenticationPrincipal UserDetailsImpl userDetails){
        return postService.updatePost(postId,postRequestDto,userDetails.getUser());
    }

   //제품페이지삭제
    @DeleteMapping("/posts/{postId}")
    public ResponseDto deletePost(@PathVariable Long postId,@AuthenticationPrincipal UserDetailsImpl userDetails){

        return postService.deletePost(postId,userDetails.getUser());
    }
    //카테고리별조회
    @GetMapping("/posts/category")
    public CateResponseDto showCategory(@RequestParam("category") String category){
        return postService.showCate(category);
    }
}
