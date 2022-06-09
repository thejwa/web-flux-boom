package uz.boom.webfluxboom.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.boom.webfluxboom.dtos.column.ColumnDto;
import uz.boom.webfluxboom.entity.Column;

@Component
@Mapper(componentModel = "spring")
public interface ColumnMapper {
    ColumnDto toDto(Column column);
    
}
