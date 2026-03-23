package com.andresleon.spring_web_de_cero_a_experto.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "user Apí",
                version = "${api.version}",
                contact = @Contact(
                        name = "Andres", email = "andres05leonfernandez@gmail.com", url = "https://www.baeldung.com"
                ),
                license = @License(
                        name = "Apache 2.0", url = "https://www.apache.org/licenses/LICENSE-2.0"
                ),
                termsOfService = "${tos.uri}",
                description = "${api.description}"
        ),
        servers = @Server(
                url = "http://localhost:8080/swagger-ui/index.html",
                description = "production"
        )
)
@Configuration
public class SwaggerConfig {
}
