package jdbc.postgress;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgis.Geometry;
import org.postgis.PGgeometry;

import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;

import broker.entities.DeviceLocation;
import broker.entities.Dumpster;
import broker.entities.MeasureDumpster;

public class PostgreSQLConnection {
	//jdbc URL
	//jdbc USER
	//jdbc PASSWORD
	

    Statement stmt = null;
    ResultSet rs = null;
    Connection con = null;
    
    public PostgreSQLConnection() throws ClassNotFoundException, SQLException {
    	Class.forName("org.postgresql.Driver");   
    	con = DriverManager.getConnection(url, user, password);
    }
	
	private final String url = "jdbc:postgresql://localhost:5432/iot_garbagecollection?currentSchema=public";
	private final String user = "postgres";
	private final String password = "root";
	
	public Dumpster searchDevID(String devId)
		    throws SQLException {

		    String query = "select * from dumpster where device_id = '"+ devId + "'";
		    try {
		        stmt = con.createStatement();
		        rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	 Dumpster  dumpster = new Dumpster();
		        	 dumpster.setId(rs.getInt("id"));
		        	 dumpster.setDeviceID(rs.getString("device_id"));
		        	 dumpster.setIdDumpsterType(rs.getInt("id_dumpster_type"));
		        	 dumpster.setIdPhysicalState(rs.getInt("id_physical_state"));
		        	 //dumpster.setLocation(new Geometry());
		        	 //rs.getString("location");
		        	 dumpster.setVia(rs.getInt("idvia"));
		        	 System.out.println(dumpster.toString());
		        	 return dumpster;
		        }
		    } catch (SQLException e ) {
		       e.printStackTrace();
		    } finally {
		        if (stmt != null) { stmt.close(); }
		        if (rs != null) { rs.close(); }
		    }
			return null;
		}

	public long saveMeasureDumpster(MeasureDumpster measureDump ) {
		 PreparedStatement statement;
		    try {
		        statement =con.prepareStatement("INSERT INTO measure_dumpter (id,id_dumpster,\"level\",measure_date,priority) VALUES (?,?,?,?,?)");
		        statement.setInt(1, measureDump.getId());
		        statement.setInt(2, measureDump.getIdDumpster());
		        statement.setInt(3, measureDump.getLevel());
		        java.sql.Timestamp sqlDate = new java.sql.Timestamp( measureDump.getMeasureDate().getTime());
		        statement.setTimestamp(4, sqlDate);
		        statement.setInt(5, measureDump.getPriority());
		        int affectedRows = statement.executeUpdate();
	            // check the affected rows 
	            if (affectedRows > 0) {
	                // get the ID back
	                try (ResultSet rs = statement.getGeneratedKeys()) {
	                    if (rs.next()) {
	                    	System.out.println("inserted id: "+ rs.getLong(1));
	                        return rs.getLong(1);
	                    }
	                } catch (SQLException ex) {
	                    System.out.println(ex.getMessage());
	                }
	            }
		    }catch(SQLException e ){
		    	e.printStackTrace();
		    }
			return 0;
	}

	public int findLastID() {
		 String query = "select max(id) as id from  measure_dumpter";
		    try {
		        stmt = con.createStatement();
		        rs = stmt.executeQuery(query);
		        while (rs.next()) {
		        	 return rs.getInt("id");
		        }
		    }catch(SQLException e ){
		    	e.printStackTrace();
		    }
			return 0;
	}
	
	public long saveDeviceLocation(DeviceLocation devLocation ) throws ClassNotFoundException, SQLException {
		PreparedStatement statement2;
	    try {
	        statement2 =con.prepareStatement("INSERT INTO public.device_location (\"location\", moment_date, full_level, device_id) VALUES(?, ?, ?, ?)");

	        //PGpoint point = new PGpoint(devLocation.getLocation().getCoordinate().x,devLocation.getLocation().getCoordinate().y);
	        GeometryFactory geoFact = new GeometryFactory();
	        Point point= geoFact.createPoint(devLocation.getLocation().getCoordinate());
	        PGgeometry geom = new PGgeometry(point.toString());
	        statement2.setObject(1,geom);  //Spatial Reference System Identifier SRID:  3116 - magna-sirgas / colombia bogota zone 
	        java.sql.Timestamp sqlDate = new java.sql.Timestamp( new java.util.Date().getTime());
	        statement2.setTimestamp(2, sqlDate);
	        statement2.setInt(3, devLocation.getFull_level());
	        statement2.setString(4, devLocation.getDevice_id());
	        int affectedRows = statement2.executeUpdate();
            // check the affected rows 
            if (affectedRows > 0) {
                // get the ID back
                try (ResultSet rs = statement2.getGeneratedKeys()) {
                    if (rs.next()) {
                    	System.out.println("inserted id: "+ rs.getLong(1));
                        return rs.getLong(1);
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
	    }catch(SQLException e ){
	    	e.printStackTrace();
	    }
		return 0;
	}
	
	public PGgeometry convertObjectValueToDataValue(Object objectValue) {
        if ((null == objectValue) || (!(objectValue instanceof org.postgis.Geometry)))
            return null;
        return new org.postgis.PGgeometry((org.postgis.Geometry)objectValue);
    }

}
