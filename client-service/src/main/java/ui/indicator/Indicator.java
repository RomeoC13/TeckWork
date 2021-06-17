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
		JButton allInfo = new JButton("information generale");
		allInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String request1 = Client.getSend("rateOccupation");
				occupationField.setText(request1);

				String request2 = Client.getSend("connectedObject");
				itemsField.setText(request2);

				String request3 = Client.getSend("AllEquipment");
				equipmentField.setText(request3);

				String request4 = Client.getSend("allSensor");
				equipmentField.setText(request4);

				String request5 = Client.getSend("AllCompany");
				companyField.setText(request5);

				String request6 = Client.getSend("energyConsommation");
				equipmentField.setText(request6);

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
				JTextField text = new JTextField();
				JComboBox comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String item = comboBox.getSelectedItem().toString();
						text.setText(item);
					}
				});
				for(Object o: test)
					comboBox.addItem(o);
				pan.add(new JLabel("Veuillez entrer le nom d'une entreprise"), BorderLayout.NORTH);
				pan.add(comboBox, BorderLayout.SOUTH);

				pan.add(text, BorderLayout.CENTER);

                int response = JOptionPane.showConfirmDialog(null, pan, "choix d'une entreprise", JOptionPane.OK_CANCEL_OPTION);
				if(response == JOptionPane.OK_OPTION){
					companyField.setText("ok");
					String request1 = Client.getSend("rateOccupation");
					occupationField.setText(request1);

					String request2 = Client.getSend("connectedObject");
					itemsField.setText(request2);

					String request3 = Client.getSend("AllEquipment");
					equipmentField.setText(request3);

					String request4 = Client.getSend("allSensor");
					equipmentField.setText(request4);

					String request5 = Client.getSend("AllCompany");
					companyField.setText(request5);

					String request6 = Client.getSend("energyConsommation");
					equipmentField.setText(request6);
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
				JTextField text = new JTextField();
				JComboBox comboBox = new JComboBox();
				comboBox.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String item = comboBox.getSelectedItem().toString();
						text.setText(item);
					}
				});
				for (Object o : test)
					comboBox.addItem(o);
				pan.add(new JLabel("Veuillez choisir un batiment"), BorderLayout.NORTH);
				pan.add(comboBox, BorderLayout.SOUTH);

				pan.add(text, BorderLayout.CENTER);

				int response = JOptionPane.showConfirmDialog(null, pan, "choix d'une entreprise", JOptionPane.OK_CANCEL_OPTION);
				if(response == JOptionPane.OK_OPTION){
					companyField.setText("ok");
					String request1 = Client.getSend("rateOccupation");
					occupationField.setText(request1);

					String request2 = Client.getSend("connectedObject");
					itemsField.setText(request2);

					String request3 = Client.getSend("AllEquipment");
					equipmentField.setText(request3);

					String request4 = Client.getSend("allSensor");
					equipmentField.setText(request4);

					String request5 = Client.getSend("AllCompany");
					companyField.setText(request5);

					String request6 = Client.getSend("energyConsommation");
					equipmentField.setText(request6);
				}else {
					companyField.setText("cancel");
				}
			}
			});
		topPanel.add(infoByBuilding);
		mainTopPanel.add(topPanel, BorderLayout.NORTH);
		JPanel titlePane = new JPanel();
		titleField = new JTextField();
		titlePane.add(titleField);
		titleField.setColumns(10);
		titlePane.setPreferredSize(new Dimension(100,100));
		topPanel.add(titlePane);
		
		
		mainTopPanel.add(titlePane, BorderLayout.SOUTH);
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
		JLabel connectedItems = new JLabel("Objets connect�s");
		indicatorPanel.add(connectedItems);
		JLabel equipment = new JLabel("Nombre d��quipements");
		indicatorPanel.add(equipment);
		JLabel sensor = new JLabel("Capteurs install�s");
		indicatorPanel.add(sensor);
		JLabel company = new JLabel("Nombre d�entreprise");
		indicatorPanel.add(company);
		JLabel energy = new JLabel("Consommation �nerg�tique");
		indicatorPanel.add(energy);
		mainPanel.add(indicatorPanel);
		
	
		
		// set in a panel all the list of each indicators result
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
