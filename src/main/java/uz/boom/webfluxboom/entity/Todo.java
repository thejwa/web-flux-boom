package uz.boom.webfluxboom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id
    private int id;
    private String name;
    private String description;
    @Column("created_at")
    private LocalDateTime createdAt;
    @Column("is_completed")
    private boolean completed;
    private LocalDateTime dueDate;
    @Column("column_id")
    private int columnId;
}
