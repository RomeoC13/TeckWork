package ui;

import javax.swing.*;
import java.awt.*;

public class Side_Menu extends JPanel {



    public Side_Menu() {
        JLabel label = new JLabel();
        JButton buton1 = new JButton("Accueil");
        JButton buton2 = new JButton("Indicateur");
        JButton buton3 = new JButton("Mapping");
        JButton buton4 = new JButton("Carte");


        this.add(label);
        this.add(buton1);
        this.add(buton2);
        this.add(buton3);
        this.add(buton4);
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        this.setAlignmentY(Component.CENTER_ALIGNMENT);
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setBackground(new Color(68, 114, 196));
        this.setPreferredSize(new Dimension(200, 100));
        label.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        label.setText("<html><body><font color='blanc'>Entreprise: Tech-Work </body></html>");
    }
}
