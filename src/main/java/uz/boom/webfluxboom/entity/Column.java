package uz.boom.webfluxboom.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.List;

@Table("columns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Column {
    @Id
    private int id;
    private String name;
    @org.springframework.data.relational.core.mapping.Column("created_at")
    private LocalDateTime createdAt;
    @org.springframework.data.relational.core.mapping.Column("project_id")
    private int projectId;
}
