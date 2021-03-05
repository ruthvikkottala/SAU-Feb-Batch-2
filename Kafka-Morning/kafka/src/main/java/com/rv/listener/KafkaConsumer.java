package com.rv.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.rv.model.Order;

@Service
public class KafkaConsumer {
	@KafkaListener(topics = "TestTopic", groupId = "group_json",containerFactory = "kafkaListenerContainerFactory")
	public void consumeJson(Order order) {
		System.out.println("consumed message"+order);
	}
}
