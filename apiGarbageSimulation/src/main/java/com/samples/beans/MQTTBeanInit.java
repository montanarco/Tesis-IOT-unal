package com.samples.beans;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.samples.mqtt.MQTTClient;

@SpringBootApplication
public class MQTTBeanInit //implements CommandLineRunner 
{
		 
	 private static final Logger logger = LogManager.getLogger(MQTTBeanInit.class);
	 

	     @Autowired
	     private MQTTClient mqttClient;


	    // @Override
//	     public void run(String... args) throws Exception {
//	    	 logger.trace("se ejecuto el BEAN");
//	    	 mqttClient.messageManagement();
//	     }

}
