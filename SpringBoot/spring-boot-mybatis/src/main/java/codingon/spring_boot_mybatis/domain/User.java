package codingon.spring_boot_mybatis.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private long id;
    private String username;
    private String email;
    private String createdAt;
}

// domain.user
// - 데이터베이스 엔티티를 표현하는 도메인으로, database의 테이블과 직접적으로 매핑해줌.
// - 실제 데이터 역할을 하므로 "테이블 구조"와 동일해야 함.