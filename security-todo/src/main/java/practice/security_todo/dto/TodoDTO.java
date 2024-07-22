package practice.security_todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice.security_todo.domain.TodoEntity;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private Long id;
    private String title;
    private boolean done;

    public TodoDTO(final TodoEntity entity){
        this.id= entity.getId();
        this.title= entity.getTitle();
        this.done= entity.isDone();
    }

    public static final TodoEntity todoEntity(final TodoDTO dto){
        return TodoEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }
    public static final TodoEntity todoEntityWithId(Long id, final TodoDTO dto){
        return TodoEntity.builder()
                .id(id)
                .title(dto.getTitle())
                .done(dto.isDone())
                .build();
    }
}
