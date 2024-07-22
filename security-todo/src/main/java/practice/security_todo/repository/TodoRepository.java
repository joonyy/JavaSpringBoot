package practice.security_todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.security_todo.domain.TodoEntity;

import java.util.List;


public interface TodoRepository extends JpaRepository<TodoEntity, Long> {
    List<TodoEntity> findByUserId(String userId);
}
