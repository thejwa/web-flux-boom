package uz.boom.webfluxboom;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class WebFluxBoomApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(WebFluxBoomApplication.class, args);
    }
    
}
