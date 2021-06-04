package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import ui.indicator.Indicator;
import userIHM.WindowsMapping;

public class Side_Menu extends JPanel {
	private final JButton home = new JButton("Home");
	private final JButton card = new JButton("Card");
	private final JButton mapping = new JButton("Mapping");
	private final JButton indicator = new JButton("Indicator");
	private final JLabel companyLabel = new JLabel();
	private final JSeparator separator = new JSeparator();
	private final JPanel panel = new JPanel();
	private final JButton deconnexion = new JButton("D\u00E9connexion");
	

    public Side_Menu() {
        
        this.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(new Color(68, 114, 196));
        this.setPreferredSize(new Dimension(222, 500));
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        companyLabel.setBackground(Color.WHITE);
        companyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        companyLabel.setPreferredSize(new Dimension(200, 100));
        companyLabel.setForeground(Color.WHITE);
        companyLabel.setFont(new Font("Serif", Font.BOLD, 20));
        companyLabel.setText("Teck-work");
        		//+ "<html><body><font color='blanc'>Tech-Work</body></html>\"
        add(companyLabel);
        separator.setOpaque(true);
        
        separator.setBounds(new Rectangle(10, 10, 10, 10));
        separator.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        separator.setBackground(Color.BLACK);
        separator.setAlignmentX(20.0f);
        separator.setAlignmentY(Component.TOP_ALIGNMENT);
        separator.setPreferredSize(new Dimension(215, 3));
        separator.setForeground(Color.BLACK);
        this.add(separator);
        
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
        card.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new Card();
				
			}
		});
        add(card);
        
        mapping.setFont(new Font("Sylfaen", Font.PLAIN, 14));
        mapping.setForeground(SystemColor.activeCaptionText);
        mapping.setBackground(SystemColor.inactiveCaption);
        mapping.setPreferredSize(new Dimension(170, 23));
        mapping.setVerticalAlignment(SwingConstants.TOP);
        mapping.setAlignmentY(10.0f);
        mapping.setAlignmentX(10.0f);


        mapping.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               // if((JButton)e.getSource() == mapping)
                   // new WindowsMapping();

            }

        });
        
        add(mapping);
        
        indicator.setFont(new Font("Sylfaen", Font.PLAIN, 14));
        indicator.setForeground(SystemColor.desktop);
        indicator.setBackground(SystemColor.inactiveCaption);
        indicator.setPreferredSize(new Dimension(170, 23));
        indicator.setVerticalAlignment(SwingConstants.TOP);
        indicator.setAlignmentY(10.0f);
        indicator.setAlignmentX(10.0f);
        indicator.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if((JButton)e.getSource() == indicator)
        			new Indicator();
        		
        	}
        	
        });
        add(indicator);
        panel.setPreferredSize(new Dimension(200, 265));
        
        
        panel.setBackground(new Color(68, 114, 196));
        panel.setLayout(new BorderLayout());
        deconnexion.setLocation(new Point(10, 10));
        deconnexion.setVerticalAlignment(SwingConstants.TOP);
        deconnexion.setPreferredSize(new Dimension(170, 23));
        deconnexion.setForeground(Color.BLACK);
        deconnexion.setFont(new Font("Sylfaen", Font.PLAIN, 14));
        deconnexion.setBackground(SystemColor.inactiveCaption);
        deconnexion.setAlignmentY(10.0f);
        deconnexion.setAlignmentX(10.0f);
        panel.add(deconnexion,BorderLayout.SOUTH);
        this.add(panel);
    }

    
}
