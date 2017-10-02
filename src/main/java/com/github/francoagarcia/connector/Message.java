package com.github.francoagarcia.connector;

public class Message<D> extends AbstractMessage<D> {
	
	protected D data;

	public Message() { }
	
	public D getData() {
		return data;
	}

	public void setData(D data) {
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
