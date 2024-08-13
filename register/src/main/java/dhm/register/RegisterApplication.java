package dhm.register;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RegisterApplication {

  public static void main(String[] args) {
    SpringApplication.run(RegisterApplication.class, args);
  }

  @Bean
  public OpenAPI customOpenApi() {
    return new OpenAPI()
        .info(new Info()
            .title("DHM Api Register")
            .version("0.1")
            .description("Endpoints  of api register")
        );
  }

}
