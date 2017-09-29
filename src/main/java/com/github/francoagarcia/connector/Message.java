package com.github.francoagarcia.connector;

import java.io.Serializable;

public class Message<T> implements Serializable {
	
	private String topicResponse;
	private String messageType;
	private String sender;
	private T data;

	public Message() { }
	
	public String getTopicResponse() {
		return topicResponse;
	}
	
	public void setTopicResponse(String topicResponse) {
		this.topicResponse = topicResponse;
	}
	
	public String getMessageType() {
		return messageType;
	}
	
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	
	public String getSender() {
		return sender;
	}
	
	public void setSender(String sender) {
		this.sender = sender;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "Message{" +
				"topicResponse='" + topicResponse + '\'' +
				", messageType='" + messageType + '\'' +
				", sender='" + sender + '\'' +
				", data=" + data +
				'}';
	}
	
	
}
