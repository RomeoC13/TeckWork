package userIHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame {
    JPanel panel = new JPanel();
    JLabel label = new JLabel("Choisissez votre entreprise !");
    JButton button = new JButton("Valider");
    private JComboBox <String> liste;


    public Screen() {
        this.setTitle("Welcome to techwork");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object [] elements = new Object[] {"SEPA Relax", "SEPHORA", "Linux et Ben's"};
        liste = new JComboBox(elements);
        liste.setBounds(1000, 1000, 20000, 1000);
        getContentPane().add(liste);
        liste.setSize(200,200);
        panel.add(label);
        this.panel.add(liste);
        button.setBounds(110, 110, 125, 25);
        this.add(BorderLayout.CENTER, button);
        panel.add(button);
        panel.add(liste);

        this.add(panel);




        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowsMenus f = new WindowsMenus();
                Screen.this.dispose();
                System.out.println("..."+liste);
            }
        });




        this.setVisible(true);


    }



    public static void main(String[] args) {
        Screen e = new Screen();




    }

}
