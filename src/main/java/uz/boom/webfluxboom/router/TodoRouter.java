package uz.boom.webfluxboom.router;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import uz.boom.webfluxboom.entity.Todo;
import uz.boom.webfluxboom.handler.TodoHandler;

@Configuration
public class TodoRouter {
    @Bean("todo_routerr")
    @SuppressWarnings("NullableProblems")
    @RouterOperations({
            @RouterOperation(
                    path = "/todo",
                    produces = {
                            MediaType.APPLICATION_JSON_VALUE
                    },
                    method = RequestMethod.GET,
                    beanClass = TodoHandler.class,
                    beanMethod = "getAll",
                    operation = @Operation(
                            operationId = "getAll",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "success",
                                            content = @Content(schema = @Schema(
                                                    implementation = Todo.class
                                            ))
                                    )
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> todoRouter(TodoHandler handler) {
        return RouterFunctions.route()
                .GET("/todo", handler::getAll)
                .GET("/redirect_me", handler::redirectMe)
                .GET("/todo/{id}", handler::get)
                .POST("/todo", handler::create)
                .build();
    }
}
