package uz.boom.webfluxboom.dtos.column;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.boom.webfluxboom.dtos.todo.TodoDto;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnDto {
    private int id;
    private String name;
    private LocalDateTime createdAt;
    private int projectId;
    private List<TodoDto> todos;
}
