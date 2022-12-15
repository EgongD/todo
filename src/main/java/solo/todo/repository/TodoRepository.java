package solo.todo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import solo.todo.entity.TodoEntity;

public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

}
