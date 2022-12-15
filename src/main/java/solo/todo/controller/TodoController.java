package solo.todo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import solo.todo.dto.TodoDto;
import solo.todo.service.TodoServiceImpl;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("todos")
@Validated
@Slf4j
public class TodoController {
    private final TodoServiceImpl todoService;

    public TodoController(TodoServiceImpl todoService){
        this.todoService = todoService;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTodos() throws Exception {
        List<TodoDto> dtoList = todoService.getTodos();
        return ResponseEntity.ok(dtoList);
    }

    //등록
    @PostMapping
    public ResponseEntity<String> postTodo(@RequestBody TodoDto todoDto) throws Exception {
        todoDto.setDateTime(LocalDateTime.now());
        todoDto.setComplete(false);
        todoService.postTodo(todoDto);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    //수정
    @PutMapping("/{id}")
    public ResponseEntity<String> putTodo(@PathVariable("id") Long id) throws Exception {
        TodoDto todoDto = todoService.findTodoById(id);
        Boolean Completed = todoDto.getComplete();
        todoDto.setComplete(!Completed);
        todoService.postTodo(todoDto);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    //삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) throws Exception {
        todoService.deleteTodo(id);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    //단일 조회
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTodo(@PathVariable("id") Long id) throws Exception {
        TodoDto todoDto = todoService.findTodoById(id);
        return ResponseEntity.ok(todoDto);
    }
}