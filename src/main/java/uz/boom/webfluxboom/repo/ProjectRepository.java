package uz.boom.webfluxboom.repo;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import uz.boom.webfluxboom.entity.Project;

@Repository
public interface ProjectRepository extends R2dbcRepository<Project, Integer> {
}
