package broker.entities;

import com.vividsolutions.jts.geom.Geometry;

public class Dumpster {

	private Integer id;
	private Geometry location;
	private Integer idDumpsterType;
	private Integer idPhysicalState;
    private Integer via;
    private String deviceID;
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
	public Integer getIdDumpsterType() {
		return idDumpsterType;
	}
	public void setIdDumpsterType(Integer idDumpsterType) {
		this.idDumpsterType = idDumpsterType;
	}
	public Integer getIdPhysicalState() {
		return idPhysicalState;
	}
	public void setIdPhysicalState(Integer idPhysicalState) {
		this.idPhysicalState = idPhysicalState;
	}
	public Integer getVia() {
		return via;
	}
	public void setVia(Integer via) {
		this.via = via;
	}
	public String getDeviceID() {
		return deviceID;
	}
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	@Override
    public String toString() {
        return "Dumpster{" + "id=" + id + ", location=" + location + ", idDumpsterType=" + idDumpsterType + ", idPhysicalState=" + idPhysicalState + ", idvia=" + via + ", deviceID=" + deviceID + '}';
    }    
}
