package com.clone.sansansgear.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
public class PostRequestDto {
    private String title;
    private String content;
    //private String imageUrl;
    private MultipartFile file;
    private Long price;
    private String category;

//    public PostRequestDto(String title, String content, Long price, String category, String imageUrl){
//        this.title = title;
//        this.content = content;
//        this.price = price;
//        this.category = category;
//        this.imageUrl = imageUrl;
//    }
}
