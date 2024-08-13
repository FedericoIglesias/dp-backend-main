package dhm.logout;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class LogoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogoutApplication.class, args);
	}
	@Bean
	public OpenAPI customOpenApi() {
		return new OpenAPI()
				.info(new Info()
						.title("DHM Api Logout")
						.version("0.1")
						.description("Endpoints of api logout")
				);
	}

}
