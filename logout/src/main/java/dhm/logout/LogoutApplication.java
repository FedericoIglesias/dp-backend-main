package dhm.logout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LogoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogoutApplication.class, args);
	}

}
