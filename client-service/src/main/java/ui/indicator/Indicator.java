package ui.indicator;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import client.Client;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ui.Side_Menu;
import ui.WindowsMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

/************
 * this is my frame for indicator here we see
 *  the fonction of the indicator and we get all the view panel
 *  for all indicators
 */
public class Indicator extends JFrame {
	private final Logger log = LoggerFactory.getLogger(Indicator.class.getName());
	JTextField occupationField = new JTextField();
	JTextField itemsField =  new JTextField();
	JTextField equipmentField = new JTextField();
	JTextField sensorField = new JTextField();
	JTextField companyField = new JTextField();
	JTextField energyField = new JTextField();
	JTextField floorField = new JTextField();
	JTextField batimentField = new JTextField();
	JPanel seconJPanel = new JPanel();
	Side_Menu sm;
	private JTextField textField;
	private JTextField titleField;
	private String company_name;
	private DataIndicator data = new DataIndicator();
	protected IndicOption option = new IndicOption();
	protected JButton allInfo;
	protected JButton infoByCompany;
	protected JButton infoByBuilding;
	protected JButton cleaner;


	public Indicator(String company_name) {
		this.company_name = company_name;
		this.setVisible(true);
		this.setTitle("Indicateurs");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sm = new Side_Menu(company_name, this);
		JPanel contentPane = (JPanel) this.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(sm, BorderLayout.WEST);
		contentPane.add(addingAllMenu(), BorderLayout.CENTER);

	}
/******* this is the main panel which add the top and bottom panel******************/
	private JPanel addingAllMenu() {
		seconJPanel = new JPanel(new BorderLayout());

		seconJPanel.add(optionOFTop(), BorderLayout.NORTH);
		seconJPanel.add(optionOFCentered(), BorderLayout.CENTER);

		return seconJPanel;
	}



/****************** this is the top panel which contain all the bottom of indicator ************/
	private JPanel optionOFTop() {
		JPanel mainTopPanel = new JPanel(new BorderLayout());

		JPanel topPanel = new JPanel(new GridLayout(2,2));
		topPanel.setPreferredSize(new Dimension(10, 110));

/********* set button for implementing the general indicators of all the building and company  ***********/
		allInfo = new JButton("information generale");
		allInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				titleField.setText("Vous êtes sur les informations générales de toute la location ");
				occupationField.setText(data.getOccupancy());
				itemsField.setText(data.getConnectedObject());
				equipmentField.setText(data.getEquipment());
				sensorField.setText(data.getSensor());
				companyField.setText(data.getCompany());
				energyField.setText(data.energyConsumption());

			}
		});
		topPanel.add(allInfo);




/************** set a button to implement the indicator of each company in the location *************/

		infoByCompany = new JButton("information par entreprise");
		infoByCompany.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel pan  = new JPanel(new BorderLayout());
				JTextField field = new JTextField();


				String request = Client.getSend("requestCompany");
				/**sorting my list of building*********/
				String[] sortRequest = request.split("@");
				Arrays.sort(sortRequest);

				/***** adding to my combobox**********/
				JComboBox comboBox = new JComboBox();
				for (Object o : sortRequest )
					comboBox.addItem(o);
				comboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {// setting in this field the selected item from
						// my combobox
						field.setText(comboBox.getSelectedItem().toString());

					}
				});
				pan.add(new JLabel("Veuillez entrer le nom d'une entreprise"), BorderLayout.NORTH);
				pan.add(comboBox, BorderLayout.SOUTH);


				pan.add(field, BorderLayout.CENTER);


/*********************** using a joption pane which will give us a choice to choose the company that we wanted ********/

                int response = JOptionPane.showConfirmDialog(null, pan, "choix d'une entreprise", JOptionPane.OK_CANCEL_OPTION);
				if(response == JOptionPane.OK_OPTION){
					titleField.setText("vous êtes sur les informations génerales de l'entreprise : "+field.getText());
					Client.map.get("CompanyConnectedObject").put("company_name", field.getText());
					itemsField.setText(option.objectCompany());
					Client.map.get("AllEquipmentCompany").put("company_name", field.getText());
					equipmentField.setText(option.equipmentCompany());
					Client.map.get("allSensorCompany").put("company_name", field.getText());
					sensorField.setText(option.sensorCompany());
					Client.map.get("usedBatiment").put("company_name", field.getText());
					batimentField.setText(option.usedBatiments());
				}else if (response == JOptionPane.CANCEL_OPTION) {
					titleField.setText("vous n'avez pas choisi d'entreprise");
					companyField.removeAll();
					itemsField.removeAll();
					equipmentField.removeAll();
					sensorField.removeAll();
					energyField.removeAll();
					occupationField.removeAll();
					batimentField.removeAll();

				}
			}


		});
		topPanel.add(infoByCompany);



	/******************** setting a building button for implementing the indicator	of each building ***********/
		infoByBuilding = new JButton("indicateur par batiments");
		infoByBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pan = new JPanel(new BorderLayout());
				JTextField field = new JTextField();


				String request = Client.getSend("requestBuilding");
				/**sorting my list of building*********/
				String[] sortRequest = request.split("@");
				Arrays.sort(sortRequest);

				/***** adding to my combobox**********/
				JComboBox comboBox = new JComboBox();
				for (Object o : sortRequest )
					comboBox.addItem(o);
				comboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {

						field.setText(comboBox.getSelectedItem().toString());
					}
				});
				pan.add(new JLabel("Veuillez choisir un batiment"), BorderLayout.NORTH);
				pan.add(comboBox, BorderLayout.SOUTH);

				pan.add(field, BorderLayout.CENTER);

