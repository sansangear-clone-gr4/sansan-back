package com.clone.sansansgear.service;



import com.clone.sansansgear.dto.*;
import com.clone.sansansgear.entity.Post;
import com.clone.sansansgear.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
    public ResponseDto uploadPost(PostRequestDto postRequestDto) throws IOException {
        String imageUrl= null;

        if(!postRequestDto.getFile().isEmpty()){
            imageUrl = fileProcessService.uploadFile(postRequestDto.getFile());
        }
        Post post = postRepository.saveAndFlush(new Post(postRequestDto,  imageUrl));
        return  new ResponseDto("제품 등록 성공", 200);
    }
    //메인페이지상품조회
    public PostListResponseDto getPosts() {
        PostListResponseDto postListResponseDto = new PostListResponseDto();
        List<Post> postList = postRepository.findAllByOrderByCreatedAtDesc();
        for(Post post : postList){
            postListResponseDto.addPostList(new PostResponseDto(post));
        }
        return postListResponseDto;
    }
   @Transactional(readOnly = true)
    public ResponseDto deletePost(String fileName){
        fileProcessService.deleteFile(fileName);
        return  new ResponseDto("상품삭제완료", 200);
   }

    @Transactional
    public ResponseEntity<?> getPost(Long id) {
        if(!postRepository.existsById(id)){
            return ResponseEntity.ok(new ResponseDto("존재하지 않는 상품입니다.", HttpStatus.BAD_REQUEST.value()));
        }
        Post post = postRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(new DetailedPostResponseDto(post));
    }
}
