package com.joshua.activityservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    @Bean
    @LoadBalanced
    public RestClient.Builder loadBalancedRestClientBuilder(){
        return RestClient.builder();
    }
    @Bean
    public RestClient userServiceRestClient(RestClient.Builder restClientBuilder){
        return restClientBuilder
                .baseUrl("http://USER-SERVICE")
                .build();

    }
}
