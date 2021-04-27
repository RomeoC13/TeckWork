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
import java.io.IOException;
import java.net.URL;

public class WindowsMapping extends JFrame implements ActionListener {
    JPanel panel = new JPanel();
    JButton button1 = new JButton("Batiment");
    JButton button2 = new JButton("Equipements");
    JButton button3 = new JButton("Visualiser carte");
    JButton button4 = new JButton("Etats");

    private JComboBox <String> list;
    private JComboBox <String> list1;
    private JComboBox <String> list2;
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
        list = new JComboBox(elements);
        list.setBounds(1000, 1000, 20000, 1000);
        list.addActionListener(this);
        list.setSize(200,200);
        panel.add(j);
        panel.add(list);

        JLabel j1 = new JLabel("Choix batiments");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));
        String[] element = new String[] {"BatimentA1", "BatimentA2"};
        list1 = new JComboBox(element);
        list1.setBounds(1000, 1000, 20000, 1000);
        list1.setSize(200,200);
        panel.add(j1);
        panel.add(list1);

        JLabel j2 = new JLabel("Etats");
        j.setFont(new Font("TimesRoman", Font.BOLD, 14));
        String[] element1 = new String[] {"Actif      ", "Inactif     "};
        list2 = new JComboBox(element1);
        list2.setBounds(1000, 1000, 20000, 1000);
        list2.setSize(200,200);
        panel.add(j2);
        panel.add(list2);

        getContentPane().add(panel, BorderLayout.WEST);
        getContentPane().add(g, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new WindowsMapping();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("je fais un clique");
        g.setEquipment(list.getSelectedItem().toString());
        System.out.println(list.getSelectedItem().toString());
    }
}

class Gestion extends JPanel implements MouseListener{
    String equipment;
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
    public Gestion() {
        this.addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        URL mapUrl = Thread.currentThread().getContextClassLoader().getResource("écran.jpg");
        URL mapUrl1 = Thread.currentThread().getContextClassLoader().getResource("capteur.jpg");
        URL mapUrl2 = Thread.currentThread().getContextClassLoader().getResource("prise.jpg");
        URL mapUrl3 = Thread.currentThread().getContextClassLoader().getResource("fenetre.jpg");
        try {
            System.out.println("Valeur de l'équipement : " + equipment);
            if(equipment == "écran connecté") {
                BufferedImage img = ImageIO.read(mapUrl);
                Graphics g = getGraphics();
                g.drawImage(img, e.getX(), e.getY(),20,20, null);

            }
            else if (equipment == "Capteur") {
                BufferedImage img1 = ImageIO.read(mapUrl1);
                Graphics g = getGraphics();
                g.drawImage(img1, e.getX(), e.getY(),20,20, null);

            }
            else if(equipment == "prise connecté") {
                BufferedImage img2 = ImageIO.read(mapUrl2);
                Graphics g = getGraphics();
                g.drawImage(img2, e.getX(), e.getY(),20,20, null);

            }
            else if (equipment == "fenetre") {
                BufferedImage img3 = ImageIO.read(mapUrl3);
                Graphics g = getGraphics();
                g.drawImage(img3, e.getX(), e.getY(),20,20, null);

            }
            this.revalidate();
            this.setVisible(true);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
}
