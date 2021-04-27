package userIHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsEquipment extends JFrame implements ActionListener {
    private JComboBox <String> list;
    private JComboBox <String> list1;
    JPanel panel = new JPanel();

    JLabel label = new JLabel("Choisissez l'équipement à ajouter");
    JButton button = new JButton("Ajouter");
    JButton buttonback = new JButton("Retour");

    public WindowsEquipment() {
        this.setTitle("Gestion des équipements");
        this.setSize(400,300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object [] elements = new Object[] {"Capteur", "écran connecté", "Bureau"};
        list = new JComboBox(elements);
        list.setBounds(1000, 1000, 20000, 1000);
        getContentPane().add(list);
        list.setSize(200,200);
        panel.add(label);
        this.panel.add(list);
        panel.add(list);



        JTextField room = new JTextField("Entrer le nom de la salle");
        room.setBounds(20,40,200,28);
        JTextField number = new JTextField("Entrer le numéro du capteur");
        number.setBounds(20,40,200,28);
        JTextField states = new JTextField("Etat du capteur ");
        states.setBounds(20,40,200,28);

        JLabel labelroom = new JLabel("\n                            Room");
        JLabel labelnumber = new JLabel("                            Numbers");
        JLabel labelstates = new JLabel("                             State");

        panel.add(labelroom);

        panel.add(room);


        panel.add(labelnumber);

        panel.add(number);


        panel.add(labelstates);

        panel.add(states);


        button.setBounds(110, 110, 125, 25);
        buttonback.setBounds(110,110,125,25);
        this.add(BorderLayout.CENTER, button);
        this.add(BorderLayout.CENTER, buttonback);


        panel.add(button);
        panel.add(buttonback);
        buttonback.addActionListener(this);







        this.add(panel);







        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        WindowsEquipment f = new WindowsEquipment();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowsMapping m = new WindowsMapping();

        if (e.getSource() == buttonback) {
            WindowsEquipment.this.dispose();
            new WindowsMapping();

        }

    }
}
