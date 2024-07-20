package codingon_kdt.spring_boot_jpa.service;

import codingon_kdt.spring_boot_jpa.domain.User;
import codingon_kdt.spring_boot_jpa.dto.UserDTO;
import codingon_kdt.spring_boot_jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll(); // 모든 User 리스트 가져옴
        List<UserDTO> userDTOs = new ArrayList<>(); // 새로운 DTO 객체 리스트 생성

        for(User user: users) {
            // for 루프를 이용해 각 User 객체를 UserDTO 로 변환하고 리스트에 추가
            UserDTO userDTO = convertToDto(user); // domain to dto
            userDTOs.add(userDTO); // dto 를 리스트에 추가
        }

        return userDTOs;
    }
    //특정 ID의 사용자 수정
    public UserDTO getUserById(Long id){
        //findById()가 사용자를 찾으면 그 User객체 반환
        //사용자를 찾지 못한다면 null 반환
        User user = userRepository.findById(id).orElse(null);
        if(user==null){
            throw new RuntimeException("User not found");
        }
        return convertToDto(user);
    }
    //새 사용자 생성
    public void createUser(UserDTO userDTO){
        User user = convertToEntity(userDTO);
        userRepository.save(user);
    }

    //사용자 정ㅇ보 업데이트
    public void updateUser(Long id, UserDTO userDto){
        //업데이트 시 userDTO는 username, email만 가지고 있음,
        User user = convertToEntityWithId(id, userDto);
        userRepository.save(user);
    }

    //특정 ID의 사용자 삭제
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
    /////////////////////////////////////////////////
    // 1. 사용자 이름으로 n행 조회
    public List<UserDTO> getUserByUsername(String username){
        List<User> users = userRepository.findByUsername(username);
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User user : users){
            userDTOs.add(convertToDto(user));
        }
        return userDTOs;
    }
    // 2. 검색어를 보냈을 때 사용자 이름/이메일에 특정 문자열이 포함된 모든 사용자 n명 찾기
    public List<UserDTO> searchUsers(String keyword){
        List<User> users = userRepository.findByUsernameContainingOrEmailContaining(keyword);
        List<UserDTO> userDTOs = new ArrayList<>();
        for(User user : users){
            userDTOs.add(convertToDto(user));
        }
        return userDTOs;
    }
    //3. 이름이 존재하는지 조회
    public boolean isUsernameExists(String username){
        return userRepository.existsByUsername(username);
    }
    /////////////////////////////////////////
    //domain => dto
    private UserDTO convertToDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .no((int) (user.getId() + 100))
                .build();
    }
    //dto => domain
    private User convertToEntity(UserDTO dto){
        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build();
    }
    //id필드 제외하고 만들어주는 builder
    private User convertToEntityWithId(Long id,UserDTO dto){
        return User.builder()
                .id(id)
                .username(dto.getUsername())
                .email(dto.getEmail())
                .build();
    }
}
