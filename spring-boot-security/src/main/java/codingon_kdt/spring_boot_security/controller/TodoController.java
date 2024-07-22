package codingon_kdt.spring_boot_security.controller;

import codingon_kdt.spring_boot_security.dto.ResponseDTO;
import codingon_kdt.spring_boot_security.dto.TodoDTO;
import codingon_kdt.spring_boot_security.domain.TodoEntity;
import codingon_kdt.spring_boot_security.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService service;


    //Response Entity란?
    // - 해당 객체를 이용해 상태코드랑 응답 본문 등을 설정해서 클라이언트에게 "응답"
    // 메서드
    // - ok() : 성공(200 status code)
    // - headers() : 응답 헤더 설정
    // - body() : 응답 본문 설정
    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto){
        try{
        //임시 유저(삭제 예정)
        String temporaryUserId = "temporary-user";

        //1) dto를 entity로 변환
        TodoEntity entity = TodoDTO.todoEntity(dto);

        //2) 생성 당시에는 id는 null로 초기화
        entity.setId(null);

        //3) 임시 사용자 아이디 설정
        entity.setUserId(temporaryUserId);

        //4) 서비스 계층을 이용해서 TodoEntity를 생성한 것.
        List<TodoEntity> entities = service.create(entity);

        //5) return된 엔티티 리스트를 TodoDTO 리스트로 변환.
        List<TodoDTO> dtos = new ArrayList<>();
        for(TodoEntity tEntity : entities){
            TodoDTO tDTO = new TodoDTO(tEntity);
            dtos.add(tDTO);
        }

        //6) 변환된 TodoDTO 리스트를 이용해 ResponseDTO 초기화
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

        //7) ResponseDTO 리턴
        return ResponseEntity.ok().body(response);
        }catch (Exception e){
            // 8) 예외가 있는 경우 dto대신 error에 메시지를 넣어서 리턴
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<?> retrieveTodoList(){
        //임시 유저(삭제 예정)
        String temporaryUserId = "temporary-user";

        //1) 서비스 메서드의 retrieve() 사용해 투두 리스트 가져오기
        List<TodoEntity> entities = service.retrieve(temporaryUserId);

        //2) 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환
        List<TodoDTO> dtos = new ArrayList<>();
        for(TodoEntity tEntity: entities){
            TodoDTO tDTO = new TodoDTO(tEntity);
            dtos.add(tDTO);
        }
        //3) 변환된 TodoDTO 리스트를 이용하여 ResponseDTO를 초기화
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

        //4) ResponseDTO 반환
        return ResponseEntity.ok().body(response);
    }
}