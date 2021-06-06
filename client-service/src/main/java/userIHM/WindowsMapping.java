package userIHM;


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
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
import java.net.Socket;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

import static client.Client.*;

//import static userIHM.Request.getEquipment;

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
    private Socket socket;

    public WindowsMapping() {

    list3 = new JComboBox<>();
        pan = new Gestion();
        this.setTitle("Bienvenue à l'affichage");
        this.setSize(1000, 1000);
        //this.setResizable(false);
        getContentPane().setBackground(Color.white);
        panel.setBackground(Color.BLUE);
        panel.setPreferredSize(new Dimension(150, 150));

        JLabel j = new JLabel("Choix de l'entreprise");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));

        String id_building = "1";
        map.get("requestBuilding").put("id_building", id_building);
        String responses = getSend("requestBuilding");
        String[] building = responses.split("@");
        for (String b : building) {
            if (b.contains("@")) {
                b.replace("@", "");
            }
            System.out.println(b);
        }
        listEquipment = new JComboBox(building);

        listEquipment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str = (String) listEquipment.getSelectedItem();
                System.out.println(str + " toto");
                map.get("request_id_building").put("name_building", str);
                String response = getSend("request_id_building");
                list3.removeAllItems();
                String[] idbuilding = response.split("@");
                for (String b : idbuilding) {
                    if (b.contains("@")) {
                        b.replace("@", "");
                    }
                    System.out.println(b);
                }
                map.get("requestFloor").put("id_building", idbuilding[0]);
                response = getSend("requestFloor");
                String[] floor = response.split("@");
                for (String b : floor) {
                    if (b.contains("@")) {
                        b.replace("@", "");
                    }
                    System.out.println(b);
                }

                for (String elem : floor) {
                    list3.addItem(elem);
                }


            }
        });

        listEquipment.setBounds(1000, 1000, 20000, 1000);
        listEquipment.addActionListener(this);
        listEquipment.setSize(200, 200);
        panel.add(j);
        panel.add(listEquipment);


        JLabel j1 = new JLabel("Choix de la salle");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));
        String id_room = "1";
        map.get("requestRoom").put("id_room", id_building);

        String responseroom = getSend("requestRoom");
        String[] room = responseroom.split("@");
        for (String b : room) {
            if (b.contains("@")) {
                b.replace("@", "");
            }
            System.out.println(b);
        }


        list1 = new JComboBox(room);
        list1.setBounds(1000, 1000, 20000, 1000);
        list1.setSize(200, 200);
        panel.add(j1);
        panel.add(list1);


        JLabel j3 = new JLabel("          Etage            ");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));


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





