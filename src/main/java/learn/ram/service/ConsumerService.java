package learn.ram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import learn.ram.util.MessageStore;

@Component
public class ConsumerService {
	
	
	@Autowired
	private MessageStore ms;
	
	@KafkaListener(topics = "${my.kafka.topic.name}",groupId = "${spring.kafka.consumer.group-id}")
	public void readMessage(String message) {
		System.out.println("FROM CONSUMER===>"+message);
		ms.addMessage(message);
	}

}
