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

    public void paint (Graphics g) {
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
        System.out.println(e.getX());
        System.out.println(e.getY());

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
