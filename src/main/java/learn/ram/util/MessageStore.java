package learn.ram.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component  
public class MessageStore {
	
	private List<String> list=new ArrayList<>();
	
	public void addMessage(String message) {
		list.add(message);
	}
	
	public String viewAllmessages() {
		return list.toString();
	}

}
