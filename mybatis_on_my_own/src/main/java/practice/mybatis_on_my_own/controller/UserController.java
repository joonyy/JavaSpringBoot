package practice.mybatis_on_my_own.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.mybatis_on_my_own.domain.User;
import practice.mybatis_on_my_own.dto.UserDTO;
import practice.mybatis_on_my_own.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> listUsers(){ return userService.getUsers();}

    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        userService.createUser(userDTO);
        return userDTO;
    }
    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Long id){
        return userService.getUserById(id);
    }
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO){
        userDTO.setId(id);
        userService.updateUser(userDTO);
        return userDTO;
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}
