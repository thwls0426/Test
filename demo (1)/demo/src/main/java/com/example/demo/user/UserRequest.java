package com.example.demo.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRequest {

    @Setter
    @Getter
    public static class LoginDTO{ //user login에 대한 dto

        @NotEmpty //데이터가 비어있을 수 없는 상태. 컬럼 하나하나 각각 설정!
        @Pattern(regexp = "\\S+", message = "이메일에는 공백을 포함할 수 없습니다.")
        private String email;

        @NotEmpty(message = "이메일은 비어있을 수 없습니다.")
        @Size(min = 8, max = 20, message = "8자 이상 20자 이내로 작성 가능합니다.")
        //만약 패스워드가 숫자가 안맞으면(7개 송신) 위의 메세지를 제이슨으로 송신. 아직 메세지 만드는거 안만듦!
        @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)\\S{8,20}$", message = "비밀번호는 영문 대소문자와 숫자를 포함하여 8자 이상 20자 이내로 작성해야 합니다.")
            /*
            (?=.*[a-zA-Z]): 최소한 하나의 영문 대소문자가 포함되어야 함
(?=.*\\d): 최소한 하나의 숫자가 포함되어야 함
.{8,20}: 총 길이가 8에서 20 사이여야 함
* */
        private String password;


        public User toEntity(){
            return User.builder()
                    .email(email)
                    .password(password)
                    .build();
        }
    }

}
