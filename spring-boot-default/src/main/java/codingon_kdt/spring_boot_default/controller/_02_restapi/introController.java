package codingon_kdt.spring_boot_default.controller._02_restapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class introController {
    @GetMapping("introduce/{name}")
    @ResponseBody
    public String Intro(@PathVariable(value = "name") String name){
        return "내 이름은 "+ name;
    }

    @GetMapping("introduce2")
    @ResponseBody
    public String Intro(@RequestParam(value = "name")String name,
                        @RequestParam(value = "age")int age){
        return "내 이름은 " + name +System.lineSeparator()+
                "내 나이는 "+ age;
    }
}
