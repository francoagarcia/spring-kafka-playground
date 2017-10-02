package com.github.francoagarcia.connector;

import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

public abstract class AbstractAvroSerializer<T extends SpecificRecordBase> implements Serializer<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAvroSerializer.class);

	protected abstract Schema getSchema();
	
	@Autowired
	private AvroSerdes<T> avroSerdes;

	@Override
	public void close() { /* No op.. */ }

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) { /* No op.. */ }

	@Override
	public byte[] serialize(String topic, T data) {
		try {
			return avroSerdes.serialize(getSchema(), data);
		} catch (IOException ex) {
			throw new SerializationException("Can't serialize data='" + data + "' for topic='" + topic + "'", ex);
		}
	}
}
