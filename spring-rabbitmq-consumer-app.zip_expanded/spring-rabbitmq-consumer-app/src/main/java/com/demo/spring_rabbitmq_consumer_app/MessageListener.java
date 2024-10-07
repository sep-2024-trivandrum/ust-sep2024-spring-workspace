package com.demo.spring_rabbitmq_consumer_app;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

	@RabbitListener(queues = MQConfig.QUEUE)
	public void listener(CustomMessage message) {
		System.out.println(message);
	}
}
