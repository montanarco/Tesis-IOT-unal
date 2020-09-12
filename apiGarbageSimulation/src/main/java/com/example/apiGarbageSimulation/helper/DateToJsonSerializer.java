package com.example.apiGarbageSimulation.helper;

import java.io.IOException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.util.Date;

public class DateToJsonSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider serializers) throws IOException {
		String jsonValue = "null";
		try {
			if (value != null) {
				jsonValue = new SimpleDateFormat("dd/MM/yyyy").format(value);
			}
		} catch (Exception e) {
		}

		jgen.writeString(jsonValue);
	}

}
