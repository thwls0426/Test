package com.example.demo.user;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor //final 여부 확인후 final을 매핑시켜줌
@Service
public class UserService { // 얘가 repository에서 정의한걸 구현하는거같네? 얘가 imple임!

    private final UserRepository userRepository;


    public String findbyEmail(String email) {
        User user = userRepository.findByEmail(email); //메서드 쓸땐 By!!! 구분잘하기

        if(user == null){
            return "없는 사용자 입니다.";

        }
        return "존재하는 사용자 입니다."; //리턴이 있다면 리턴이 있는 마지막으로 실행된 위치
    }
}
