package com.clone.sansansgear.controller;

import com.clone.sansansgear.dto.CompleteResponseDto;
import com.clone.sansansgear.dto.LoginRequestDto;
import com.clone.sansansgear.dto.SignupRequestDto;
import com.clone.sansansgear.repository.UserRepository;
import com.clone.sansansgear.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @PostMapping ("/signup")
    public CompleteResponseDto signup(@RequestBody SignupRequestDto signupRequestDto) {
        return userService.signup(signupRequestDto);
    }


    @PostMapping("/login")
    public CompleteResponseDto login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {

        return userService.login(loginRequestDto, response);
    }

    // id 중복체크
    @GetMapping("/idCheck/{userId}")
    public CompleteResponseDto idCheck(@PathVariable String userId) {
        return userService.idCheck(userId);
    }



//    @PostMapping("/signup")
//    public CompleteResponseDto signup(@RequestBody @Valid SignupRequestDto signupRequestDto){
//        return userService.signup(signupRequestDto);
//    }
//
//    @PostMapping("/login")
//    public String login(@AuthenticationPrincipal UserDetails userDetails) {
//        System.out.println("*********************************************************");
//        System.out.println("UserController.login");
//        System.out.println("userDetails.getUserId() = " + userDetails.getUserId());
//        System.out.println("*********************************************************");
//
//        return "redirect:/api/user/login-page";
//    }

    //접근 불가 페이지 + testController 로직 추가 필요
//    @PostMapping("/forbidden")
//    public ModelAndView forbidden() {
//        return new ModelAndView("forbidden");
//    }

}
