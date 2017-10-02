package com.github.francoagarcia.connector;

import com.github.francoagarcia.domain.User;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.*;
import org.apache.avro.reflect.ReflectDatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class AvroSerdes<T extends SpecificRecordBase> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AvroSerdes.class);
	
	public byte[] serialize(Schema schema, T data) throws IOException {
		byte[] result = null;
		
		if (data != null) {
			LOGGER.debug("data='{}'", data);
			
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			BinaryEncoder binaryEncoder = EncoderFactory.get().binaryEncoder(outputStream, null);
			
			DatumWriter<GenericRecord> datumWriter = new GenericDatumWriter<>( schema );
			datumWriter.write(data, binaryEncoder);
			
			binaryEncoder.flush();
			outputStream.close();
			
			result = outputStream.toByteArray();
			LOGGER.debug("serialized data='{}'", DatatypeConverter.printHexBinary(result));
		}
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public T deserialize(Schema schema, byte[] data) throws IOException {
		T result = null;
		
		if (data != null) {
			LOGGER.debug("data='{}'", DatatypeConverter.printHexBinary(data));
			
			DatumReader<GenericRecord> datumReader = new SpecificDatumReader<>(schema);
			Decoder decoder = DecoderFactory.get().binaryDecoder(data, null);
			
			result = (T) datumReader.read(null, decoder);
			
			LOGGER.debug("deserialized data='{}'", result);
		}
		return result;
	}
	
}
