package ui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Card extends JFrame {

    public Card() {
        this.setTitle("Welcome to techwork");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Side_Menu sm= new Side_Menu();
        getContentPane().add(sm, BorderLayout.WEST);

        this.setVisible(true);


    }

    public static void main(String[] args) {
        Card f = new Card();
    }


}
