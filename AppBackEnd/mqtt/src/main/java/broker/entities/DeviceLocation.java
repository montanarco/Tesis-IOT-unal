package broker.entities;

import java.sql.Timestamp;

import com.vividsolutions.jts.geom.Geometry;

public class DeviceLocation {
	
	private Integer id;
	private Geometry location;
	private Timestamp moment_date; 
	private Integer full_level;
	private String device_id;
	
	public DeviceLocation() {
		super();
	}
	
	public DeviceLocation(Integer id, Geometry location, Timestamp moment_date, Integer full_level, String device_id) {
		super();
		this.id = id;
		this.location = location;
		this.moment_date = moment_date;
		this.full_level = full_level;
		this.device_id = device_id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Geometry getLocation() {
		return location;
	}
	public void setLocation(Geometry location) {
		this.location = location;
	}
	public Timestamp getMoment_date() {
		return moment_date;
	}
	public void setMoment_date(Timestamp moment_date) {
		this.moment_date = moment_date;
	}
	public Integer getFull_level() {
		return full_level;
	}
	public void setFull_level(Integer full_level) {
		this.full_level = full_level;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	
	
}
