package uz.boom.webfluxboom.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import uz.boom.webfluxboom.entity.Todo;

@Repository
public interface TodoRepository extends R2dbcRepository<Todo, Integer> {
    Flux<Todo> findByColumnId(int columnId);
}
