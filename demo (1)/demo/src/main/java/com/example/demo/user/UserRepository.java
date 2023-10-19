package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;


//** JpaRepository<User, Integer> : CRUD를 정의하지 않아도 사용할 수 있음<>는 기본값형태
//** 메서드 추가 정의도 가능.

public interface UserRepository extends JpaRepository<User, Integer>
{
    //    } @Entity 로 불러와서 객체지향으로 사용가능 -- User. << 이걸로 다 불러올 수 있음
    User findByEmail(String email);

}
