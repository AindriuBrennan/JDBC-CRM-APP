package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class EmployeeDBGUI {
	JFrame mainWindow = new JFrame();

	public JButton addEmployee = new JButton("Add");
	public JButton deleteEmployee = new JButton("Delete");
	public JButton updateEmployee = new JButton("Update");
	public JButton clearFields = new JButton("Clear Fields");
	
	public JButton searchByName = new JButton("Search");
	public JButton searchByWage = new JButton("Search");

	private JTextField name = new JTextField();
	private JTextField address = new JTextField();

	private JTextField ppsNumber = new JTextField();
	private JTextField dateOfBirth = new JTextField();
	private JTextField wage = new JTextField();
	private JTextField gender = new JTextField();
	private JTextField searchByNameText = new JTextField();
	private JTextField searchByWageText = new JTextField();

	public EmployeeDBGUI() {
		prepareGui();

	}

	public void prepareGui() {

		// add all the fields with label and textFields
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(12, 2));

		mainPanel.add(new JLabel("Employee Name"));
		mainPanel.add(name);

		mainPanel.add(new JLabel("Employee Address"));
		mainPanel.add(address);

		mainPanel.add(new JLabel("PPS No."));
		mainPanel.add(ppsNumber);

		mainPanel.add(new JLabel("Date Of Birth"));
		mainPanel.add(dateOfBirth);

		mainPanel.add(new JLabel("Employe wage"));
		mainPanel.add(wage);

		mainPanel.add(new JLabel("Employee Gender"));
		mainPanel.add(gender);

		// fake label for white space
		mainPanel.add(new JLabel(""));

		// add a row of buttons under fields
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 5));
		buttonPanel.add(addEmployee);
		buttonPanel.add(deleteEmployee);
		buttonPanel.add(updateEmployee);
		buttonPanel.add(clearFields);
		
		mainPanel.add(buttonPanel);

		// fake label for white space
		mainPanel.add(new JLabel(""));
		mainPanel.add(new JLabel(""));

		// create search row one
		JPanel searchPanelOne = new JPanel();
		searchPanelOne.setLayout(new GridLayout());
		searchPanelOne.add(new JLabel("Search by Name"));
		searchPanelOne.add(searchByNameText);
		searchPanelOne.add(searchByName);
		mainPanel.add(searchPanelOne);

		// search row two
		JPanel searchPanelTwo = new JPanel();
		searchPanelTwo.setLayout(new GridLayout());
		searchPanelTwo.add(new JLabel("Search by Wage"));
		searchPanelTwo.add(searchByWageText);
		searchPanelTwo.add(searchByWage);
		mainPanel.add(searchPanelTwo);

		// main window
		mainWindow = new JFrame("Employee Database Management");
		mainWindow.setSize(1000, 500);
		mainWindow.setLayout(new GridLayout(2, 1));
		mainWindow.setVisible(true);
		mainWindow.add(mainPanel);

		mainWindow.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

	}

	// getters and setters for the Buttons and TextFields that will be used in
	// application functions

	public JButton getAddEmployee() {
		return addEmployee;
	}

	public void setAddEmployee(JButton addEmployee) {
		this.addEmployee = addEmployee;
	}

	public JButton getDeleteEmployee() {
		return deleteEmployee;
	}

	public void setDeleteEmployee(JButton deleteEmployee) {
		this.deleteEmployee = deleteEmployee;
	}

	public JButton getUpdateEmployee() {
		return updateEmployee;
	}

	public void setUpdateEmployee(JButton updateEmployee) {
		this.updateEmployee = updateEmployee;
	}

	public JButton getClearFields() {
		return clearFields;
	}

	public void setClearFields(JButton clearFields) {
		this.clearFields = clearFields;
	}

	
	public JButton getSearchByName() {
		return searchByName;
	}

	public void setSearchByName(JButton searchByName) {
		this.searchByName = searchByName;
	}

	public JButton getSearchByWage() {
		return searchByWage;
	}

	public void setSearchByWage(JButton searchByWage) {
		this.searchByWage = searchByWage;
	}

	public JTextField getName() {
		return name;
	}

	public void setName(JTextField name) {
		this.name = name;
	}

	public JTextField getAddress() {
		return address;
	}

	public void setAddress(JTextField address) {
		this.address = address;
	}

	public JTextField getPpsNumber() {
		return ppsNumber;
	}

	public void setPpsNumber(JTextField ppsNumber) {
		this.ppsNumber = ppsNumber;
	}

	public JTextField getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(JTextField dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public JTextField getWage() {
		return wage;
	}

	public void setWage(JTextField wage) {
		this.wage = wage;
	}

	public JTextField getGender() {
		return gender;
	}

	public void setGender(JTextField gender) {
		this.gender = gender;
	}

	public JTextField getSearchByNameText() {
		return searchByNameText;
	}

	public void setSearchByNameText(JTextField searchByNameText) {
		this.searchByNameText = searchByNameText;
	}

	public JTextField getSearchByWageText() {
		return searchByWageText;
	}

	public void setSearchByWageText(JTextField searchByWageText) {
		this.searchByWageText = searchByWageText;
	}

}
