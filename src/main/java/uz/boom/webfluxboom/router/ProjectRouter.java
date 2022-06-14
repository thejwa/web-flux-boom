package uz.boom.webfluxboom.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import uz.boom.webfluxboom.config.filter.CustomHandlerFilter;
import uz.boom.webfluxboom.handler.ProjectHandler;

@Configuration
public class ProjectRouter {
    private final CustomHandlerFilter filter = new CustomHandlerFilter();
    
    @Bean
    public RouterFunction<ServerResponse> projectRoute(ProjectHandler handler) {
        return RouterFunctions.route()
                .GET("/project", handler::getAll)
                .GET("/project/{id}", handler::get)
                .filter(filter)
                .build();
    }
}
