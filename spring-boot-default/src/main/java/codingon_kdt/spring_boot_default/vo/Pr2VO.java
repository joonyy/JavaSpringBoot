package codingon_kdt.spring_boot_default.vo;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Pr2VO {
    private String name;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pr2VO pr2VO = (Pr2VO) o;
        return Objects.equals(name, pr2VO.name) && Objects.equals(password, pr2VO.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }

    @Override
    public String toString() {
        return  "name=" + name +
                ", password=" + password;
    }
}
