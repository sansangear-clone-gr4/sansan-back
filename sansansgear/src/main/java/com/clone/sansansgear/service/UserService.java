package com.clone.sansansgear.service;

import com.clone.sansansgear.dto.CompleteResponseDto;
import com.clone.sansansgear.dto.LoginCompleteResponseDto;
import com.clone.sansansgear.dto.LoginRequestDto;
import com.clone.sansansgear.dto.SignupRequestDto;
import com.clone.sansansgear.entity.User;
import com.clone.sansansgear.entity.UserRoleEnum;
import com.clone.sansansgear.errorcode.UserErrorCode;
import com.clone.sansansgear.exception.RestApiException;
import com.clone.sansansgear.jwt.JwtUtil;
import com.clone.sansansgear.repository.PostRepository;
import com.clone.sansansgear.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    static String msg;
    static int statusCode = 400;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;

    private static final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";


//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil
//            , PostRepository postRepository) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//        this.jwtUtil = jwtUtil;
//        this.postRepository = postRepository;
//    }


    @Transactional
    public CompleteResponseDto signup(SignupRequestDto signupRequestDto) {
        String userId = signupRequestDto.getUserId();
        String password = passwordEncoder.encode(signupRequestDto.getPassword());
        String username = signupRequestDto.getUserName();

        // 회원 중복 확인
        Optional<User> found = userRepository.findByUserId(userId);
        if (found.isPresent()) {
            throw new RestApiException(UserErrorCode.OVERLAPPED_USERID);
        }

        UserRoleEnum role = UserRoleEnum.USER;
        if (signupRequestDto.isAdmin()) {
            if (!signupRequestDto.getAdminToken().equals(ADMIN_TOKEN)) {
                throw new RestApiException(UserErrorCode.WRONG_ADMINTOKEN);
            }
            role = UserRoleEnum.ADMIN;
        }

        User user = new User(userId, password, username, role);
        userRepository.save(user);
        return CompleteResponseDto.success("회원가입 성공");
    }


    @Transactional (readOnly = true)
    public LoginCompleteResponseDto login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        String userId = loginRequestDto.getUserId();
        String password = loginRequestDto.getPassword();
        boolean role = false;

        // 사용자 확인
        User user = userRepository.findByUserId(userId).orElseThrow(
                () -> new RestApiException(UserErrorCode.NO_USER)
        );

        // 비밀번호 확인
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RestApiException(UserErrorCode.WRONG_PASSWORD);
        }

        // 토큰 부여
        response.addHeader(JwtUtil.AUTHORIZATION_HEADER, jwtUtil.createToken(user.getUserId(), user.getRole())); // getRole();

        if (!(user.getRole() == UserRoleEnum.USER)) {
            role = true;
        }

        return LoginCompleteResponseDto.success("로그인 성공", role);
    }

    // id 중복체크
    @Transactional
    public CompleteResponseDto idCheck(String userId) {
        Optional<User> found = userRepository.findByUserId(userId);
        if (found.isPresent()) {
            throw new RestApiException(UserErrorCode.OVERLAPPED_USERID);
        }
        return CompleteResponseDto.success("사용할 수 있는 아이디입니다.");
    }   //수정해야함  중복은아닌데  정규식에 걸릴수있음
}
