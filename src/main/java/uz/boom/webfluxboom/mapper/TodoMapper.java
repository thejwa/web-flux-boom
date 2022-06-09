package uz.boom.webfluxboom.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.boom.webfluxboom.dtos.todo.TodoDto;
import uz.boom.webfluxboom.entity.Todo;

@Component
@Mapper(componentModel = "spring")
public interface TodoMapper {
    TodoDto toDto(Todo todo);
}
