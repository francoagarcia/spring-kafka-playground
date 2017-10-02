package com.github.francoagarcia.config;

import com.github.francoagarcia.connector.DefaultReceiverConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
@Import(DefaultReceiverConfig.class)
public class ReceiverConfig {

}

