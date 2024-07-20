package practice.mybatis_on_my_own.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.mybatis_on_my_own.dto.UserDTO;
import practice.mybatis_on_my_own.domain.User;
import practice.mybatis_on_my_own.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<UserDTO> getUsers(){
        List<User> users = userMapper.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for(User user:users){
            UserDTO userDTO = convertToDto(user);
            userDTOs.add(userDTO);
        }
        return userDTOs;
    }

    public void createUser(UserDTO userDTO){
        User user = convertToEntity(userDTO);
        userMapper.insert(user);
    }

    public void updateUser(UserDTO userDTO){
        User user = convertToEntity(userDTO);
        userMapper.update(user);
    }
    public UserDTO getUserById(Long id){
        User user = userMapper.findById(id);
        return convertToDto(user);
    }

    public void deleteUser(Long id){
        userMapper.delete(id);
    }

    private UserDTO convertToDto(User user){
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setNo((int) (user.getId() + 100));

        return dto;
    }
    private User convertToEntity(UserDTO dto){
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        return user;
    }
}

