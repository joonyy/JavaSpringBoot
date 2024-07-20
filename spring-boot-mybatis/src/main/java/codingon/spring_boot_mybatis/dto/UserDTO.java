package codingon.spring_boot_mybatis.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 매개변수 없는 기본 생성자
//@AllArgsConstructor // 모든 필드를 매개변수로 받는 생성자를 만들어줌
//@Builder // 빌더 패턴을 사용 가능하도록 해주는 어노테이션
public class UserDTO {
    private long id;
    private String username;
    private String email;
    //domain과 다르게 no 필드가 추가됨.
    //-> 실제 테이블에 존재하진 않지만, 서비스 로직에서 no필드 사용 예정
    private int no;
}

//dto.UserDTO
// - 데이터 전송 계층(dto) 으로 클라이언트와 서버 간의 데이터 교환에 사용.
// - 클라이언트에게 노출하고 싶지 않은 민감한 정보를 User 객체(domain)에 포함시키고, DTO 변환과정에서 제외시킬 수 있다.