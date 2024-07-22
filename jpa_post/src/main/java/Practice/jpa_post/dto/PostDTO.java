package Practice.jpa_post.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
    private int id;
    private String title;
    private String content;
    private String writer;
}
