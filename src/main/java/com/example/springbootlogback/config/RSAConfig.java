package com.example.springbootlogback.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class RSAConfig {

    @Value("${rsa.public-key-path}")
    private String publicKeyPath;

    @Value("${rsa.private-key-path}")
    private String privateKeyPath;
}
