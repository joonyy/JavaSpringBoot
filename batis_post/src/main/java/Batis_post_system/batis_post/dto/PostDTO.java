package Batis_post_system.batis_post.dto;

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
}
