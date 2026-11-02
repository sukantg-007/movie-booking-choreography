package org.vedantacomp.booking.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;
import org.vedantacomp.booking.client.ShowServiceClient;
import org.vedantacomp.booking.client.UserServiceClient;

@Configuration
public class ClientConfig {

    @Value("${services.show-service.url}")
    private String showServiceUrl;
    
    @Value("${services.user-service.url}")
    private String userServiceUrl;

    @Bean
    @LoadBalanced
    public RestClient.Builder loadBalancedRestClientBuilder() {
        return RestClient.builder();
    }

 // Bean 1: UserServiceClient
    @Bean
    public UserServiceClient userServiceClient(RestClient.Builder builder) {
        RestClient restClient = builder
                .baseUrl(userServiceUrl)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(UserServiceClient.class);
    }
    @Bean
    public ShowServiceClient showServiceClient(RestClient.Builder loadBalancedRestClientBuilder) {
        RestClient restClient = loadBalancedRestClientBuilder
                .baseUrl(showServiceUrl)
                .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builderFor(RestClientAdapter.create(restClient))
                .build();

        return factory.createClient(ShowServiceClient.class);
    }
}