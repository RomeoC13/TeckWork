package userIHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowsMapping extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JButton button1 = new JButton("Etage/Espace");
    JButton button2 = new JButton("Equipements");
    JButton button3 = new JButton("Visualiser carte");
    JButton button4 = new JButton("Etats");



    public WindowsMapping() {
        this.setTitle("Windows for Mapping");
        this.setSize(400,300);
        panel.setBackground(Color.BLUE);
        panel.setPreferredSize(new Dimension(150,150));
        this.add(panel, BorderLayout.WEST);

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);



        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public static void main(String[] args) {
        WindowsMapping m = new WindowsMapping();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WindowsEquipment f = new WindowsEquipment();

        if (e.getSource() == button2) {
            WindowsMapping.this.dispose();
            new WindowsEquipment();
        }
    }
}
