package com.clone.sansansgear.controller;

import com.clone.sansansgear.dto.ResponseDto;
import com.clone.sansansgear.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    //상품등록
    @PostMapping("/posts")
    public String uploadPost(@RequestPart(name = "file") MultipartFile file)throws IOException {
        System.out.println("test" + file);
        return postService.uploadPost(file);
    }

}
