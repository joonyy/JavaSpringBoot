package codingon_kdt.spring_boot_default.controller._02_restapi;

import codingon_kdt.spring_boot_default.vo.Pr2VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class Pr2Controller {
    List<Pr2VO> users = new ArrayList<>();
    Pr2VO currentuser = new Pr2VO();
    @GetMapping("/Pr2")
    public String getPr2(){return "_02_restapi/Pr2";}
    @PostMapping("/Pr2/register")
    @ResponseBody
    public String Register(@RequestBody Pr2VO pr2VO){
        for (Pr2VO user : users) {
            if(Objects.equals(user.getName(), pr2VO.getName())) return "이미 있는 아이디입니다.";
        }
        users.add(pr2VO);
        System.out.println("[POST] users = "+users);
        return "회원가입이 완료되었습니다, "+ pr2VO.getName() +"님!";
    }

    @PostMapping("/Pr2/login")
    @ResponseBody
    public boolean Login(@RequestBody Pr2VO pr2VO){
        for (Pr2VO user : users) {
            if(user.equals(pr2VO)) {
                currentuser = pr2VO;
                System.out.println("currentuser = "+currentuser);
                return true;
            }
        }
        return false;
    }
    @PutMapping("/Pr2/update")
    @ResponseBody
    public String Update(@RequestBody Pr2VO pr2VO){
        users.remove(currentuser);
        users.add(pr2VO);
        currentuser = pr2VO;
        System.out.println("[PUT] users = " + users);
        return "회원 정보가 변경되었습니다.";
    }

    @DeleteMapping("/Pr2/delete")
    @ResponseBody
    public String Delete(@RequestBody Pr2VO pr2VO){
        for (Pr2VO user : users) {
            if(user.equals(pr2VO)) {
                users.remove(pr2VO);
            }
        }
        System.out.println("[DELETE] users = "+users);
        return "회원 정보가 삭제되었습니다.";
    }
}
