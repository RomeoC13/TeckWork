package userIHM;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.sql.Connection;

public class WindowsEquipment extends JFrame  {

    JPanel panel =  new JPanel();
    JButton button =new JButton("Visualiser carte");
    JButton button1 = new JButton("Retour");
    Socket s = new Socket();




    public WindowsEquipment()  {
        this.setTitle("Windows for Mapping");
        this.setSize(700,300);
        panel.setBackground(Color.BLUE);
        panel.setPreferredSize(new Dimension(150,150));



        getContentPane().add(panel, BorderLayout.WEST);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        WindowsEquipment w = new WindowsEquipment();
        w.setVisible(true);
    }
}
