package codingon_kdt.spring_boot_security.controller;

import codingon_kdt.spring_boot_security.domain.UserEntity;
import codingon_kdt.spring_boot_security.dto.ResponseDTO;
import codingon_kdt.spring_boot_security.dto.UserDTO;
import codingon_kdt.spring_boot_security.security.TokenProvider;
import codingon_kdt.spring_boot_security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    // [after] jwt token 적용한 후
    @Autowired
    private TokenProvider tokenProvider;

    // [after] 패스워드 암호화 적용한 후
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            // 요청으로 받은 dto 를 userEntity 로 변환
            UserEntity user = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .username(userDTO.getUsername())
                    //.password(userDTO.getPassword())
                    .password(passwordEncoder.encode(userDTO.getPassword())) // 암호화된 비번으로 user 객체 생성
                    .build();

            // 서비스 계층을 이용해서 레포지토리에 저장
            UserEntity registeredUser = userService.create(user);

            // 저장된 사용자 정보로 UserDTO 를 생성해서 응답 본문에 담아 리턴
            UserDTO responseUserDTO = UserDTO.builder()
                    .email(registeredUser.getEmail())
                    .id(registeredUser.getId())
                    .username(registeredUser.getUsername())
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        } catch (Exception e) {
            // 사용자 정보는 항상 하나이므로 성공 데이터에 대해 리스트로 만들어야하는 ResponseDTO 를 사용하지 않고 그냥 userDTO 를 반환
            // 예외 상황에서는 error 메세지를 보여주기 위해 ResponseDTO 를 사용함
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();

            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO) {
        // UserService 계층을 통해 이메일과 비밀번호로 사용자를 조회
        UserEntity user
                = userService.getByCredentials(userDTO.getEmail(), userDTO.getPassword(), passwordEncoder);

        if (user != null) {
            // [before]
            //final UserDTO responseUserDTO = UserDTO.builder()
            //        .email(user.getEmail())
            //        .id(user.getId())
            //        .build();

            // [after] jwt token 적용한 후
            final String token = tokenProvider.create(user);
            final UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .id(user.getId())
                    .token(token) // jwt 토큰 추가
                    .build();

            return ResponseEntity.ok().body(responseUserDTO);

        } else {
            ResponseDTO responseDTO = ResponseDTO.builder()
                    .error("Login failed")
                    .build();

            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
