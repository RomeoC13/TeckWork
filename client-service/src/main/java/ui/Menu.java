package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Menu extends JFrame {

    public Menu() {
        this.setTitle("Welcome to techwork");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Side_Menu sm= new Side_Menu();
        getContentPane().add(sm, BorderLayout.WEST);
        this.setVisible(true);


    }

    public static void main(String[] args) {
        Menu f = new Menu();
    }


}