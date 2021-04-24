package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Indicator extends JFrame {

	JPanel seconJPanel = new JPanel();
	Side_Menu sm;

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
		JButton infoByCompany = new JButton("information entreprise");
		topPanel.add(infoByCompany);
		JButton infoByBuilding = new JButton("indicateur de building");
		infoByBuilding.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		topPanel.add(infoByBuilding);
		return topPanel;
	}
	
	private JPanel optionOFCentered() {
		JPanel indicatorPanel = new JPanel();
		indicatorPanel.setLayout(new GridLayout(6,1));
		JLabel occupation = new JLabel("Taux d'occupation");
		indicatorPanel.add(occupation);
		JLabel sensor = new JLabel("Capteurs installés");
		indicatorPanel.add(sensor);
		JLabel connectedItems = new JLabel("Objets connectés");
		indicatorPanel.add(connectedItems);
		JLabel equipment = new JLabel("Nombre d’équipements");
		indicatorPanel.add(equipment);
		JLabel company = new JLabel("Nombre d’entreprise");
		indicatorPanel.add(company);
		JLabel energy = new JLabel("Consommation énergétique");
		indicatorPanel.add(energy);
		
		return indicatorPanel;
	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new Indicator();
	}

}
