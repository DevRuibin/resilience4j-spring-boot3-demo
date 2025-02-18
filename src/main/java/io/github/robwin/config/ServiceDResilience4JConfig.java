package io.github.robwin.config;

import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class ServiceDResilience4JConfig {
    private static final String serviceDName = "serviceD";
    private static final String serviceEName = "serviceE";

    @Bean
    public CircuitBreakerConfigCustomizer serviceDCustomizer() {
        return CircuitBreakerConfigCustomizer
                .of(serviceDName, builder -> builder.slidingWindowSize(100));
    }




//    @Bean
//    public RateLimiterRegistry rateLimiterRegistry() {
//        return RateLimiterRegistry.ofDefaults();
//    }


    @Bean(name = "serviceDRateLimiter")
    public RateLimiter serviceDRateLimiterConfigCustomizer(RateLimiterRegistry rateLimiterRegistry) {
        RateLimiterConfig config =  RateLimiterConfig.custom()
                .limitForPeriod(1)
                .limitRefreshPeriod(Duration.ofSeconds(5))
                .timeoutDuration(Duration.ofSeconds(0))
                .build();
        return rateLimiterRegistry.rateLimiter(serviceDName, config);
    }



    @Bean(name = "serviceERateLimiter")
    public RateLimiter serviceERateLimiterConfigCustomizer(RateLimiterRegistry rateLimiterRegistry) {
        RateLimiterConfig config =  RateLimiterConfig.custom()
                .limitForPeriod(3)
                .limitRefreshPeriod(Duration.ofSeconds(5))
                .timeoutDuration(Duration.ofSeconds(0))
                .build();
        return rateLimiterRegistry.rateLimiter(serviceEName, config);

    }

}
