package org.jboot.generator.builder;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class SpringDataSource {

    private String driverClassName;

    private String type;

    private String url;

    private String username;

    private String password;

}
