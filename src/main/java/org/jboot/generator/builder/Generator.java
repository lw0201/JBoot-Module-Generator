package org.jboot.generator.builder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@Configuration
@ConfigurationProperties
public class Generator {

    @Value("${jboot.package}")
    private String packageName;

    @Value("${jboot.java}")
    private String javaPath;

    @Value("${jboot.resource}")
    private String resourcePath;

}
