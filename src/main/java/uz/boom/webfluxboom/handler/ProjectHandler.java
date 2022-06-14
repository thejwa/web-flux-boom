package uz.boom.webfluxboom.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import uz.boom.webfluxboom.entity.Project;
import uz.boom.webfluxboom.service.ProjectService;

import java.util.concurrent.atomic.AtomicReference;

@Component
@RequiredArgsConstructor
public class ProjectHandler {
    private final ProjectService service;
    
    
    public Mono<ServerResponse> getAll(ServerRequest request) {
        return ServerResponse.ok().body(service.getAll(), Project.class);
        
    }
    
    public Mono<ServerResponse> get(ServerRequest request) {
        AtomicReference<Integer> atomicId = getAtomicIntegerFromString(request.pathVariable("id"), "id");
        return service.get(atomicId.get())
                .flatMap(projectDto -> ServerResponse.ok()
                        .bodyValue(projectDto)
                        .onErrorResume(Mono::error));
    }
    
    private AtomicReference<Integer> getAtomicIntegerFromString(String str, String fieldName) {
        AtomicReference<Integer> field = new AtomicReference<>(0);
        
        if (str.length() == 0 || str.equals("0")) throw new RuntimeException(fieldName + " is not given!");
        
        try {
            field.set(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            throw new RuntimeException(fieldName + " is not proper format!");
        }
        return field;
    }
}
