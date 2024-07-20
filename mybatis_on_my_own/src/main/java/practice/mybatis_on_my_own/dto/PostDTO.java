package practice.mybatis_on_my_own.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
    private boolean reported;
}
