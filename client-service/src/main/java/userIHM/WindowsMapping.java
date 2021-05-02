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
    JButton button1 = new JButton("Batiment");
    JButton button2 = new JButton("Equipements");
    JButton button5 = new JButton("Etage");
    JButton button3 = new JButton("Visualiser carte");



    private JComboBox <String> listEquipment;
    private JComboBox <String> list1;
    private JComboBox<String> list3;
    Gestion g;


    public WindowsMapping() {
        g= new Gestion();

        this.setTitle("Windows for Mapping");
        this.setSize(700,300);
        panel.setBackground(Color.BLUE);
        panel.setPreferredSize(new Dimension(150,150));

        JLabel j = new JLabel("Choix équipements");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));
        String [] elements = new String[] {"Capteur", "écran connecté", "fenetre", "prise connecté"};
        listEquipment = new JComboBox(getEquipment());
        listEquipment.setBounds(1000, 1000, 20000, 1000);
        listEquipment.addActionListener(this);
        listEquipment.setSize(200,200);
        panel.add(j);
        panel.add(listEquipment);



        JLabel j1 = new JLabel("Choix batiments");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));
        String[] element = new String[] {"BatimentA1", "BatimentA2"};
        list1 = new JComboBox(element);
        list1.setBounds(1000, 1000, 20000, 1000);
        list1.setSize(200,200);
        panel.add(j1);
        panel.add(list1);


        JLabel j3 = new JLabel("          Etage            ");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));
        String [] elemnt = new String[] {"            ", "1", "2"};
        list3 = new JComboBox(elemnt);
        list3.setBounds(1000, 1000, 20000, 1000);
        list3.setSize(200,200);
        panel.add(j3);
        panel.add(list3);

        getContentPane().add(panel, BorderLayout.WEST);
        getContentPane().add(g, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        JTextField prenomfeild = new JTextField(20);
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
        private Properties props;


        public void setEquipment(String equipment) {
            this.equipment = equipment;
        }

        public Gestion() {
            this.addMouseListener(this);
           /* Properties props = new Properties();
            try {
                Class.forName(props.getProperty("jdbc.driver"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                String url = props.getProperty("jdbc.url");
                String login = props.getProperty("jdbc.login");
                String pwd = props.getProperty("jdbc.password");
                co = DriverManager.getConnection(url, login, pwd);
                st = co.createStatement();

            } catch (Exception e) {
                e.printStackTrace();
            }*/
        }

        @Override
        public void mouseClicked (MouseEvent e){
            URL mapUrl = Thread.currentThread().getContextClassLoader().getResource("écran.jpg");
            URL mapUrl1 = Thread.currentThread().getContextClassLoader().getResource("capteur.jpg");
            URL mapUrl2 = Thread.currentThread().getContextClassLoader().getResource("prise.jpg");
            URL mapUrl3 = Thread.currentThread().getContextClassLoader().getResource("fenetre.jpg");
            try {
                System.out.println("Valeur de l'équipement : " + equipment);
                if (equipment == "écran connecté") {
                    BufferedImage img = ImageIO.read(mapUrl);
                    Graphics g = getGraphics();
                    g.drawImage(img, e.getX(), e.getY(), 20, 20, null);
                    System.out.println("Etat Actif");


                } else if (equipment == "Capteur") {
                    BufferedImage img1 = ImageIO.read(mapUrl1);
                    Graphics g = getGraphics();
                    g.drawImage(img1, e.getX(), e.getY(), 20, 20, null);
                    System.out.println("Etat Actif");

                } else if (equipment == "prise connecté") {
                    BufferedImage img2 = ImageIO.read(mapUrl2);
                    Graphics g = getGraphics();
                    g.drawImage(img2, e.getX(), e.getY(), 20, 20, null);
                    System.out.println("Etat Actif");

                } else if (equipment == "fenetre") {
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
        public void mousePressed (MouseEvent e){
        }
        @Override
        public void mouseReleased (MouseEvent e){
        }
        @Override
        public void mouseEntered (MouseEvent e){
        }
        @Override
        public void mouseExited (MouseEvent e){
        }

    }
}





