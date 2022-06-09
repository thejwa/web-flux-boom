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

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColumnService {
    private final ColumnRepository repository;
    private final ColumnMapper mapper;
    private final TodoService todoService;
    
    public Flux<ColumnDto> getByProjectId(Integer projectId) {
//        repository.findByProjectId(projectId)
//                .flatMap(column -> Mono.just(column)
//                        .map(mapper::toDto)
//                        .subscribeOn(Schedulers.parallel())
//                ).map(columnDto ->
//                    todoService.getByColumnId(columnDto.getId())
//                            .collectList().map(list-> columnDto.setTodos(list))
//                   )
        return null;
    }
    
}
