package ui.indicator;

import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import client.Client;
import ui.Side_Menu;
import ui.WindowsMenu;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class Indicator extends JFrame {
	
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
				String response1 = request1.toString();
				occupationField.setText(response1);

				String request2 = Client.getSend("connectedObject");
				String response2 = request2.toString();
				itemsField.setText(response2);

				String request3 = Client.getSend("AllEquipment");
				String response3= request3.toString();
				equipmentField.setText(response3);

				String request4 = Client.getSend("allSensor");
				String response4 = request4.toString();
				equipmentField.setText(response4);

				String request5 = Client.getSend("AllCompany");
				String response5 = request1.toString();
				companyField.setText(response5);

				String request6 = Client.getSend("energyConsommation");
				String response6  = request6.toString();
				equipmentField.setText(response6);

			}
		});
		topPanel.add(allInfo);





		JButton infoByCompany = new JButton("information par entreprise");
		infoByCompany.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel pan  = new JPanel(new BorderLayout());
				JComboBox jComboBox = new JComboBox();
				String request = Client.getSend("comboxNameCompany");

				List<String> entreprise = new ArrayList<>();
					entreprise.add(request.toString());
				jComboBox.addItem(entreprise);
				pan.add(new JLabel("Veuillez entrer le nom d'une entreprise"), BorderLayout.NORTH);
				pan.add(jComboBox, BorderLayout.SOUTH);

				pan.add(new JTextField(), BorderLayout.CENTER);

                JOptionPane.showConfirmDialog(null, pan, "choix d'une entreprise", JOptionPane.OK_CANCEL_OPTION);

				
			}
		});
		topPanel.add(infoByCompany);
		JButton infoByBuilding = new JButton("indicateur par batiments");
		infoByBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel pan  = new JPanel(new BorderLayout());
				pan.add(new JLabel("Veuillez entrer le nom du batiments"), BorderLayout.NORTH);
			//	pan.add(new JButton("valider"),BorderLayout.SOUTH);
				pan.add(new JTextField(), BorderLayout.CENTER);

                JOptionPane.showConfirmDialog(null, pan, "choix d'un batiment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
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
