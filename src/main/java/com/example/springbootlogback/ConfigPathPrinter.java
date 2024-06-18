package com.example.springbootlogback;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.util.Arrays;

/**
 * @Description
 * @Author Mico
 * @Date 2024/5/30 下午12:03
 */
public class ConfigPathPrinter implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment environment = event.getEnvironment();
        for (PropertySource<?> propertySource : environment.getPropertySources()) {
            String[] propertyNames = ((ResourcePropertySource) propertySource).getPropertyNames();
            Arrays.stream(propertyNames).forEach(propertyName -> {
                if (propertyName.startsWith("spring.config.additional-location")
                        || propertyName.startsWith("spring.config.location")
                        || propertyName.startsWith("spring.config.name")
                        || propertyName.startsWith("applicationConfigurationProperties")
                ) {
                    System.out.println("Loaded config property: " + propertyName + " = " + propertySource.getProperty(propertyName));
                }
            });
        }
    }
}
