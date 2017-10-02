package com.github.francoagarcia;

import com.github.francoagarcia.connector.BasicSender;
import com.github.francoagarcia.connector.Message;
import com.github.francoagarcia.connector.MessageBuilder;
import com.github.francoagarcia.domain.User;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTests {

	private final static String tPlaygroundRequest = "playground.req";

	@Autowired
	private BasicSender<Message<User>> sender;
	
	@Autowired
	private KafkaListenerEndpointRegistry containerRegistry;

	@ClassRule
	public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, 1, tPlaygroundRequest);

	@Before
	public void setUp() throws Exception {
		Collection<MessageListenerContainer> containers = containerRegistry.getListenerContainers();
		for (MessageListenerContainer container : containers) {
			ContainerTestUtils.waitForAssignment(container, embeddedKafka.getPartitionsPerTopic());
		}
	}
	
	@Test
	public void testSendMessage() {
		User user = new User("franco", "franco");
		
		Message<User> message = new MessageBuilder<User>()
										.messageType("test")
										.data(user)
										.build();
		
		sender.send(tPlaygroundRequest, message);
	}

}
