package dev.interview.jholkin.franchises.infraestructure.adapters.input.rest;

import dev.interview.jholkin.franchises.infraestructure.adapters.input.rest.model.response.ProductResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.RouterOperation;
import org.springdoc.core.annotations.RouterOperations;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class RoutingFunction {
    private final FranchiseHandler franchiseHandler;
    private final SubsidiaryHandler subsidiaryHandler;
    private final ProductHandler productHandler;

    @Bean

    public RouterFunction<ServerResponse> routingFranchise() {
        return route()
                .GET("/franchises/{id}", franchiseHandler::getFranchiseById)
                .GET("/franchises", franchiseHandler::listFranchises)
                .POST("/franchises", franchiseHandler::createFranchise)
                .PUT("/franchises/{id}", franchiseHandler::updateFranchise)
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> routingSubsidiary() {
        return route()
                .GET("/franchises/{id}/subsidiaries", subsidiaryHandler::getByFranchiseId)
                .GET("/subsidiaries/{id}", subsidiaryHandler::getById)
                .GET("/subsidiaries/top-products", subsidiaryHandler::topProducts)
                .POST("/franchises/{id}/subsidiaries", subsidiaryHandler::create)
                .PUT("/subsidiaries/{id}", subsidiaryHandler::update)
                .build();
    }

    @Bean
    @RouterOperations({
            @RouterOperation(
                    path = "/products",
                    method = RequestMethod.GET,
                    beanClass = ProductHandler.class,
                    beanMethod = "findAll",
                    operation = @Operation(
                            operationId = "findAll",
                            summary = "Get all products",
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Successful operation",
                                            content = @Content(schema = @Schema(implementation = ProductResponse.class))
                                    )
                            }
                    )
            ),
            @RouterOperation(
                    path = "/products/{id}",
                    method = RequestMethod.GET,
                    beanClass = ProductHandler.class,
                    beanMethod = "getById",
                    operation = @Operation(
                            operationId = "getById",
                            summary = "Get product by ID",
                            parameters = {
                                    @Parameter(in = ParameterIn.PATH, name = "id", description = "Product ID")
                            },
                            responses = {
                                    @ApiResponse(
                                            responseCode = "200",
                                            description = "Successful operation",
                                            content = @Content(schema = @Schema(implementation = ProductResponse.class))
                                    ),
                                    @ApiResponse(
                                            responseCode = "404",
                                            description = "Product not found"
                                    )
                            }
                    )
            )
    })
    public RouterFunction<ServerResponse> routingProduct() {
        return route()
                .GET("/products", productHandler::findAll)
                .GET("/products/{id}", productHandler::getById)
                .POST("/products", productHandler::create)
                .PUT("/products/{id}", productHandler::update)
                .DELETE("/products/{id}", productHandler::delete)
                .build();
    }
}
