package com.jdbc.posgres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLConnection {
	//jdbc URL
	//jdbc USER
	//jdbc PASSWORD
	
	private final String url = "jdbc:postgresql://localhost:5432/iot_garbagecollection?currentSchema=public";
	private final String user = "postgres";
	private final String password = "root";
	
	public void searchDevID(String devId)
		    throws SQLException {

		    Statement stmt = null;
		    ResultSet rs = null;
		    Connection con = null;
		    String query = "select * from dumpster where device_id = '"+ devId + "'";
		    try {
		    	Class.forName("org.postgresql.Driver");   
		    	con = DriverManager.getConnection(url, user, password);
		        stmt = con.createStatement();
		        rs = stmt.executeQuery(query);
		        ResultSetMetaData rsmd = rs.getMetaData();
		        int columnsNumber = rsmd.getColumnCount();
		        while (rs.next()) {
		        	 for (int i = 1; i <= columnsNumber; i++) {
		                 if (i > 1) System.out.print(",  ");
		                 String columnValue = rs.getString(i);
		                 System.out.print(columnValue + " " + rsmd.getColumnName(i));
		             }
		        }
		    } catch (SQLException e ) {
		       e.printStackTrace();
		    } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
		        if (stmt != null) { stmt.close(); }
		        if (rs != null) { rs.close(); }
		        if (con != null) { con.close(); }
		    }
		}

}
