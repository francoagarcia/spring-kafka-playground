package com.github.francoagarcia.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class BasicSender<T extends AbstractMessage> {

	protected static final Logger LOGGER = LoggerFactory.getLogger(BasicSender.class);
	
    @Autowired
    protected KafkaTemplate<String, T> kafkaTemplate;
	
	public void send(String topic, T message) {
		LOGGER.info("\n\nSending Message: '{}' to Topic='{}'\n\n", message, topic);
		kafkaTemplate.send(topic, message);
	}
	
	public void send(String topic, int partition, T message) {
		LOGGER.info("\n\nSending Message: '{}' to Topic='{}' and Partition='{}'\n\n", message, topic, partition);
		kafkaTemplate.send(topic, partition, message);
	}
	
	public void send(String topic, String key, T message) {
		LOGGER.info("\n\nSending Message: '{}' to Topic='{}' with Key='{}'\n\n", message, topic, key);
		kafkaTemplate.send(topic, key, message);
	}
	
	public void send(String topic, int partition, String key, T message) {
		LOGGER.info("\n\nSending Message: '{}' to Topic='{}' and Partition='{}' with Key='{}'\n\n", message, topic, partition, key);
		kafkaTemplate.send(topic, key, message);
	}
	
	public KafkaTemplate getKafkaTemplate(){
		return this.kafkaTemplate;
	}
}