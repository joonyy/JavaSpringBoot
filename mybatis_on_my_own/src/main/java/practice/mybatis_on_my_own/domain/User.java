package practice.mybatis_on_my_own.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private long id;
    private String username;
    private String email;
    private String createdAt;
}