/***************     using a joption pane to display all the building ***************/
				int response = JOptionPane.showConfirmDialog(null, pan, "choix d'un bâtiment", JOptionPane.OK_CANCEL_OPTION);

				if(response == JOptionPane.OK_OPTION){
					titleField.setText("vous êtes sur les informations génerales du bâtiment: " +field.getText());
					Client.map.get("rateBuilding").put("building_name", field.getText());
					occupationField.setText(option.buildingRate());
					Client.map.get("objectBuilding").put("building_name", field.getText());
					itemsField.setText(option.objectBuilding());
					Client.map.get("equipmentBuilding").put("building_name", field.getText());
					equipmentField.setText(option.equipmentBuilding());
					Client.map.get("sensorBuilding").put("building_name", field.getText());
					sensorField.setText(option.sensorBuilding());
					Client.map.get("companyBuilding").put("building_name", field.getText());
					companyField.setText(option.companyInBuilding());
					Client.map.get("energyBuilding").put("building_name", field.getText());
					energyField.setText(option.energyBuilding());
					Client.map.get("allFloor").put("building_name", field.getText());
					floorField.setText(option.allFloor());
				}else {
					titleField.setText("vous n'avez pas choisi de bâtiments");
					companyField.removeAll();
					itemsField.removeAll();
					equipmentField.removeAll();
					sensorField.removeAll();
					energyField.removeAll();
					occupationField.removeAll();
				}
			}
			});
		topPanel.add(infoByBuilding);
		/************ cleaner button is simply to
		 * to help us cleaning the field text
		 * if we wanted to change indicator function for another one
		 * *******************************/

		cleaner = new JButton("effaceur");
		cleaner.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				titleField.setText("vous avez effacé toutes les données des indicateurs");
				companyField.setText("");
				itemsField.setText("");
				equipmentField.setText("");
				sensorField.setText("");
				energyField.setText("");
				occupationField.setText("");
				batimentField.setText("");
				floorField.setText("");

			}
		});
		topPanel.add(cleaner);

		mainTopPanel.add(topPanel, BorderLayout.NORTH);
/****** title field is just to display the information about the object that you are viewing on this time
 * like name company, or building name
 *
 * *****/
		titleField = new JTextField();
		titleField.setBorder(null);
		titleField.setEditable(false);
		titleField.setBackground(Color.LIGHT_GRAY);
		titleField.setFont(new Font("Century Gothic", Font.BOLD, 15));
		titleField.setPreferredSize(new Dimension(13, 9));
	

		
		
		mainTopPanel.add(titleField, BorderLayout.CENTER);
		mainTopPanel.setPreferredSize(new Dimension(100,200));
		return mainTopPanel;
	}

/******************** this is the bottom panel which contains the list of indicator *************/
	private JPanel optionOFCentered() {
		JPanel mainPanel = new JPanel(new FlowLayout());
		//set in a panel all the list of indicators
		JPanel indicatorPanel = new JPanel(new GridLayout(8,1));
		indicatorPanel.setPreferredSize(new Dimension(200, 200));
		JLabel occupation = new JLabel("Taux d'occupation");
		indicatorPanel.add(occupation);
		JLabel connectedItems = new JLabel("Objets connectés");
		indicatorPanel.add(connectedItems);
		JLabel equipment = new JLabel("Nombre d'equipements");
		indicatorPanel.add(equipment);
		JLabel sensor = new JLabel("Capteurs installés");
		indicatorPanel.add(sensor);
		JLabel company = new JLabel("Nombre d'entreprise");
		indicatorPanel.add(company);
		JLabel energy = new JLabel("Consommation énergétique");
		indicatorPanel.add(energy);
		JLabel floorPanel = new JLabel("Nombre d'étages");
		indicatorPanel.add(floorPanel);
		JLabel batimentPanel = new JLabel("Batiment utilisé");
		indicatorPanel.add(batimentPanel);
		mainPanel.add(indicatorPanel);

/********** set in a panel all the list of each indicators result*****************/


		JPanel fieldPanel = new JPanel(new GridLayout(8,1));
		fieldPanel.setPreferredSize(new Dimension(100, 200));
		fieldPanel.add(occupationField);
		fieldPanel.add(itemsField);
		fieldPanel.add(equipmentField);
		fieldPanel.add(sensorField);
		fieldPanel.add(companyField);
		fieldPanel.add(energyField);
		fieldPanel.add(floorField);
		fieldPanel.add(batimentField);
		mainPanel.add(fieldPanel);
		return mainPanel;
	}

}
