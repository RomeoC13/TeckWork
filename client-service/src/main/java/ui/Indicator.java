package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

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

	public Indicator() {
		this.setVisible(true);
		this.setTitle("Indicateurs");
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sm = new Side_Menu();
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
		JPanel topPanel = new JPanel(new FlowLayout());
		JButton allInfo = new JButton("information génerale");
		topPanel.add(allInfo);
		JButton infoByCompany = new JButton("information par entreprise");
		infoByCompany.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = null;
				
				
			}
		});
		topPanel.add(infoByCompany);
		JButton infoByBuilding = new JButton("indicateur par batiments");
		infoByBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		topPanel.add(infoByBuilding);
		return topPanel;
	}
	
	private JPanel optionOFCentered() {
		JPanel mainPanel = new JPanel(new FlowLayout());
		
//		//a new panel for title option
//		JPanel titlePane = new JPanel();
//		titleField = new JTextField();
//		titlePane.add(titleField);
//		titleField.setColumns(10);
//		mainPanel.add(titlePane);
//		
		

		//set in a panel all the list of indicators
		JPanel indicatorPanel = new JPanel(new GridLayout(6,1));
		indicatorPanel.setPreferredSize(new Dimension(200, 200));
		JLabel occupation = new JLabel("Taux d'occupation");
		indicatorPanel.add(occupation);
		JLabel connectedItems = new JLabel("Objets connectés");
		indicatorPanel.add(connectedItems);
		JLabel equipment = new JLabel("Nombre d’équipements");
		indicatorPanel.add(equipment);
		JLabel sensor = new JLabel("Capteurs installés");
		indicatorPanel.add(sensor);
		JLabel company = new JLabel("Nombre d’entreprise");
		indicatorPanel.add(company);
		JLabel energy = new JLabel("Consommation énergétique");
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

}
