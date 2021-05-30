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
            g.drawImage(currentEquipment, 60, 420, 50, 50, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        URL mapUrl1 = Thread.currentThread().getContextClassLoader().getResource("capteur.jpg");
        URL mapUrl2 = Thread.currentThread().getContextClassLoader().getResource("prise.jpg");
        URL mapUrl3 = Thread.currentThread().getContextClassLoader().getResource("fenetre.jpg");

    }

    @Override
    public void mousePressed(MouseEvent e) {
        BufferedImage currentEquipment;
        URL mapUrl = Thread.currentThread().getContextClassLoader().getResource("écran.jpg");
        if (e.getX() >= 195 & e.getX() <= 245 & e.getY() >= 460 & e.getY() <= 510) {
            System.out.println("J'ai cliqué dans une localisation ");
            try {
                currentEquipment = ImageIO.read(mapUrl);
                getGraphics().drawImage(currentEquipment, 195, 460, 50, 50, null);
            } catch (IOException ioException) {
                ioException.printStackTrace();
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

