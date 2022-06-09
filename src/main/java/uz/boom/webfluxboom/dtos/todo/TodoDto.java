package uz.boom.webfluxboom.dtos.todo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TodoDto {
    private int id;
    private String name;
    private String description;
    private LocalDateTime createdAt;
    private boolean completed;
    private LocalDateTime dueDate;
    private int columnId;
}
