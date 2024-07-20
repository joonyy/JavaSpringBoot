package codingon.spring_boot_mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ViewController {

    //GET / 요청 시 /users로 보내자!
    @GetMapping("/")
    public String redirectToUsers(){return "redirect:/users";}

    //GET / users 요청 시 userlist.html 반환
    @GetMapping("/users")
    public String listUsers(){ return "userList";}

    @GetMapping("/users/new")
    //GET / users/new 요청 시 Form 템플릿 반환
    public String newUserForm(){ return "userForm";}

    @GetMapping("/users/{id}/edit")
    public String editUserForm(){
        return "userForm";
    }
}
