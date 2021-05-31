package userIHM;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

import static userIHM.Request.getEquipment;

public class WindowsMapping extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    Gestion pan;
    JButton button1 = new JButton("Batiment");
    JButton button2 = new JButton("Equipements");
    JButton button5 = new JButton("Etage");
    JButton button3 = new JButton("Visualiser carte");


    private JComboBox<String> listEquipment;
    private JComboBox<String> list1;
    private JComboBox<String> list3;



    public WindowsMapping() {

        this.pan = new Gestion();
        this.setTitle("Windows for Mapping");
        this.setSize(1000, 1000);
        //this.setResizable(false);
        getContentPane().setBackground(Color.white);
        panel.setBackground(Color.BLUE);
        panel.setPreferredSize(new Dimension(150, 150));

        JLabel j = new JLabel("Choix équipements");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));
        String[] elements = new String[]{"Windows", "sensor", "screen"};
        listEquipment = new JComboBox(getEquipment());
        listEquipment.setBounds(1000, 1000, 20000, 1000);
        listEquipment.addActionListener(this);
        listEquipment.setSize(200, 200);
        panel.add(j);
        panel.add(listEquipment);


        JLabel j1 = new JLabel("Choix batiments");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));
        String[] element = new String[]{"BatimentA1", "BatimentA2"};
        list1 = new JComboBox(element);
        list1.setBounds(1000, 1000, 20000, 1000);
        list1.setSize(200, 200);
        panel.add(j1);
        panel.add(list1);


        JLabel j3 = new JLabel("          Etage            ");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));
        String[] elemnt = new String[]{"            ", "1", "2"};
        list3 = new JComboBox(elemnt);
        list3.setBounds(1000, 1000, 20000, 1000);
        list3.setSize(200, 200);
        panel.add(j3);
        panel.add(list3);

        getContentPane().add(panel, BorderLayout.WEST);


        this.getContentPane().add(pan, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {



    }
}





