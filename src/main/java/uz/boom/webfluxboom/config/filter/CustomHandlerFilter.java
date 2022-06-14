package uz.boom.webfluxboom.config.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.reactive.function.server.HandlerFilterFunction;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class CustomHandlerFilter implements HandlerFilterFunction<ServerResponse, ServerResponse> {
    @Override
    public Mono<ServerResponse> filter(ServerRequest request, HandlerFunction<ServerResponse> next) {
        return next.handle(request)
                .onErrorResume(e -> ServerResponse
                        .status(getErrorCode(e))
                        .bodyValue(new CustomExceptionInfo(getErrorCode(e), e.getMessage()))
                        .onErrorResume(Mono::error));
    }
    
    private int getErrorCode(Throwable e) {
        if (e.getMessage().equalsIgnoreCase("Not Found"))
            return 404;
        return 500;
    }
    
    
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class CustomExceptionInfo {
        private int code;
        private String message;
        
        public CustomExceptionInfo(Throwable e) {
            code = getErrorCode(e);
            message = e.getMessage();
        }
    }
}
