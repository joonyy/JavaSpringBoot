package codingon_kdt.spring_boot_default.dto;

import lombok.Getter;
import lombok.Setter;

@Getter // Getter 메서드 생성
@Setter // Setter 메서드 생성
public class UserDTO {
    private String name;
    private int age;
}

//UserDTO
//    - 요청시 전달된 값을 사용할 객체
