package ui;

import javax.swing.*;
import javax.swing.JSpinner.ListEditor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Side_Menu extends JPanel {
	protected JButton home = new JButton("Home");
	protected JButton mapping = new JButton("Mapping");
	protected JButton card = new JButton("Card");;
	protected JButton indicator = new JButton("Indicator");

	
	public JButton getHome() {
		return home;
	}


	public void setHome(JButton home) {
		this.home = home;
	}


	public JButton getMapping() {
		return mapping;
	}


	public void setMapping(JButton mapping) {
		this.mapping = mapping;
	}


	public JButton getCard() {
		return card;
	}


	public void setCard(JButton card) {
		this.card = card;
	}

	public JButton getIndicator() {
		return indicator;
	}
	
	public void setIndicator(JButton indicator) {
		this.indicator = indicator;
	}

    public Side_Menu() {
        //JLabel label = new JLabel();
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
       
        home.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				indicatorListener(e);
				
			}
		});
        this.add(home);
        this.add(mapping);
        this.add(card);
        this.add(indicator);
        
        this.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(new Color(68, 114, 196));
        this.setPreferredSize(new Dimension(200, 100));
//        label.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
//        label.setText("<html><body><font color='blanc'>Entreprise: Tech-Work </body></html>");
    }
    

    
    private void indicatorListener (ActionEvent e) {
    	System.out.println("je suis la");
    }
	




    
    
}
