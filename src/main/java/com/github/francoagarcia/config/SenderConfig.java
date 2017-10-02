package com.github.francoagarcia.config;

import com.github.francoagarcia.connector.DefaultSenderConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DefaultSenderConfig.class)
public class SenderConfig {

}