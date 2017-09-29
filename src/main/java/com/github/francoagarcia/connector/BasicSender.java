package com.github.francoagarcia.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BasicSender<T> {

	protected static final Logger LOGGER = LoggerFactory.getLogger(BasicSender.class);
	
    @Autowired
    protected KafkaTemplate<String, Message<T>> kafkaTemplate;
	
	public void send(String topic, Message<T> message) {
		LOGGER.info("\n\nSending Message: '{}' to Topic='{}'\n\n", message, topic);
		kafkaTemplate.send(topic, message);
	}

	public void send(String topic, T data) {
		Message message = new MessageBuilder<T>().setData(data).build();
		send(topic, message);
	}
	
	public KafkaTemplate getKafkaTemplate(){
		return this.kafkaTemplate;
	}
}