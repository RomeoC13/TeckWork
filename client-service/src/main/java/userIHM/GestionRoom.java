package userIHM;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class GestionRoom extends JPanel implements MouseListener {

    public GestionRoom() {
        setPreferredSize(new Dimension(750, 750));
        this.addMouseListener(this);
    }

    public void paint(Graphics g) {
        URL imgURL = Thread.currentThread().getContextClassLoader().getResource("salle de conférence.jpg");
        BufferedImage currentEquipment;
        try {
            currentEquipment = ImageIO.read(imgURL);
            g.drawImage(currentEquipment, 0, 0, 750, 750, null);
            imgURL = Thread.currentThread().getContextClassLoader().getResource("localisation.png");
            currentEquipment = ImageIO.read(imgURL);
            g.drawImage(currentEquipment, 625, 220, 50, 50, null); /*fenetre*/
            g.drawImage(currentEquipment, 236, 189, 50, 50, null); /*capteur*/
            g.drawImage(currentEquipment, 557, 560, 50, 50, null); /*prise*/
            g.drawImage(currentEquipment, 111, 430, 50, 50, null); /*écran*/


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {

        BufferedImage currentEquipment;
        URL mapUrl = Thread.currentThread().getContextClassLoader().getResource("fenetre.jpg");
        if (e.getX() >= 625 & e.getX() <= 675 & e.getY() >= 220 & e.getY() <= 270) {

            int reponseWindows = JOptionPane.showConfirmDialog(null, "Emplacement fenêtre. Voulez vous continuer?");

            if (reponseWindows == JOptionPane.YES_OPTION) {

                try {
                    currentEquipment = ImageIO.read(mapUrl);
                    getGraphics().drawImage(currentEquipment, 625, 220, 50, 50, null);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        URL mapUrl2 = Thread.currentThread().getContextClassLoader().getResource("capteur.jpg");
        if (e.getX() >= 236 & e.getX() <= 286 & e.getY() >= 189 & e.getY() <= 239) {

            int reponseSensor = JOptionPane.showConfirmDialog(null, "Emplacement capteur. Voulez vous continuer?");

            if (reponseSensor == JOptionPane.YES_OPTION) {

                try {
                    currentEquipment = ImageIO.read(mapUrl2);
                    getGraphics().drawImage(currentEquipment, 236, 189, 50, 50, null);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        URL mapUrl1 = Thread.currentThread().getContextClassLoader().getResource("prise.jpg");
        if (e.getX() >= 557 & e.getX() <= 607 & e.getY() >= 560 & e.getY() <= 610) {

            int reponsePlug = JOptionPane.showConfirmDialog(null, "Emplacement prise. Voulez vous continuer?");

            if (reponsePlug == JOptionPane.YES_OPTION) {

                try {
                    currentEquipment = ImageIO.read(mapUrl1);
                    getGraphics().drawImage(currentEquipment, 557, 560, 50, 50, null);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }

        URL mapUrl3 = Thread.currentThread().getContextClassLoader().getResource("écran.jpg");
        if (e.getX() >= 111 & e.getX() <= 161 & e.getY() >= 430 & e.getY() <= 480) {

            int reponseScreen = JOptionPane.showConfirmDialog(null, "Emplacement écran. Voulez vous continuer?");

            if (reponseScreen == JOptionPane.YES_OPTION) {

                try {
                    currentEquipment = ImageIO.read(mapUrl3);
                    getGraphics().drawImage(currentEquipment, 111, 430, 50, 50, null);
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
