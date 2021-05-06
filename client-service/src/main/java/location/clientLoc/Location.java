package location.clientLoc;

import location.serveurLoc.serveurLoc;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Location {

    static JFrame frame=new JFrame("Location d'un espace");
    static JPanel panel = new JPanel();
    static JPanel panelTop = new JPanel();
    static JPanel panelFormulaire = new JPanel();
    static serveurLoc r = new serveurLoc();
    static String[] tab = new String[6];

    static JFrame frameEnvoie = new JFrame("Propositions");
    static JPanel panelEnvoie = new JPanel(new GridLayout(4,1,10,10));

    static JFrame frameErreur = new JFrame("ERREUR");
    static JPanel panelErreur = new JPanel(new BorderLayout());

    static class StyledButtonUI extends BasicButtonUI {

        @Override
        public void installUI(JComponent c) {
            super.installUI(c);
            AbstractButton button = (AbstractButton) c;
            button.setOpaque(false);
            button.setBorder(new EmptyBorder(5, 15, 5, 15));
        }

        @Override
        public void paint(Graphics g, JComponent c) {
            AbstractButton b = (AbstractButton) c;
            paintBackground(g, b, b.getModel().isPressed() ? 2 : 0);
            super.paint(g, c);
        }

        private void paintBackground(Graphics g, JComponent c, int yOffset) {
            Dimension size = c.getSize();
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(c.getBackground().darker());
            g.fillRoundRect(0, yOffset, size.width, size.height - yOffset, 10, 10);
            g.setColor(c.getBackground());
            g.fillRoundRect(0, yOffset, size.width, size.height + yOffset - 5, 10, 10);
        }
    }

    public static class ActionAccueil implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            panel.removeAll();
            frame.dispose();
            Home h = new Home();
            String[] args = {};
            h.main(args);
        }
    }

    public static class ActionPlan implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            panel.removeAll();
            frame.dispose();
            Plan p = new Plan();
            String[] args = {};
            p.main(args);
        }
    }

    public static class ActionFormulaire implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            panel.removeAll();
            panelFormulaire.removeAll();
            frame.dispose();
            Location l = new Location();
            String[] args = {};
            l.main(args);
        }
    }

    public static class ActionEnvoie implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String adresse = tab[0];
            String ad = "";
            if(adresse.equalsIgnoreCase(r.getNomBat(0))) {
                ad = r.getNomBat(0);
            } else if(adresse.equalsIgnoreCase(r.getNomBat(1))) {
                ad = r.getNomBat(1);
            } else if(adresse.equalsIgnoreCase(r.getNomBat(2))) {
                ad = r.getNomBat(2);
            } else if(adresse.equalsIgnoreCase(r.getNomBat(3))) {
                ad = r.getNomBat(3);
            } else if(adresse.equalsIgnoreCase(r.getNomBat(4))) {
                ad = r.getNomBat(4);
            }
            panelEnvoie.removeAll();
            panelErreur.removeAll();

            if(Integer.parseInt(tab[3]) <= r.getPlace(ad)) {
                JPanel prop1 = new JPanel();
                JPanel prop2 = new JPanel();
                JPanel prop3 = new JPanel();
                JPanel prop4 = new JPanel();
                setTextLabel("Prop 1", prop1);
                setTextLabel("Prop 2", prop2);
                setTextLabel("Prop 3", prop3);
                setTextLabel("Prop 4", prop4);
                panelEnvoie.add(prop1);
                panelEnvoie.add(prop2);
                panelEnvoie.add(prop3);
                panelEnvoie.add(prop4);
                frameEnvoie.add(panelEnvoie);
                frameEnvoie.setSize(500, 500);
                frameEnvoie.setVisible(true);
            } else {
                JLabel lErreur = new JLabel("Le batiment : " + tab[0] + " possède seulement " + r.getPlace(ad) + " place(s) restante(s). " +
                        "Choisissez un nouveau batiment, ou alors prenez un nombre de salles correcte.");
                panelErreur.add(lErreur, BorderLayout.CENTER);
                frameErreur.add(panelErreur);
                frameErreur.setSize(1000, 200);
                frameErreur.setVisible(true);
            }
        }
    }

    static void setTextLabel(String text, JPanel p) {
        JLabel l = new JLabel(text);
        p.add(l);
    }

    private static void addLabelAndTextField(String labelText, int yPos, Container containingPanel) {

        JLabel label = new JLabel(labelText);
        GridBagConstraints gridBagConstraintForLabel = new GridBagConstraints();
        gridBagConstraintForLabel.fill = GridBagConstraints.BOTH;
        gridBagConstraintForLabel.insets = new Insets(0, 0, 5, 5);
        gridBagConstraintForLabel.gridx = 0;
        gridBagConstraintForLabel.gridy = yPos;
        containingPanel.add(label, gridBagConstraintForLabel);

        JTextField textField = new JTextField();
        GridBagConstraints gridBagConstraintForTextField = new GridBagConstraints();
        gridBagConstraintForTextField.fill = GridBagConstraints.BOTH;
        gridBagConstraintForTextField.insets = new Insets(0, 0, 5, 0);
        gridBagConstraintForTextField.gridx = 1;
        gridBagConstraintForTextField.gridy = yPos;
        containingPanel.add(textField, gridBagConstraintForTextField);
        textField.setColumns(10);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createTabToReturn(label.getText() + "/-/" + textField.getText());
            }
        });
    }

    public static String[] createTabToReturn(String entry) {
        switch(entry.split(":/-/")[0]) {
            case "BAT":
                tab[0] = entry.split(":/-/")[1];
                break;
            case "Entreprise":
                tab[1] = entry.split(":/-/")[1];
                break;
            case "Adresse entreprise":
                tab[2] = entry.split(":/-/")[1];
                break;
            case "Nombres de salles":
                tab[3] = entry.split(":/-/")[1];
                break;
            case "Téléphone":
                tab[4] = entry.split(":/-/")[1];
                break;
            case "Mail":
                tab[5] = entry.split(":/-/")[1];
                break;
        }
        return tab;
    }

    public String[] getTab() {
        return tab;
    }


    public static void main (String[] args) {
        createTabToReturn("BAT:/-/"+r.getNomBat(0));

        panel.setLayout(new BorderLayout());
        panelTop.setLayout(new BorderLayout());
        panelFormulaire.setLayout(new BorderLayout());
        JToolBar toolbar = new JToolBar();

        Border border = panelFormulaire.getBorder();
        Border margin = new EmptyBorder(10, 10, 10, 10);
        panelFormulaire.setBorder(new CompoundBorder(border, margin));

        GridBagLayout panelGridBagLayout = new GridBagLayout();
        panelGridBagLayout.columnWidths = new int[] { 86, 86, 0 };
        panelGridBagLayout.rowHeights = new int[] { 20, 20, 20, 20, 20, 0 };
        panelGridBagLayout.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
        panelGridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panelFormulaire.setLayout(panelGridBagLayout);

        addLabelAndTextField("Entreprise:", 0, panelFormulaire);
        addLabelAndTextField("Adresse entreprise:", 1, panelFormulaire);
        addLabelAndTextField("Nombres de salles:", 2, panelFormulaire);
        addLabelAndTextField("Téléphone:",3, panelFormulaire);
        addLabelAndTextField("Mail:", 4, panelFormulaire);



        final JButton buttonAccueil = new JButton("Accueil");
        buttonAccueil.addActionListener(new ActionAccueil());
        buttonAccueil.setFont(new Font("Calibri", Font.PLAIN, 14));
        buttonAccueil.setBackground(new Color(0x3C4DCE));
        buttonAccueil.setForeground(Color.white);
        buttonAccueil.setUI(new Home.StyledButtonUI());
        toolbar.add(buttonAccueil);

        final JButton buttonPlan = new JButton("Plan");
        buttonPlan.addActionListener(new ActionPlan());
        buttonPlan.setFont(new Font("Calibri", Font.PLAIN, 14));
        buttonPlan.setBackground(new Color(0x3C4DCE));
        buttonPlan.setForeground(Color.white);
        buttonPlan.setUI(new Home.StyledButtonUI());
        toolbar.add(buttonPlan);

        final JButton buttonFormulaire = new JButton("Formulaire");
        buttonFormulaire.addActionListener(new ActionFormulaire());
        buttonFormulaire.setFont(new Font("Calibri", Font.PLAIN, 14));
        buttonFormulaire.setBackground(new Color(0x3C4DCE));
        buttonFormulaire.setForeground(Color.white);
        buttonFormulaire.setUI(new Home.StyledButtonUI());
        //panelTop.add(buttonPlan, BorderLayout.CENTER);
        toolbar.add(buttonFormulaire);

        final JButton buttonEnvoie = new JButton("Envoyer");
        buttonEnvoie.addActionListener(new ActionEnvoie());
        buttonEnvoie.setFont(new Font("Calibri", Font.PLAIN, 14));
        buttonEnvoie.setBackground(new Color(0x3C4DCE));
        buttonEnvoie.setForeground(Color.white);
        buttonEnvoie.setUI(new Home.StyledButtonUI());


        panelTop.add(toolbar, BorderLayout.NORTH);

        String[] batListe = r.listBat();
        JComboBox<String> listeBat = new JComboBox(batListe);
        listeBat.setBounds(10, 10, 120, 23);
        listeBat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                e.getSource();
                String s=(String) listeBat.getSelectedItem();
                createTabToReturn("BAT:/-/"+s);
                System.out.println(r.getPlace(s));
            }
        });
        panelTop.add(listeBat, BorderLayout.CENTER);

        frame.add(panel);

        panel.add(panelTop, BorderLayout.NORTH);
        panel.add(panelFormulaire, BorderLayout.CENTER);
        panel.add(buttonEnvoie, BorderLayout.SOUTH);


        frame.setSize(1000,800);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
