package codingon_kdt.spring_boot_default.controller._01_thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class personController {
    @GetMapping("people")
    public String getPerson(Model model){
        List<Person> p = new ArrayList<>();
        p.add(new Person("kim", 10));
        p.add(new Person("lee", 20));
        p.add(new Person("hong", 30));
        p.add(new Person("park", 40));
        p.add(new Person("shin", 50));
        model.addAttribute("list",p);

        return "_01_thymeleaf/people";
    }

    class Person{
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
