package codingon_kdt.spring_boot_default.vo;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RegisterVO {
    List<RegisterVO> users = new ArrayList<>();
    private String name;
    private String gender;
    private int year;
    private int month;
    private int day;
    private String hobby;

    @Override
    public String toString() {
        return "RegisterVO{" +
                "name='" + name + '\'' +
                '}';
    }
}
