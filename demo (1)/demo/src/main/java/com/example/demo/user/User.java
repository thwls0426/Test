package com.example.demo.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter

// ** 생성자 만들어줌. 롬복 사용시 이거랑 같이 사용.
//** 현재 생성자 생성옵션이 protected로 설정
@NoArgsConstructor(access = AccessLevel.PROTECTED) //access = 접근 제어 수준을 PROTECTED 로 설정
@Entity // entity - 이런 테이블을 만들겠다 하는 의미와 같음. user면 user라는 테이블 작성하겠다는 뜻 테이블이면 PK가 있어야함 잊지마
//** 제약사항
//** 1. @Entity 어노테이션이 붙어있는 클래스는 기본생성자를 갖고 있어야함 >> NoArgsConstructor로 생성됨
//      1-1.  'public' or 'protected' 의 접근수준을 가져야함.

//** 2. @Entity 어노테이션이 붙어있는 클래스는 상속을 받거나, 다른 Entity를 상속받을 수 있다.

//** 3. @Entity 클래스의 필드(값, 변수들)는 관계형 맵핑을 위해서 다른 어노테이션을 추가할 수 있다.
//      - @Colume, @Id, @OneToMany, @ManyToOne etc

// Entity, Table 는 JPA에서 알아서 설정함 , 이거 태그임. 이걸보고 JPA가 저 Table, Entity 를 만들어준단거임 ㅋㅋ
// 이거 쓰고싶으면 bulid에 jpa추가해야함

@Table(name = "user")
//** table 이름을 'user' 로 설정한다.
public class User {

    @Id //pk만들어야하니까. **해당 필드를 PK로 설정한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //** PK 자동설정
    private int id;

    //** length = 45 : DB에서의 길이를 45로 설정
    // null값을 허용하지 않겠다는 뜻. 비워두게 두지 않겠다.
    //** nullable = false : 이 column 을 null로 설정할 수 없다.
    //** unique = true : 이 컬럼의 값을 유일한 값으로 설정한다.
    //**                - 이 값은 중복될 수 없음
    @Column(length = 45, nullable = false) //이름 길이를 45로 만들고 빈칸 안된다
    private String userName;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    //** 빌더 패턴을 쉽게 구현할 수 있도록 해준다.
    //** 주로 인자가 많거나, 인자를 선택적으로 지정해야 하는경우 사용됨.
    @Builder
    public User(int id, String userName, String email, String password) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
