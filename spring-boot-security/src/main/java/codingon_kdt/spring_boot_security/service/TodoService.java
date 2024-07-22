package codingon_kdt.spring_boot_security.service;

import codingon_kdt.spring_boot_security.domain.TodoEntity;
import codingon_kdt.spring_boot_security.dto.TodoDTO;
import codingon_kdt.spring_boot_security.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
//Simple logging Facid for Java
// - 로그 라이브러리.
// - 용도에 따라 info, debug, warn, error로 나누어 로깅.
// - 로깅을 하고싶은 클래스에 해당 어노테이션을 작성하면 된다!
public class TodoService {
    @Autowired
    private TodoRepository repository;

    //create Todo
    public List<TodoEntity> create(final TodoEntity entity){
        //final => 엔티티 값이 내부에서 변경되지 않도록 함.
        validate(entity);
        repository.save(entity);
        log.info("Entity Id : {} is saved", entity.getId());
        return repository.findByUserId(entity.getUserId()); // 해당 유저의 전체 투두 리턴.
    }

    //read Todo
    public List<TodoEntity> retrieve(final String userId){
        return repository.findByUserId(userId); // 해당 유저의 전체 투두 리턴.
    }


    private void validate(final TodoEntity entity){
        if(entity==null){
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null");
        }
        if(entity.getUserId()==null){
            log.warn("Unknown user");
            throw new RuntimeException("Unknown user");
        }
    }
}
