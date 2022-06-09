package uz.boom.webfluxboom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.boom.webfluxboom.dtos.project.ProjectDto;
import uz.boom.webfluxboom.entity.Project;
import uz.boom.webfluxboom.mapper.ProjectMapper;
import uz.boom.webfluxboom.repo.ProjectRepository;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository repository;
    private final ColumnService columnService;
    private final ProjectMapper mapper;
    
    public Mono<Project> create(Project project) {
        return repository.save(project);
        
        
    }
    
    public Flux<Project> getAll() {
        return repository.findAll();
    }
    
    
    public Mono<ProjectDto> get(Integer id) {
//        repository.findById(id)
//                .map(mapper::toDto)
        return null;
        
    }
}
