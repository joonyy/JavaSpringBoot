package codingon_kdt.spring_boot_default.controller._02_restapi;

import codingon_kdt.spring_boot_default.vo.RegisterVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegisterController {
    List<RegisterVO> users = new ArrayList<>();
    @GetMapping("/submit")
    public String getRegister(Model model){
        System.out.println("[GET]");
        return "_02_restapi/register";
    }

    @PostMapping("/submit")
    @ResponseBody
    public String register(@RequestBody RegisterVO registerVO){
        System.out.println("[POST] : " + users);
        users.add(registerVO);
        return registerVO.getName();
    }
}
