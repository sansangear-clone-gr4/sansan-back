package com.clone.sansansgear.service;



import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
@RequiredArgsConstructor
public class PostService {
    //private final PostRepository postRepository;
    private final FileProcessService fileProcessService;

    @Transactional
    public String uploadPost(MultipartFile multipartFile) throws IOException {
        String url= null;

        if(!multipartFile.isEmpty()){
            url = fileProcessService.uploadFile(multipartFile);

        }
        return  url;
    }






}
