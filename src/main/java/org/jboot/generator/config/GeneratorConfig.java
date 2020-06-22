package org.jboot.generator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Configuration
@ConfigurationProperties
public class GeneratorConfig {

    @Value("${spring.generator..package}")
    private String packageName;

    @Value("${spring.generator..java}")
    private String javaPath;

    @Value("${spring.generator..resource}")
    private String resourcePath;

}
