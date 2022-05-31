package unicomer.backend.api.config; 

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

/**
 * @author Kevin Candia
 * 28-05-2022
 */
@Configuration
@OpenAPIDefinition(
	info = @Info(
		title 		= "Unicomer", 
		license 	= @License(name = "Copyright © 2022 Unicomer"), 
		description = "Capturar los datos de candidatos de posibles clientes para Unicomer Jamaica."
	)
)
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**").allowedMethods("PUT", "POST", "GET", "DELETE", "OPTION", "HEAD").maxAge(3600);
	}

}
