package practice.security_todo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.security_todo.domain.TodoEntity;
import practice.security_todo.dto.TodoDTO;
import practice.security_todo.repository.TodoRepository;

import java.util.List;

@Service
@Slf4j
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    //create Todo
    public List<TodoEntity> create(final TodoEntity todoEntity){
        validate(todoEntity);
        todoRepository.save(todoEntity);
        log.info("Entity Id : {} is saved", todoEntity.getId());
        return todoRepository.findByUserId(todoEntity.getUserId());
    }

    //read Todo
    public List<TodoEntity> retrieve(final String userId){
        return todoRepository.findByUserId(userId);
    }

    //update Todo
    public List<TodoEntity> updateTodo(Long id, final TodoEntity todoEntity){
        validate(todoEntity);
        todoRepository.save(todoEntity);
        log.info("Entity id {} : updated as {}", todoEntity.getId(),todoEntity.getTitle());
        return todoRepository.findByUserId(todoEntity.getUserId());
    }

    //delete Todo
    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    private void validate(final TodoEntity todoEntity){
        if(todoEntity == null){
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null");
        }
        if(todoEntity.getUserId() == null){
            log.warn("Unknown user");
            throw new RuntimeException("Unknown user");
        }
    }
}
