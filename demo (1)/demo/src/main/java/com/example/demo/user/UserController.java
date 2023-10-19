package com.example.demo.user;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


 /* 실제로 이렇게 쓰는게 맞는데 깔끔하게 쓰는거 --> requiredArg~~이거
    public UserController(UserService userService) {
        this.userService = userService;
    }
    생성자를 통해 UserService를 초기화 시켜주는 대신 @RequiredArgsContructor 어노테이션 사용.
    */

@RequiredArgsConstructor //
@RestController
//@Controller
//@Service
//@Repository //컨트롤러 > 서버 > 리퍼지토리
public class UserController {

    //@Autowired // final 안적어도 설정됨. 근데 권장하지 않음 >> final하고 생성자 초기화
    private final UserService userService;


    @PostMapping("/join") // id / password 두개만 있음댐 근데 이걸 user dto 라고 할수잇나?
    //postmapping / getmapping 바꿀수잇당
    public String login(@Valid UserRequest.LoginDTO loginDTO){ // UserRequest~ 뒷부분을 폼이라고 한다.
        //** valid : 제약사항을 검토하는 역할
        //           아직 제약사항이 없음!. 유효성 검사

        /* @valid = 받아온 폼의 데이터 유효성을 검사하는 역할을 수행.
        *   - @Requestbody, @ModelAttribute 와 함께 사용한다.
        *           : 이거 설명 아직 xx
        *   - DTO에서 작성된 @Size, @Pattern, @NotEmpty 등을 검사
        *   - 필드에 'NOT NULL' 조건이 있거나, 'UNIQUE' 조건이 설정되어 있는 경우도 확인
        *   - */


//        if(userService.function(loginDTO.getEmail()) == false){
//            return "존재하지 않는 사용자 이메일 입니다";
//        } 선생님이 그냥 에시로 든 코드임. 참고용으로 사용하기

        String byEmail = userService.findbyEmail(loginDTO.getEmail());

        return byEmail;

    }
}
