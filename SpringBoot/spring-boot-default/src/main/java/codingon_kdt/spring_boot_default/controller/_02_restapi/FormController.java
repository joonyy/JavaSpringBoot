package codingon_kdt.spring_boot_default.controller._02_restapi;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {
    @GetMapping("/form")
    public String getForm(Model model){
        return "_02_restapi/form";
    }

    @PostMapping("/form")
    @ResponseBody
    public String postForm(@RequestParam(value = "name")String name,
                           @RequestParam(value = "gender")String gender,
                           @RequestParam(value = "year")int year,
                           @RequestParam(value = "month")int month,
                           @RequestParam(value = "day")int day,
                           @RequestParam(value = "hobby")String hobby,
                           Model model
                           ){
        return "이름: " + name + "<br/>"
                + "성별: " + gender + "<br/>"
                + "생년월일: " + year + "-" + month + "-" + day + "<br/>"
                + "관심사: " + hobby;
    }
}
