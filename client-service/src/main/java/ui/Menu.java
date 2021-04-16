package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Menu extends JFrame {

    public Menu() {

        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel();
        JButton buton1 = new JButton("Accueil");
        JButton buton2 = new JButton("Indicateur");
        JButton buton3 = new JButton("Mapping");
        JButton buton4 = new JButton("Carte");


        this.setTitle("Welcome to techwork");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setBackground(new Color(68, 114, 196));
        panel.setPreferredSize(new Dimension(200, 100));
        getContentPane().add(panel, BorderLayout.WEST);

        label.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
        label.setText("<html><body><font color='blanc'>Entreprise: Tech-Work </body></html>");
//        JPanel buttonPan = new JPanel();
//        BoxLayout boxlayout = new BoxLayout(buttonPan, BoxLayout.Y_AXIS);
//        buttonPan.setLayout(boxlayout);
        panel.add(label);
        panel.add(buton1);
        panel.add(buton2);
        panel.add(buton3);
        panel.add(buton4);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.setAlignmentY(Component.CENTER_ALIGNMENT);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);


//        panel.add(buttonPan,BorderLayout.CENTER);


       /* this.add(BorderLayout.BEFORE_FIRST_LINE, panel);
        panel.setBackground(Color.blue);
        panel.setSize(200,200);
        this.add(panel);*/


        this.setVisible(true);


    }

    public static void main(String[] args) {
        Menu f = new Menu();
    }


}