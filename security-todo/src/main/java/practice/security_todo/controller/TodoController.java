package practice.security_todo.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import practice.security_todo.domain.TodoEntity;
import practice.security_todo.dto.ResponseDTO;
import practice.security_todo.dto.TodoDTO;
import practice.security_todo.service.TodoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto){
        try{
            String temporaryUserId = "temporary-user";
            TodoEntity entity = TodoDTO.todoEntity(dto);
            entity.setId(null);
            entity.setUserId(temporaryUserId);
            List<TodoEntity> entities = service.create(entity);
            List<TodoDTO> dtos = new ArrayList<>();
            for(TodoEntity todoEntity: entities){
                TodoDTO todoDTO = new TodoDTO(todoEntity);
                dtos.add(todoDTO);
            }
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);

        }catch(Exception e){
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<?> retrieveTodoList(){
        String temporaryUserId = "temporary-user";
        List<TodoEntity> entities = service.retrieve(temporaryUserId);
        List<TodoDTO> dtos = new ArrayList<>();
        for(TodoEntity todoEntity : entities){
            TodoDTO todoDTO = new TodoDTO(todoEntity);
            dtos.add(todoDTO);
        }

        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody TodoDTO todoDTO){
        String temporaryUserId = "temporary-user";
        TodoEntity todoEntity =  TodoDTO.todoEntityWithId(id, todoDTO);
        todoEntity.setUserId(temporaryUserId);
        List <TodoEntity> entities = service.updateTodo(id, todoEntity);
        List<TodoDTO> dtos = new ArrayList<>();
        for(TodoEntity tEntity: entities){
            TodoDTO tDTO = new TodoDTO(tEntity);
            dtos.add(tDTO);
        }
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){ service.deleteTodo(id); }
}
