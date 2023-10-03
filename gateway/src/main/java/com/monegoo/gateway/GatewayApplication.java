package com.monegoo.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {

    @Value("${monegoo.service.currency}")
    private String currencyServiceUrl;

    @Value("${monegoo.service.notification}")
    private String notificationServiceUrl;


    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(
                        "monegoo-currency",
                        r -> r.path("/currencies")
                                .filters(f -> f.prefixPath("/v1"))
//                .filters(f -> f
//                    .stripPrefix(1)
//                    .prefixPath("/drugs")
//                    .addRequestHeader("Content-Type", "application/prs.hal-forms+json")
//                )
                                .uri(String.format("http://%s/v1/currencies", currencyServiceUrl))
                )
                .route(
                        "monegoo-crypto",
                        r -> r.path("/crypto")
                                .filters(f -> f.prefixPath("/v1"))
                                .uri(String.format("http://%s", currencyServiceUrl))
                )
                .route(
                        "monegoo-crypto-history",
                        r -> r.path("/crypto/history")
                            .filters(f -> f.prefixPath("/v1"))
                            .uri(String.format("http://%s", currencyServiceUrl))
                )
                .route(
                        "monegoo-all-currency-v1",
                        r -> r.path("/converter/rates/v1/*")
                                .filters(f -> f
                                        .stripPrefix(3)
                                        .prefixPath("/v1"))
                                .uri(String.format("http://%s", currencyServiceUrl))
                )
                .route(
                        "monegoo-notification",
                        r -> r.path("/converter/notification/v1/*")
                                .filters(f -> f
                                        .stripPrefix(3)
                                        .prefixPath("/v1"))
                                .uri(String.format("http://%s", notificationServiceUrl))
                )
                .build();
    }
}
