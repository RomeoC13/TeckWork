package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class WindowsMenu extends JFrame {
	
	
	private JPanel panelTop = new JPanel();
	private JPanel panelLeft = new JPanel();
	private JPanel panelRight = new JPanel();
	private JPanel panelCenter = new JPanel();
	private JPanel panel;
	private Menu menu;
	
	public WindowsMenu() {
		this.setVisible(true);
		this.setTitle("Page d'accueil");
		this.setSize(400,500);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);

		//the general panel
		panel = (JPanel)this.getContentPane();
		panel.setLayout(new BorderLayout());
		
		// the left panel contains the menu
		panel.add(BorderLayout.WEST, optionLeftPanel());
		// the right panel contains 
		panel.add(BorderLayout.EAST,optionRightPanel());
		// the centered panel contains 
		panel.add(BorderLayout.CENTER, optionCenteredPanel());
		
		// the top panel contains 
		panel.add(BorderLayout.NORTH, optionTopPanel());
		//this.setd
		
		
	}

	private JPanel optionCenteredPanel() {
		
		JPanel panelCenter = new JPanel();
		JLabel lab1 = new JLabel("centre");
		panelCenter.add(lab1);
		panelCenter.setBackground(Color.green);
		return panelCenter;
	}
	
	private JPanel optionRightPanel() {
		JPanel panelRight = new JPanel();
		JLabel lab2 = new JLabel("droite");
		panelRight.add(lab2);
		panelRight.setBackground(Color.cyan);
		return panelRight;
	}
	
	private JMenuBar optionLeftPanel() {
		//JPanel panelLeft = new JPanel();
		//JLabel lab3 = new JLabel();
	  	JMenuBar menuBar = new JMenuBar();
    	
    	menuBar.setLayout(new GridLayout(0,1));
    	// first menu
    	JMenu menu1 = new JMenu("réservation");
    	menuBar.add(menu1);
    	//second menu
    	JMenu menu2 = new JMenu("consulter les réservations");
    	menuBar.add(menu2);
		//panelLeft.add(lab3);
		//panelLeft.setBackground(Color.blue);
		return menuBar;
	}
	
	private JPanel optionTopPanel() {
		JPanel panelTop = new JPanel();
		JLabel lab4 = new JLabel();
		
		lab4.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        lab4.setText("<html><body><font color='blanc'>Entreprise: Tech-Work </body></html>");
        panelTop.add(lab4);
       
		panelTop.setBackground(Color.white);
		return panelTop;
	}
	
}
