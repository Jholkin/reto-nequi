package dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.config;

import org.springdoc.core.configuration.SpringDocConfiguration;
import org.springdoc.core.properties.SpringDocConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springdoc.webflux.api.OpenApiResource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import java.net.URI;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class SwaggerConfig {

    @Bean
    public RouterFunction<ServerResponse> swaggerRoutes(OpenApiResource openApiResource,
                                                        SwaggerUiConfigProperties swaggerUiConfig,
                                                        SpringDocConfigProperties springDocConfig) {

        String apiDocsPath = springDocConfig.getApiDocs().getPath();
        String uiPath = swaggerUiConfig.getPath();

        return route(GET(uiPath), request ->
                ServerResponse.temporaryRedirect(
                                URI.create("/webjars/swagger-ui/index.html?url=" + apiDocsPath))
                        .build());
    }

    /*@Bean
    public SpringDocConfiguration springDocConfiguration() {
        return new SpringDocConfiguration();
    }*/

    /*@Bean
    public SpringDocConfigProperties springDocConfigProperties() {
        return new SpringDocConfigProperties();
    }*/

    @Bean
    public ObjectMapperProvider objectMapperProvider(SpringDocConfigProperties springDocConfigProperties) {
        return new ObjectMapperProvider(springDocConfigProperties);
    }

    /*@Bean
    public SwaggerUiConfigProperties swaggerUiConfigProperties() {
        return new SwaggerUiConfigProperties();
    }*/
}
