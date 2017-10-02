package com.github.francoagarcia.messaging;

import com.github.francoagarcia.connector.Message;
import com.github.francoagarcia.domain.User;
import com.github.francoagarcia.connector.BasicSender;
import com.github.francoagarcia.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class UserReceiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserReceiver.class);

    @Value("${kafka.topic.playground-req}")
    private String tPlaygroundRequest;

	@Autowired
	private BasicSender<Message<User>> sender;

	@Autowired
	private UserService userService;

    @KafkaListener(topics = "${kafka.topic.playground-req}")
    public void handlePlaygroundRequest(Message<User> message){
        LOGGER.info("\n\nReceived User='{}' from Topic='{}'\n\n", message, tPlaygroundRequest);
    }

}
