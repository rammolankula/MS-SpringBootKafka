package learn.ram.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductService {
	
	@Autowired
	public KafkaTemplate<String,String> template;
	
	@Value("${my.kafka.topic.name}")
	public String topicName;
	
	public void sendMessage(String message) {
		System.out.println("FROM PRODUCER===>"+message);
		template.send(topicName, message);
	}

}
