package com.github.francoagarcia.connector;

public class MessageBuilder<T> {

	private Message<T> message;

	public MessageBuilder(){
		this.message = new Message<T>();
	}
	
	public Message<T> build(){
		return message;
	}
	
	public MessageBuilder<T> topicResponse(final String topicResponse){
		message.setTopicResponse(topicResponse);
		return this;
	}
	public MessageBuilder<T> messageType(final String messageType){
		message.setMessageType(messageType);
		return this;
	}
	public MessageBuilder<T> sender(final String sender){
		message.setSender(sender);
		return this;
	}
	public MessageBuilder<T> data(final T data){
		message.setData(data);
		return this;
	}
}
