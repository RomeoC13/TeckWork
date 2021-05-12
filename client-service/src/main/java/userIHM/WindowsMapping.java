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
    JPanel pan = new JPanel();
    JButton button1 = new JButton("Batiment");
    JButton button2 = new JButton("Equipements");
    JButton button5 = new JButton("Etage");
    JButton button3 = new JButton("Visualiser carte");


    private JComboBox<String> listEquipment;
    private JComboBox<String> list1;
    private JComboBox<String> list3;
    Gestion g;


    public WindowsMapping() {
        g = new Gestion();

        this.setTitle("Windows for Mapping");
        this.setSize(800, 800);
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
        getContentPane().add(g, BorderLayout.CENTER);

        getContentPane().add(pan);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        new WindowsMapping();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("je fais un clique");
        g.setEquipment(listEquipment.getSelectedItem().toString());
        System.out.println(listEquipment.getSelectedItem().toString());

    }


    class Gestion extends JPanel implements MouseListener {
         String equipment;

        public void setEquipment(String equipment) {
            this.equipment = equipment;
        }

        public Gestion() {
            setPreferredSize(new Dimension(750,750));
            this.addMouseListener(this);
        }

        public void paint(Graphics g) {
            URL imgURL = Thread.currentThread().getContextClassLoader().getResource("planbureau.jpg");
            BufferedImage currentEquipment;

            try{
                currentEquipment = ImageIO.read(imgURL);
                g.drawImage(currentEquipment, 200, 150, 750, 750, null);
                imgURL = Thread.currentThread().getContextClassLoader().getResource("localisation.png");
                currentEquipment = ImageIO.read(imgURL);
                g.drawImage(currentEquipment, 300, 400, 50, 50, null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            URL mapUrl = Thread.currentThread().getContextClassLoader().getResource("écran.jpg");
            URL mapUrl1 = Thread.currentThread().getContextClassLoader().getResource("capteur.jpg");
            URL mapUrl2 = Thread.currentThread().getContextClassLoader().getResource("prise.jpg");
            URL mapUrl3 = Thread.currentThread().getContextClassLoader().getResource("fenetre.jpg");
            try {

                System.out.println(" voici " +listEquipment.getSelectedItem().toString());
                if (listEquipment.getSelectedItem().toString().contains("screen")) {
                    BufferedImage img = ImageIO.read(mapUrl);
                    System.out.println("ici");
                    Graphics g = getGraphics();
                    g.drawImage(img, e.getX(), e.getY(), 20, 20, null);
                    System.out.println("Etat Actif");


                } else if (listEquipment.getSelectedItem().toString().contains("sensor")) {
                    BufferedImage img1 = ImageIO.read(mapUrl1);
                    Graphics g = getGraphics();
                    g.drawImage(img1, e.getX(), e.getY(), 20, 20, null);
                    System.out.println("Etat Actif");

                } else if (listEquipment.getSelectedItem().toString().contains("powerconnected")) {
                    BufferedImage img2 = ImageIO.read(mapUrl2);
                    Graphics g = getGraphics();
                    g.drawImage(img2, e.getX(), e.getY(), 20, 20, null);
                    System.out.println("Etat Actif");

                } else if (listEquipment.getSelectedItem().toString().contains("windows")) {
                    BufferedImage img3 = ImageIO.read(mapUrl3);
                    Graphics g = getGraphics();
                    g.drawImage(img3, e.getX(), e.getY(), 20, 20, null);
                    System.out.println("Etat Actif");

                }
                this.revalidate();
                this.setVisible(true);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }
}





