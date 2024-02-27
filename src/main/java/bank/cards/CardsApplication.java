package bank.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("bank.cards.repository")
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title= "Cards microservice REST API Documentation",
				description= "Bank Cards microservices REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Thais Contreras",
						email = "tutor@bank.com"
				),
				license = @License(
						name = "Apache 2.0"
				)

		),
		externalDocs = @ExternalDocumentation(
				description = "Bank Cards microservices REST API Documentation",
				url = "http://localhost:9000/swagger-ui/index.html#/"
		)
)
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(CardsApplication.class, args);
	}

}
