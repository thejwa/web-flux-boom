package uz.boom.webfluxboom.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import uz.boom.webfluxboom.entity.Column;

@Repository
public interface ColumnRepository extends R2dbcRepository<Column, Integer> {
    Flux<Column> findByProjectId(int projectId);
}
