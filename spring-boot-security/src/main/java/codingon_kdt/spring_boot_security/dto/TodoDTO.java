package codingon_kdt.spring_boot_security.dto;

import codingon_kdt.spring_boot_security.domain.TodoEntity;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
    private Long id;
    private String title;
    private boolean done;

    //entity => dto
    public TodoDTO(final TodoEntity entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    //dto => entity
    public static final TodoEntity todoEntity(final TodoDTO dto){
        return TodoEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }
}

//참고 : @Data 어노테이션
// - @Getter, @Setter, @RequiredConstructor, @ToString, @EqualsAndHashCode
//@RequiredConstructor => 필수 생성자를 만들어줌.