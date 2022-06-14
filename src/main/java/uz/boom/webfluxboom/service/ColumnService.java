package uz.boom.webfluxboom.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import uz.boom.webfluxboom.dtos.column.ColumnDto;
import uz.boom.webfluxboom.dtos.todo.TodoDto;
import uz.boom.webfluxboom.mapper.ColumnMapper;
import uz.boom.webfluxboom.repo.ColumnRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class ColumnService {
    private final ColumnRepository repository;
    private final ColumnMapper mapper;
    private final TodoService todoService;
    
    public Flux<ColumnDto> getByProjectId(Integer projectId) {
        return repository.findByProjectId(projectId)
                .flatMap(column -> Mono.just(column)
                        .map(mapper::toDto)
                        .zipWith(todoService.getByColumnId(column.getId()).collectList())
                        .subscribeOn(Schedulers.parallel())
                ).doOnNext(tuple2 -> tuple2.getT1().setTodos(tuple2.getT2()))
                .flatMap(a -> Mono.just(a.getT1())
                        .subscribeOn(Schedulers.parallel()));
        
    }
    
    private List<TodoDto> getTodos(int columnId) {
        AtomicReference<List<TodoDto>> response = new AtomicReference<>(new ArrayList<>());
        todoService.getByColumnId(columnId)
                .subscribe(todoDto -> response.get().add(todoDto));
        return response.get();
    }
    
}
