import java.sql.SQLException;

import gui.EmployeeDBGUI;
import utils.DBConnector;
/**
 * 
 * @author Andrew Brennan 20079247
 * Main class for launching the gui and connecting to the DB
 *  
 */
public class Main {
	public static void main(String[] args) throws SQLException {
		EmployeeDBGUI gui = new EmployeeDBGUI();
		EmployeeDB empDB = new EmployeeDB(gui);
	}
}