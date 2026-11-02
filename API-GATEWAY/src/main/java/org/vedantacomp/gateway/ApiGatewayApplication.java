package org.vedantacomp.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		// --- PRINT EXACT DISK LOCATION ---
        System.out.println(">>> JVM WORKING DIR: " + System.getProperty("user.dir"));
        // ----------------------------------
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}
