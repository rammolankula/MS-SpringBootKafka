package learn.ram.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import learn.ram.service.ProductService;
import learn.ram.util.MessageStore;

@RestController
public class KafkaRestController {
	
	@Autowired
	private ProductService producerService;
	@Autowired
	private MessageStore ms;
	
	@GetMapping("/send")
	private String sendMsg(@RequestParam String message) {
		producerService.sendMessage(message);
		return "SUCCESS";
	}
	
	@GetMapping("/viewAll")
	public String viewAll() {
		return ms.viewAllmessages();
	}

}
