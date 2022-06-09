package uz.boom.webfluxboom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import uz.boom.webfluxboom.dtos.todo.TodoDto;
import uz.boom.webfluxboom.entity.Todo;
import uz.boom.webfluxboom.mapper.TodoMapper;
import uz.boom.webfluxboom.repo.TodoRepository;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;
    private final TodoMapper mapper;
    
    public Flux<TodoDto> getByColumnId(Integer columnId) {
        return repository.findByColumnId(columnId)
                .flatMap(todo -> Mono.just(todo)
                        .map(mapper::toDto)
                        .subscribeOn(Schedulers.parallel()));
    }
    
    public Flux<Todo> getAll() {
        return repository.findAll();
    }
    
    public Mono<Todo> create(ServerRequest request) {
        return request.bodyToMono(Todo.class)
                .flatMap(repository::save);
        
    }
    
    public Mono<Todo> get(ServerRequest request) {
        return repository.findById(Integer.valueOf(request.pathVariable("id")));
    }
}
