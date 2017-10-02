package com.github.francoagarcia.connector;

import org.apache.avro.Schema;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Map;

public abstract class AbstractAvroDeserializer<T extends SpecificRecordBase> implements Deserializer<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractAvroDeserializer.class);

	protected abstract Schema getSchema();
	
	@Autowired
	private AvroSerdes<T> avroSerdes;
	
	@Override
	public void close() { /* No op.. */ }

	@Override
	public void configure(Map<String, ?> arg0, boolean arg1) { /* No op.. */ }

	@Override
	public T deserialize(String topic, byte[] data) {
		try {
			return avroSerdes.deserialize(getSchema(), data);
		} catch (Exception ex) {
			throw new SerializationException("Can't deserialize data '" + Arrays.toString(data) + "' from topic '" + topic + "'", ex);
		}
	}
}
