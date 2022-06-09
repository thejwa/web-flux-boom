package uz.boom.webfluxboom.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import uz.boom.webfluxboom.entity.Todo;
import uz.boom.webfluxboom.service.TodoService;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class TodoHandler {
    private final TodoService service;
    
    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(service.getAll(), Todo.class);
    }
    
    public Mono<ServerResponse> redirectMe(ServerRequest request) {
        return ServerResponse
                .permanentRedirect(URI.create("https://kun.uz/uz")).build();
    }
    
    public Mono<ServerResponse> create(ServerRequest request) {
        return ServerResponse.ok().bodyValue(service.create(request));
    }
    
    public Mono<ServerResponse> get(ServerRequest request) {
        return ServerResponse.ok().body(service.get(request), Todo.class);
    }
}
