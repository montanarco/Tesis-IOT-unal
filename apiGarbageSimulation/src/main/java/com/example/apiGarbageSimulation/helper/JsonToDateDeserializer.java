package com.example.apiGarbageSimulation.helper;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Point;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JsonToDateDeserializer extends JsonDeserializer<Date> {

	@Override
	public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		 try {
	            String text = jp.getText();
	            if(text == null || text.length() <= 0)
	                return null;

	            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(text); 
	            return date;
	        }
	        catch(Exception e){
	            return null;
	        }
	}

}
