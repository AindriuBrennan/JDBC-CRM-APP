import gui.EmployeeDBGUI;
import utils.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDB {
	private EmployeeDBGUI gui;

	private String dbTableName = "employee";
	private String pps = "0";
	private String name = "";
	private String address = "";
	private String gender = "";
	private String dob = "";
	private double wage = 0.00;

	private DBConnector conn = new DBConnector();

	public EmployeeDB(EmployeeDBGUI gui) throws SQLException {
		this.gui = gui;
		try {
			conn.getConnection();
			System.out.println("Connected to DB");
		} catch (SQLException e) {
			System.out.println("Error in DB connection");
			e.printStackTrace();
		}
		conn.getDB();
		this.buttonListeners(gui);
	}

	/**
	 * add employee using Java PreparedStatement function. helps protect against SQL
	 * injection
	 */
	private void addEmployee() {
		try {
			getInput();
			String insertStatement = "INSERT INTO " + dbTableName
					+ " (pps, name, address, gender, dob, wage) VALUES(?,?,?,?,?,?)";
			PreparedStatement statement = conn.getConnection().prepareStatement(insertStatement);
			statement.setString(1, pps);
			statement.setString(2, name);
			statement.setString(3, address);
			statement.setString(4, gender);
			statement.setString(5, dob);
			statement.setDouble(6, wage);
			statement.executeUpdate();
			System.out.println("Employee added");
		} catch (SQLException e) {
			System.out.println("Error, failed to insert Employee");
			e.printStackTrace();
		}
	}

	/**
	 * Search for an employee in the data base by name and set the text fields with
	 * the result
	 * 
	 */

	private void searchByName() {
		try {
			getNameInput();
			String searchNameStatement = "SELECT * from employee WHERE name = ?";
			PreparedStatement statement = conn.getConnection().prepareStatement(searchNameStatement);
			statement.setString(1, name);
			ResultSet data = statement.executeQuery();
			while (data.next()) {
				data.getString(1);
				setTextFields(data);
			}
			System.out.println("Found Employee: " + name);
		} catch (SQLException e) {
			System.out.println("Error, failed to find Employee, check you have the right name");
			e.printStackTrace();
		}
	}

	/**
	 * Search for employee by wage and set the text fields with the result
	 */

	private void searchByWage() {
		try {
			getWageInput();
			String searchWageStatement = "SELECT * from employee WHERE wage = ?";
			PreparedStatement statement = conn.getConnection().prepareStatement(searchWageStatement);
			statement.setDouble(1, wage);
			ResultSet data = statement.executeQuery();
			while (data.next()) {
				data.getDouble(1);
				setTextFields(data);
			}

		} catch (SQLException e) {
			System.out.println("Error, failed to find Employee, check you have the right wage entered");
			e.printStackTrace();
		}
	}

	/*
	 * Update employees in the database using the pps number as the identifier
	 */
	private void updateEmployee() {
		try {
			getInput();
			String updateStatement = "UPDATE employee SET name = ?, address = ?, gender = ?, dob = ?, wage = ? WHERE pps = ?";
			PreparedStatement statement = conn.getConnection().prepareStatement(updateStatement);
			statement.setString(1, name);
			statement.setString(2, address);
			statement.setString(3, gender);
			statement.setString(4, dob);
			statement.setDouble(5, wage);
			statement.setString(6, pps);
			statement.executeUpdate();
			System.out.println("Employee Updated");
		} catch (SQLException e) {
			System.out.println("Error, failed to update Employee");
			e.printStackTrace();
		}
	}

	/*
	 * Delete an employee from the Database
	 */
	private void deleteEmployee() {
		try {
			getPPS();
			String deleteStatement = "DELETE FROM employee WHERE pps =?";
			PreparedStatement statement = conn.getConnection().prepareStatement(deleteStatement);
			statement.setString(1, pps);
			int row = statement.executeUpdate();
			System.out.println("Deleted Employee " + name + pps);
		} catch (SQLException e) {
			System.out.println("Failed to delete employee");
			e.printStackTrace();
		}
	}

	private void setTextFields(ResultSet data) throws SQLException {
		gui.getName().setText(data.getString("name"));
		gui.getPpsNumber().setText(data.getString("pps"));
		gui.getAddress().setText(data.getString("address"));
		gui.getDateOfBirth().setText(data.getString("dob"));
		gui.getGender().setText(data.getString("gender"));
		gui.getWage().setText(data.getString("wage"));
	}

	/*
	 * Clear the text fields of any data
	 */
	private void clearTextFields() {
		gui.getPpsNumber().setText("");
		gui.getName().setText("");
		gui.getAddress().setText("");
		gui.getGender().setText("");
		gui.getDateOfBirth().setText("");
		gui.getWage().setText("");

	}

	/*
	 * ActionListeners for the GUI Buttons
	 */

	private void buttonListeners(EmployeeDBGUI gui) {
		gui.getAddEmployee().addActionListener(e -> addEmployee());
		gui.getDeleteEmployee().addActionListener(e -> deleteEmployee());
		gui.getClearFields().addActionListener(e -> clearTextFields());
		gui.getUpdateEmployee().addActionListener(e -> updateEmployee());
		gui.getSearchByName().addActionListener(e -> searchByName());
		gui.getSearchByWage().addActionListener(e -> searchByWage());
	}

	/**
	 * get the TextField input values
	 */

	private void getInput() {
		pps = gui.getPpsNumber().getText();
		name = gui.getName().getText();
		address = gui.getAddress().getText();
		gender = gui.getGender().getText();
		dob = gui.getDateOfBirth().getText();
		String wageInput = gui.getWage().getText();
		wage = Double.parseDouble(wageInput);

	}

	/**
	 * Three helper functions for getting individual inputs
	 */

	private void getNameInput() {
		name = gui.getSearchByNameText().getText();
	}

	private void getPPS() {
		pps = gui.getPpsNumber().getText();
	}

	private void getWageInput() {
		String wageInput = gui.getSearchByWageText().getText();
		wage = Double.parseDouble(wageInput);
	}

	/**
	 * Run a SQL command which does not return a recordset:
	 * CREATE/INSERT/UPDATE/DELETE/DROP/etc.
	 * 
	 * @throws SQLException If something goes wrong
	 */
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(command); // This will throw a SQLException if it fails
			return true;
		} finally {

			// This will run whether we throw an exception or not
			if (stmt != null) {
				stmt.close();
			}
		}
	}

}
