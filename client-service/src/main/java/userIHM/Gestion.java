package userIHM;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Gestion extends JPanel implements MouseListener {
    String equipment;

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public Gestion() {
        setPreferredSize(new Dimension(750, 750));
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {
        URL imgURL = Thread.currentThread().getContextClassLoader().getResource("planbureau.jpg");
        BufferedImage currentEquipment;

        try {
            currentEquipment = ImageIO.read(imgURL);
            g.drawImage(currentEquipment, 0, 0, 750, 750, null);
            imgURL = Thread.currentThread().getContextClassLoader().getResource("localisation.png");
            currentEquipment = ImageIO.read(imgURL);
            g.drawImage(currentEquipment, 195, 460, 50, 50, null);
            g.drawImage(currentEquipment, 533, 201, 50, 50, null);
            g.drawImage(currentEquipment, 550, 549, 50, 50, null);
            g.drawImage(currentEquipment, 99, 377, 50, 50, null);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println(e.getX());
        System.out.println(e.getY());

        BufferedImage currentEquipment;
        URL mapUrl = Thread.currentThread().getContextClassLoader().getResource("écran.jpg");
        if (e.getX() >= 195 & e.getX() <= 245 & e.getY() >= 460 & e.getY() <= 510) {

            int reponseScreen = JOptionPane.showConfirmDialog(null, "Emplacement écran. Voulez vous continuer?");

            if (reponseScreen == JOptionPane.YES_OPTION) {

                try {
                    currentEquipment = ImageIO.read(mapUrl);
                    getGraphics().drawImage(currentEquipment, 195, 460, 50, 50, null);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }


        URL mapUrl2 = Thread.currentThread().getContextClassLoader().getResource("prise.jpg");
        if (e.getX() >= 533 & e.getX() <= 583 & e.getY() >= 201 & e.getY() <= 251) {

            int reponsePrise = JOptionPane.showConfirmDialog(null, "Emplacement prise. Voulez vous continuer?");

            if (reponsePrise == JOptionPane.YES_OPTION) {

                try {
                    currentEquipment = ImageIO.read(mapUrl2);
                    getGraphics().drawImage(currentEquipment, 533, 201, 50, 50, null);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }
        URL mapUrl1 = Thread.currentThread().getContextClassLoader().getResource("fenetre.jpg");
        if (e.getX() >= 550 & e.getX() <= 600 & e.getY() >= 549 & e.getY() <= 599) {

            int reponseFenetre = JOptionPane.showConfirmDialog(null, "Emplacement Fenêtre. Voulez vous continuer?");

            if (reponseFenetre == JOptionPane.YES_OPTION) {

                try {
                    currentEquipment = ImageIO.read(mapUrl1);
                    getGraphics().drawImage(currentEquipment, 550, 549, 50, 50, null);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }

        URL mapUrl3 = Thread.currentThread().getContextClassLoader().getResource("capteur.jpg");
        if (e.getX() >= 99 & e.getX() <= 149 & e.getY() >= 377 & e.getY() <= 427) {

            int reponseCapteur = JOptionPane.showConfirmDialog(null, "Emplacement Fenêtre. Voulez vous continuer?");

            if (reponseCapteur == JOptionPane.YES_OPTION) {


                try {
                    currentEquipment = ImageIO.read(mapUrl3);
                    getGraphics().drawImage(currentEquipment, 99, 377, 50, 50, null);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
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

