package ui;

import javax.swing.*;
import javax.swing.JSpinner.ListEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class Side_Menu extends JPanel {
	private final JButton home = new JButton("Home");
	private final JButton card = new JButton("Card");
	private final JButton mapping = new JButton("Mapping");
	private final JButton indicator = new JButton("Indicator");

	
	

    public Side_Menu() {
        
        this.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(new Color(68, 114, 196));
        this.setPreferredSize(new Dimension(178, 500));
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        home.setBackground(SystemColor.inactiveCaption);
        home.setFont(new Font("Sylfaen", Font.PLAIN, 14));
        home.setForeground(SystemColor.desktop);
        home.setPreferredSize(new Dimension(170, 25));
        home.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        home.setVerticalAlignment(SwingConstants.TOP);
        home.setAlignmentY(10.0f);
        home.setAlignmentX(10.0f);
        
        add(home);
        card.setFont(new Font("Sylfaen", Font.PLAIN, 14));
        card.setForeground(SystemColor.activeCaptionText);
        card.setBackground(SystemColor.inactiveCaption);
        card.setPreferredSize(new Dimension(170, 23));
        card.setVerticalAlignment(SwingConstants.TOP);
        card.setAlignmentY(10.0f);
        card.setAlignmentX(10.0f);
        
        add(card);
        mapping.setFont(new Font("Sylfaen", Font.PLAIN, 14));
        mapping.setForeground(SystemColor.activeCaptionText);
        mapping.setBackground(SystemColor.inactiveCaption);
        mapping.setPreferredSize(new Dimension(170, 23));
        mapping.setVerticalAlignment(SwingConstants.TOP);
        mapping.setAlignmentY(10.0f);
        mapping.setAlignmentX(10.0f);
        
        add(mapping);
        indicator.setFont(new Font("Sylfaen", Font.PLAIN, 14));
        indicator.setForeground(SystemColor.desktop);
        indicator.setBackground(SystemColor.inactiveCaption);
        indicator.setPreferredSize(new Dimension(170, 23));
        indicator.setVerticalAlignment(SwingConstants.TOP);
        indicator.setAlignmentY(10.0f);
        indicator.setAlignmentX(10.0f);
        
        add(indicator);
//        label.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
//        label.setText("<html><body><font color='blanc'>Entreprise: Tech-Work </body></html>");
    }




	public JButton getHome() {
		return home;
	}




	public JButton getCard() {
		return card;
	}




	public JButton getMapping() {
		return mapping;
	}




	public JButton getIndicator() {
		return indicator;
	}
	




    
    
}
