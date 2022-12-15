package solo.todo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import solo.todo.dto.TodoDto;
import solo.todo.entity.TodoEntity;
import solo.todo.repository.TodoRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService{
    private final TodoRepository todoRepository;

    @Override
    public List<TodoDto> getTodos() throws Exception{
        List<TodoEntity> entityList = todoRepository.findAll();
        List<TodoDto> dtoList = new ArrayList<>();

        for(TodoEntity entity : entityList){
            dtoList.add(entity.todoDto());
        }
        return dtoList;
    }

    @Override
    @Transactional
    public Long postTodo(TodoDto todoDto) throws Exception{
        return todoRepository.save(todoDto.todoEntity()).getId();
    }

    @Override
    @Transactional
    public void deleteTodo(Long id) throws Exception{
        todoRepository.deleteById(id);
    }

    @Override
    public TodoDto findTodoById(Long id) throws Exception{
        return todoRepository.findById(id).orElseThrow().todoDto();
    }
}
