package org.thethingsnetwork.samples.mqtt;


import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedHashMap;

/*
 * The MIT License
 *
 * Copyright (c) 2017 The Things Network
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

import org.thethingsnetwork.data.common.Connection;
import org.thethingsnetwork.data.common.messages.ActivationMessage;
import org.thethingsnetwork.data.common.messages.DataMessage;
import org.thethingsnetwork.data.common.messages.DownlinkMessage;
import org.thethingsnetwork.data.common.messages.RawMessage;
import org.thethingsnetwork.data.common.messages.UplinkMessage;
import org.thethingsnetwork.data.mqtt.Client;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;

import broker.entities.DeviceLocation;
import broker.entities.Dumpster;
import broker.entities.MeasureDumpster;
import broker.utilities.utilities;
import jdbc.postgress.PostgreSQLConnection;

/**
 *
 * @author Romain Cambier
 */
public class App {

    public static void main(String[] args) throws Exception {
        String region = System.getenv("region");
        String appId = System.getenv("appId");
        String accessKey = System.getenv("accessKey");
        
        region = "us-west";
        appId = "01basurasbogota";
        accessKey = "ttn-account-v2.RmXvJu3XZ3e1S3B9cpFGwnBTBrCSVRniB_vMJEud3cA";
        
        Client client = new Client(region, appId, accessKey);

        class Response {

            private boolean led;

            public Response(boolean _led) {
                led = _led;
            }
        }

        client.onMessage(null, "led", (String _devId, DataMessage _data) -> {
            try {
                RawMessage message = (RawMessage) _data;
                // Toggle the LED
                DownlinkMessage response = new DownlinkMessage(0, new Response(!message.asBoolean()));

                /**
                 * If you don't have an encoder payload function:
                 * client.send(_devId, new Response(0, message.asBoolean() ? new byte[]{0x00} : new byte[]{0x01}));
                 */
                System.out.println("Sending: " + response);
                client.send(_devId, response);
            } catch (Exception ex) {
                System.out.println("Response failed: " + ex.getMessage());
            }
        });

        client.onMessage((String devId, DataMessage data) ->   processData(devId, data));

        client.onActivation((String _devId, ActivationMessage _data) -> System.out.println("Activation: " + _devId + ", data: " + _data.getDevAddr()));

        client.onError((Throwable _error) -> System.err.println("error: " + _error.getMessage()));

        client.onConnected((Connection _client) -> System.out.println("connected !"));

        client.start();
    }

	private static void processData(String devId, DataMessage data) {
		System.out.println("Message: " + devId + " " + ((UplinkMessage) data).getPayloadFields());
		Integer distance = (Integer) ((UplinkMessage) data).getPayloadFields().get("distance");
		Object location = (Object) ((UplinkMessage) data).getPayloadFields().get("location");
	
		System.out.println("location: "+ location.toString());
		LinkedHashMap mapLocation =  (LinkedHashMap) location;
		Double douLatitude =  (Double) mapLocation.get("lat");;
		Double douLongitude =  (Double) mapLocation.get("lng");
		PostgreSQLConnection dao;
		try {
			dao = new PostgreSQLConnection();
			Dumpster dumpster;
			MeasureDumpster measureDump;
			dumpster = dao.searchDevID(devId);
			int idDumpsterMeasure = dao.findLastID();
			idDumpsterMeasure ++;
			if (dumpster!=null) {
				//processing de maesure
				measureDump = new MeasureDumpster();
				measureDump.setId(idDumpsterMeasure);
				measureDump.setIdDumpster(dumpster.getId());
				Integer level = utilities.caltulateLevel(distance, dumpster.getIdDumpsterType());
				measureDump.setLevel(level);
				measureDump.setMeasureDate(new Date());
				measureDump.computePriority();
				dao.saveMeasureDumpster(measureDump);
				
				//posesiong the location
				DeviceLocation deviceLocation = new DeviceLocation();
				deviceLocation.setDevice_id(devId);
				deviceLocation.setFull_level(level);
				GeometryFactory geomFactory = new GeometryFactory();
				Coordinate coordinate = new Coordinate(douLatitude, douLongitude);
				com.vividsolutions.jts.geom.Point point = geomFactory.createPoint(coordinate);
				deviceLocation.setLocation(point);
				dao.saveDeviceLocation(deviceLocation);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
	}

}