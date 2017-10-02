package com.github.francoagarcia.connector;

public abstract class AbstractMessage<D> {
	
	protected String topicResponse;
	protected String messageType;
	protected String sender;
	
	public abstract D getData();
	public abstract void setData(D data);

	public AbstractMessage() { }
	
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
	
	@Override
	public String toString() {
		return "AbstractMessage{" +
				"topicResponse='" + topicResponse + '\'' +
				", messageType='" + messageType + '\'' +
				", sender='" + sender + '\'' +
				'}';
	}
}
