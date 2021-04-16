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
        JPanel card = new JPanel();
        card.setBackground(new Color(255, 0, 0, 255));
        JButton createButton = new JButton("Créer une nouvelle carte d’accès");
        JButton modifyButton = new JButton("Modifier une carte d’accès");
        JButton readButton = new JButton("Consulter la liste des cartes et suppression de permissions");

        card.add(createButton);
        card.add(modifyButton);
        card.add(readButton);

        card.setLayout(new BoxLayout(card,BoxLayout.Y_AXIS));
        getContentPane().add(card,BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Card f = new Card();
    }


}
