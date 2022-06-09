package uz.boom.webfluxboom.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.boom.webfluxboom.dtos.project.ProjectDto;
import uz.boom.webfluxboom.entity.Project;

@Component
@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectDto toDto(Project project);
}
