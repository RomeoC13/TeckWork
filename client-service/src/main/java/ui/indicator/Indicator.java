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
import java.util.ArrayList;
import java.util.List;

public class Indicator extends JFrame {
	private final Logger log = LoggerFactory.getLogger(Indicator.class.getName());
	JTextField occupationField = new JTextField();
	JTextField itemsField =  new JTextField();
	JTextField equipmentField = new JTextField();
	JTextField sensorField = new JTextField();
	JTextField companyField = new JTextField();
	JTextField energyField = new JTextField();
	JPanel seconJPanel = new JPanel();
	Side_Menu sm;
	private JTextField textField;
	private JTextField titleField;
	private String company_name;
	private DataIndicator data = new DataIndicator();
	protected IndicOption option = new IndicOption();

	public Indicator(String company_name) {
		this.company_name = company_name;
		this.setVisible(true);
		this.setTitle("Indicateurs");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sm = new Side_Menu(company_name);
		JPanel contentPane = (JPanel) this.getContentPane();
		getContentPane().setLayout(new BorderLayout());
		contentPane.add(sm, BorderLayout.WEST);
		contentPane.add(addingAllMenu(), BorderLayout.CENTER);

	}

	private JPanel addingAllMenu() {
		seconJPanel = new JPanel(new BorderLayout());

		seconJPanel.add(optionOFTop(), BorderLayout.NORTH);
		seconJPanel.add(optionOFCentered(), BorderLayout.CENTER);

		return seconJPanel;
	}

	private JPanel optionOFTop() {
		JPanel mainTopPanel = new JPanel(new BorderLayout());

		JPanel topPanel = new JPanel(new FlowLayout());
		topPanel.setPreferredSize(new Dimension(10, 110));
		JButton allInfo = new JButton("information generale");
		allInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			titleField.setText("vous êtes sur les informations génerales des batiments");
				//occupationField.setText(data.getOccupancy());
						/*itemsField.setText(data.getConnectedObject());
						equipmentField.setText(data.getEquipment());*/
				sensorField.setText(data.getSensor());
				companyField.setText(data.getCompany());
				energyField.setText(data.energyConsumption());
			}
		});
		topPanel.add(allInfo);





		JButton infoByCompany = new JButton("information par entreprise");
		infoByCompany.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel pan  = new JPanel(new BorderLayout());
				String request = Client.getSend("requestCompany");
				List test = List.of(request.split("@"));
				JTextField field = new JTextField();
				JComboBox comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						field.setText(comboBox.getSelectedItem().toString());
						titleField.setText("vous êtes sur les informations génerales de l'entreprise "+ field.getText());
					}
				});
				for(Object o: test)
					comboBox.addItem(o);
				pan.add(new JLabel("Veuillez entrer le nom d'une entreprise"), BorderLayout.NORTH);
				pan.add(comboBox, BorderLayout.SOUTH);

				pan.add(field, BorderLayout.CENTER);

                int response = JOptionPane.showConfirmDialog(null, pan, "choix d'une entreprise", JOptionPane.OK_CANCEL_OPTION);
				if(response == JOptionPane.OK_OPTION){
					Client.map.get("CompanyConnectedObject").put("company_name", field.getText());
					itemsField.setText(option.objectCompany());
					Client.map.get("AllEquipmentCompany").put("company_name", field.getText());
					equipmentField.setText(option.equipmentCompany());
					Client.map.get("allSensorCompany").put("company_name", field.getText());
					sensorField.setText(option.sensorCompany());
					Client.map.get("energyConsommationCompany").put("company_name", field.getText());
					energyField.setText(option.energyCompany());
				}else {
					companyField.setText("cancel");
				}
			}


		});
		topPanel.add(infoByCompany);
		JButton infoByBuilding = new JButton("indicateur par batiments");
		infoByBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pan = new JPanel(new BorderLayout());
				String request = Client.getSend("requestBuilding");
				List test = List.of(request.split("@"));
				JTextField field = new JTextField();
				JComboBox comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						field.setText(comboBox.getSelectedItem().toString());
						titleField.setText("vous êtes sur les informations génerales du bâtiment "+ field.getText());
					}
				});


				for (Object o : test)
					comboBox.addItem(o);
				pan.add(new JLabel("Veuillez choisir un batiment"), BorderLayout.NORTH);
				pan.add(comboBox, BorderLayout.SOUTH);

				pan.add(field, BorderLayout.CENTER);

				int response = JOptionPane.showConfirmDialog(null, pan, "choix d'une entreprise", JOptionPane.OK_CANCEL_OPTION);
				//log.info("deuxieme "+field.getText());
				if(response == JOptionPane.OK_OPTION){

//					Client.map.get("rateBuilding").put("building_name", field.getText());
//					occupationField.setText(option.buildingRate());
//					Client.map.get("objectBuilding").put("building_name", field.getText());
//					itemsField.setText(option.objectBuilding());
//					Client.map.get("equipmentBuilding").put("building_name", field.getText());
//					equipmentField.setText(option.equipmentBuilding());
//					Client.map.get("sensorBuilding").put("building_name", field.getText());
//					sensorField.setText(option.sensorBuilding());

					log.info("le client "+Client.map.get("energyBuilding").put("building_name", field.getText()));
					Client.map.get("energyBuilding").put("building_name", field.getText());
					log.info("je vois " + field.getText());
					energyField.setText(option.energyBuilding());
				}
				{
					companyField.setText("cancel");
				}
			}
			});
		topPanel.add(infoByBuilding);
		mainTopPanel.add(topPanel, BorderLayout.NORTH);
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

	private JPanel optionOFCentered() {
		JPanel mainPanel = new JPanel(new FlowLayout());





		//set in a panel all the list of indicators
		JPanel indicatorPanel = new JPanel(new GridLayout(6,1));
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
		mainPanel.add(indicatorPanel);

/********** set in a panel all the list of each indicators result*****************/


		JPanel fieldPanel = new JPanel(new GridLayout(6,1));
		fieldPanel.setPreferredSize(new Dimension(100, 200));
		fieldPanel.add(occupationField);
		fieldPanel.add(itemsField);
		fieldPanel.add(equipmentField);
		fieldPanel.add(sensorField);
		fieldPanel.add(companyField);
		fieldPanel.add(energyField);
		mainPanel.add(fieldPanel);
		return mainPanel;
	}

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new Indicator("company_name");
	}
}
