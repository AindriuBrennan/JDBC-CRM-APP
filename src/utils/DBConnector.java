package utils;

import java.sql.*;
import java.util.Properties;

public class DBConnector {
	
	private final String userName = "root";
	
	private final String password = "";
	
	private final String serverName = "localhost";
	
	private final int portNumber = 3306;
	
	private final String dbName = "test";
	
	private final String tableName = "employee";
	
	/**
	 * Get a new connection to the DB and return it
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", this.userName);
		connectionProps.put("password", this.password);
		
		conn = DriverManager.getConnection("jdbc:mysql://"
				+ this.serverName + ":" + this.portNumber + "/" + this.dbName + "?serverTimezone=UTC",
				connectionProps);
		return conn;
	}
	
	
	
	/**
	 * Connect to the employee table and get a Resultset
	 * of the data contained in it
	 * @return
	 * @throws SQLException
	 */
	public ResultSet getDB() throws SQLException {
		Statement dbStatement = getConnection().createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		dbStatement.executeQuery("SELECT * FROM employee");
		ResultSet rs = dbStatement.getResultSet();
		return rs;
	}

}
