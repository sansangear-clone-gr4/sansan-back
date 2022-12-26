package com.clone.sansansgear.controller;

import com.clone.sansansgear.jwt.JwtUtil;
import com.clone.sansansgear.service.KakaoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class UserController {
    private KakaoService kakaoService;


    @GetMapping("/kakao/callback")
    public String kakaoLogin(@RequestParam String code, HttpServletResponse response) throws JsonProcessingException {
        // code: 카카오 서버로부터 받은 인가 코드
        String createToken = kakaoService.kakaoLogin(code, response);

        return "redirect:/api/shop";
    }

}
