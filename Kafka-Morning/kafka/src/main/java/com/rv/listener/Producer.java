package com.rv.listener;

//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
//import com.rv.model.Order;
//
//@Service
//public class Producer {
//	@Autowired
//	private KafkaTemplate<String, Order> temp;
//	private static final String TOPIC="TestTopic";
//	public String sendMessage(int id, int qty, String type) {
//		temp.send(TOPIC,new Order(id,qty,type,new Date().toString()));
//		return "Published successfully";
//	}
//	
//
//}