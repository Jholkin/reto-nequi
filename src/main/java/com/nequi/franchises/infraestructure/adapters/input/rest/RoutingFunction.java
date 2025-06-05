package com.nequi.franchises.infraestructure.adapters.input.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
