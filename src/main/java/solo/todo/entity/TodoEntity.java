package solo.todo.entity;


import lombok.*;
import solo.todo.dto.TodoDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@Table(name = "todos")
public class TodoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titles;

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false)
    private boolean complete;

    public TodoDto todoDto(){
        return TodoDto.builder()
                .id(id)
                .titles(titles)
                .dateTime(dateTime)
                .complete(complete)
                .build();
    }
}
