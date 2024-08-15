package com.lbg.utils.testservice.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
@Data
public class Config {

    @Value("${test-service.batch-service-url}")
    String batchServiceUrl;

}
