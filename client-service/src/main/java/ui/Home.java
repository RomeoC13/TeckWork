package ui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Home {
	private String [] element = {"mairie", "service", "pouvooirs", "publics"};
	private JComboBox combox;
	private WindowsMenu newWindow;
	private JFrame myFrame = new JFrame();
	
	
	public Home() {
		myFrame.setVisible(true);
		myFrame.setTitle("page d'accueil");
		myFrame.setSize(500,500);
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocationRelativeTo(null);
		JPanel  panel = (JPanel)myFrame.getContentPane();
		panel.setLayout(new BorderLayout());
		
		combox = new JComboBox(element);
		combox.setMaximumSize(new Dimension(20,20));
		panel.add(BorderLayout.CENTER,combox);
		
		JLabel label = new JLabel("veuillez entrer l'element que vous souhaiter");
		//setSize(50,30);
		panel.add(BorderLayout.NORTH, label);
		
		JButton button = new JButton("Valider");
		button.setSize(50, 50);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (combox.getSelectedIndex() == 0) {
					 newWindow = new WindowsMenu();
					 myFrame.dispose();
				}
					
			}
		});
		panel.add(BorderLayout.SOUTH,button);

	}

	public static void main(String[] args) throws UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(new NimbusLookAndFeel());
		new Home();
	}

}
