package uz.boom.webfluxboom.dtos.project;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.boom.webfluxboom.dtos.column.ColumnDto;
import uz.boom.webfluxboom.entity.Column;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProjectDto {
    private int id;
    private String name;
    private LocalDateTime createdAt;
    private List<ColumnDto> columns;
}
