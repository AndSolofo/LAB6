package seg3x02.Spring_Boot_RestCalculator.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

	@Bean
	fun calculatorOpenAPI(): OpenAPI =
		OpenAPI().info(
			Info()
				.title("REST Calculator API")
				.version("1.0.0")
				.description(
					"A Spring Boot REST API exposing add, subtract, multiply and divide " +
						"operations on two numeric operands.",
				),
		)
}
