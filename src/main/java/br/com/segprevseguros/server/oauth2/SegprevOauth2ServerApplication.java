package br.com.segprevseguros.server.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SegprevOauth2ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SegprevOauth2ServerApplication.class, args);
    }
}
