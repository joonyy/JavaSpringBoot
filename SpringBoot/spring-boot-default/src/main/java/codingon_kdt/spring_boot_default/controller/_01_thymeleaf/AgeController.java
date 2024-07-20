package codingon_kdt.spring_boot_default.controller._01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgeController {
    @GetMapping("age")
    public String getAge(Model model) {
        int age = 14;
        model.addAttribute("isYoung", true);
        model.addAttribute("age",age);
        return "_01_thymeleaf/age";
    }
}
