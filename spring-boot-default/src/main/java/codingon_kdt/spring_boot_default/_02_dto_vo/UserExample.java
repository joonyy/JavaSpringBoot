package codingon_kdt.spring_boot_default._02_dto_vo;

import codingon_kdt.spring_boot_default._02_dto_vo.dto.UserDTO;

public class UserExample {
    public static void main(String[] args) {
        //userDTO 객체를 생성(기본 생성자)
        UserDTO u1 = new UserDTO();
        System.out.println("u1 = "+u1);
        u1.setId(1L);
        u1.setUsername("JohnDoe");
        u1.setEmail("joony@example.com");
        u1.setAge(20);

        //UserDTO 정보출력
        System.out.println("u1 = "+ u1);

        //UserDTO 객체 생성 (모든 필드를 포함한 생성자 사용)
        UserDTO u2 = new UserDTO(2L,"JaneSmith", "janesmith@example.com",25);
        System.out.println("u2 = "+ u2);

        //getter를 통한 특정 정보 접근
        System.out.println("u2.getUsername() = "+u2.getUsername());
        System.out.println("u2.getEmail() = " + u2.getEmail());

        //setter를 통한 정보수정
        u2.setAge(26);
        System.out.println("u2 = "+u2);
    }
}
