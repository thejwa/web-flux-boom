package uz.boom.webfluxboom.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.boom.webfluxboom.dtos.project.ProjectDto;
import uz.boom.webfluxboom.entity.Project;
import uz.boom.webfluxboom.service.ProjectService;

@RestController
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService service;
    
    @PostMapping
    public Mono<Project> create(@RequestBody Mono<Project> projectMono) {
        return projectMono.flatMap(service::create);
    }
    
    @GetMapping
    public Flux<Project> getAll() {
        return service.getAll();
    }
    
    @GetMapping("/{id}")
    public Mono<ProjectDto> get(@PathVariable Integer id) {
        return service.get(id);
    }
    
    
}
