package codingon_kdt.spring_boot_security.dto;

import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String token; // jwt 저장
    private String email;
    private String username;
    private String password;
    private Long id;
}
