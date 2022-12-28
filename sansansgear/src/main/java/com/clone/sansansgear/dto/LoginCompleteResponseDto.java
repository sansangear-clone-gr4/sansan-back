package com.clone.sansansgear.dto;

import com.clone.sansansgear.entity.UserRoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LoginCompleteResponseDto {

    private String msg;

    private int statusCode;

//    private UserRoleEnum userRole;

    boolean role;

    public static LoginCompleteResponseDto success(String msg, boolean role){
        return new LoginCompleteResponseDto(msg, HttpStatus.OK.value(), role);

    }


}
