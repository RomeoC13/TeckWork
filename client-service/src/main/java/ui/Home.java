package ui;

//import location.clientLoc.HomeLocation;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import static client.Client.getSend;
import static client.Client.map;
import static userIHM.WindowsMapping.listBuiling;


public class Home {
    private String[] element = {"mairie", "service", "pouvooirs", "publics", "location"};
    private JComboBox comboboxCompany;
    private WindowsMenu newWindow;
    private JFrame myFrame = new JFrame();


    public Home() {

        myFrame.setVisible(true);
        myFrame.setTitle("page d'accueil");
        myFrame.setSize(700, 400);
        myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        myFrame.setLocationRelativeTo(null);


        JPanel contentPane = (JPanel) myFrame.getContentPane();
        contentPane.setLayout(new GridLayout(3, 1));

        String company_id = "1";
        map.get("requestCompany").put("company_id", company_id);

        String responses = getSend("requestCompany");
        String[] company = responses.split("@");
        for (String b : company) {
            if (b.contains("@")) {
                b.replace("@", "");
            }
            System.out.println(b);
        }

        comboboxCompany = new JComboBox(company);

        comboboxCompany.setPreferredSize(new Dimension(70, 70));

        contentPane.add(topOptionPanel());
        contentPane.add(comboboxCompany);
        contentPane.add(southOptionPanel());
        contentPane.revalidate();

    }

    private JPanel southOptionPanel() {
        JPanel southPanel = new JPanel(new FlowLayout());
        JButton ValidateButon = new JButton("Valider");
        ValidateButon.setPreferredSize(new Dimension(100, 70));
        ;
        ValidateButon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                newWindow = new WindowsMenu((String) comboboxCompany.getSelectedItem());
                myFrame.dispose();


            }
        });
        southPanel.add(ValidateButon);

        JButton cancelButon = new JButton("Annuler");
        cancelButon.setPreferredSize(new Dimension(100, 70));
        cancelButon.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Vous avez annul� la session");
                myFrame.dispose();
            }
        });
        southPanel.add(cancelButon);
        southPanel.setBackground(Color.white);


        return southPanel;
    }

    private JPanel topOptionPanel() {
        JPanel topPanel = new JPanel();
        JLabel topMessage = new JLabel("Veuillez choisir une option");
        topMessage.setAlignmentX(Component.CENTER_ALIGNMENT);
        topMessage.setAlignmentY(Component.CENTER_ALIGNMENT);
        topMessage.setFont(new Font("Sylfaen", Font.CENTER_BASELINE, 20));
        topPanel.setBackground(Color.white);
        topPanel.add(topMessage);
        return topPanel;
    }



}
