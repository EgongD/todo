package solo.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import solo.todo.entity.TodoEntity;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoDto {
    private Long id;
    private String titles;

    private LocalDateTime dateTime;

    private boolean complete;


    public TodoEntity todoEntity() {
        return TodoEntity.builder()
                .id(id)
                .titles(titles)
                .dateTime(dateTime)
                .complete(complete)
                .build();
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }

    public Boolean getComplete() {
        return complete;
    }
}