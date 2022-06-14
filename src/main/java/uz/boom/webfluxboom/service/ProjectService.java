package uz.boom.webfluxboom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
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
    
    
    public Mono<ProjectDto> get(int id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Not Found")))
                .map(mapper::toDto)
                .zipWith(columnService.getByProjectId(id)
                        .collectList())
                .doOnNext(tuple2 -> tuple2.getT1().setColumns(tuple2.getT2()))
                .map(Tuple2::getT1);


//        return repository.findById(id)
//                .switchIfEmpty(Mono.error(() -> {
//                    throw new RuntimeException("Project Not Found");
//                }))
//                .map(mapper::toDto)
//                .zipWith(columnService.getByProjectId(id)
//                        .collectList())
//                .doOnNext(tuple2 -> tuple2.getT1().setColumns(tuple2.getT2()))
//                .map(Tuple2::getT1);


//        return columnService.getByProjectId(id)
//                .collectList()
//                .zipWith(repository.findById(id)
//                        .map(mapper::toDto))
//                .doOnNext(tuple2 -> tuple2.getT2().setColumns(tuple2.getT1()))
//                .map(Tuple2::getT2);
        
        
    }
}
