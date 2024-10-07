package com.demo.spring_rabbitmq_producer_app;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomMessage {
	private String messageId;
	private String message;
	private Date messageDate;
}
