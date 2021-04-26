package userIHM;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Map extends JFrame implements MouseListener {
    int nbequipment;
    boolean acPlaced;
    String [] equipment = new String[3];






    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {


        if(e.getClickCount() == 2) {
            System.out.println("Double clic");
        }
        if((e.getX() >= 120 & e.getX() <= 560) & (e.getY() >= 120 & e.getY() <= 400) & nbequipment < 30 ) {
            System.out.println("Voici les coordonnées : "+e.getX()+""+e.getY());
            int x = e.getX() - 5;
            int y = e.getY() - 5;
            URL imgUrl = Thread.currentThread().getContextClassLoader().getResource(equipment[3]);
            try{
                if(acPlaced) {
                    BufferedImage currentEquipment = ImageIO.read(imgUrl);
                    Graphics g = getGraphics();
                    g.drawImage(currentEquipment, x , y, 50, 50, null);
                    nbequipment++;
                    acPlaced = true;
                }

            } catch (Exception exception) {
                exception.printStackTrace();
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

    public static void main(String[] args) {
        Map m = new Map();
        m.setSize(400,500);
        m.setVisible(true);

    }
}
