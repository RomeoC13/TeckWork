package ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Card extends JFrame {
    boolean rfidSensor = true;
    String cardRef = "1234A";
    String cardName = "CHATEL Romeo";
    String cardBat = "Batiment A";
    int page = 0;

    public Card() {
        super();
        this.setTitle("Welcome to techwork");
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Side_Menu sm = new Side_Menu();
        getContentPane().add(sm, BorderLayout.WEST);
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.LINE_AXIS));
        //card.setBackground(new Color(255, 255, 255, 255));
        JButton createButton = new JButton("Créer une nouvelle carte d’accès");
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Case if no card is detected
                if (!rfidSensor) {
                    popUpError("ERREUR : Pas de CARTE DÉTECTÉ", "Veuillez placer une carte devant le lecteur et ré essayer l’opération");
                    return;
                }

                //Case if an used card is detected
                if(!cardRef.equals(null)){
                    popUpError("ERREUR : Carte déjà utilisé","Veuillez placer une carte vierge devant le lecteur et ré essayer l'opération");
                }
                JPanel popUpPan = new JPanel(new GridLayout(0, 1));
                popUpPan.add(new JLabel("Rentez le nom du propriétaire de la carte :"));
                JTextField name = new JTextField("");
                popUpPan.add(name);
                popUpPan.add(new JLabel("Rentez l’identifiant de la carte : "));
                JTextField id = new JTextField("");
                popUpPan.add(id);
                popUpPan.add(new JLabel("Veuillez choisir à quel bâtiment donne accès la carte"));
                String[] items = {"Bâtiment Central", "Parking", "Bâtiment B"};
                JComboBox<String> batCombo = new JComboBox<String>(items);
                popUpPan.add(batCombo);
                int result = JOptionPane.showConfirmDialog(null, popUpPan, "Création d’une cartef", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    System.out.println(batCombo.getSelectedItem()
                            + " " + id.getText()
                            + " " + name.getText());
                } else {
                    System.out.println("Cancelled");
                }

            }
        });
        JButton modifyButton = new JButton("Modifier une carte d’accès");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Case if no card is detected
                if (!rfidSensor) {
                    popUpError("ERREUR : Pas de CARTE DÉTECTÉ", "Veuillez placer une carte devant le lecteur et ré essayer l’opération");
                    return;
                }

                //Case if a blank card is detected
                if(cardRef.equals(null)){
                    popUpError("ERREUR : Carte vierge","Veuillez placer une carte utilisé devant le lecteur et ré essayer l'opération");
                }
                JPanel popUpPan = new JPanel(new GridLayout(0, 1));
                popUpPan.add(new JLabel("Numéro d’identification de la carte :"));
                popUpPan.add(new JLabel(cardRef));
                popUpPan.add(new JLabel("Elle appartient à "));
                JTextField id = new JTextField(cardName);
                popUpPan.add(id);
                popUpPan.add(new JLabel("Vous pouvez modifier à quel bâtiment donne accès la carte"));
                String[] items = {cardBat, "Bâtiment Central", "Parking", "Bâtiment B"};
                JComboBox<String> batCombo = new JComboBox<String>(items);
                batCombo.setSelectedIndex(0);
                popUpPan.add(batCombo);
                int result = JOptionPane.showConfirmDialog(null, popUpPan, "Création d’une cartef", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    System.out.println(batCombo.getSelectedItem()
                            + " " + id.getText()
                            + " ");
                } else {
                    System.out.println("Cancelled");
                }
            }
        });
        JButton read_eqButton = new JButton("Consulter  la liste des accès équipements");
        read_eqButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel popUpPan = new JPanel();
                JTextField delete = new JTextField("supprimer");
                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                Object[][] data = {
                        {"1", "BALDE", "Door_A", delete},
                        {"2", "CHACHA", "Printer_B1", delete},
                        {"3", "CHATEL", "Light_C", delete},
                        {"4", "POINOT", "Printer_B5", delete},
                        {"5", "CHATEL", "Light_C", delete},
                        {"6", "CHATEL", "Light_C", delete},
                        {"7", "CHATEL", "Light_C", delete},
                        {"8", "CHATEL", "Light_C", delete},
                        {"9", "CHATEL", "Light_C", delete},
                        {"10", "CHATEL", "Light_C", delete},
                        {"11", "CHATEL", "Light_C", delete},
                        {"12", "CHATEL", "Light_C", delete},
                        {"13", "CHATEL", "Light_C", delete}
                };

                String[] columnNames = {"id", "nom", "Eq_name", ""};
                AtomicInteger page = new AtomicInteger(0);
                JTable table = new JTable(subTable(data, page.get(), 10), columnNames);
                DefaultTableModel tableModel = new DefaultTableModel(subTable(data, page.get(), 5), columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        //all cells false
                        return false;
                    }
                };
                table.setModel(tableModel);
                popUpPan.add(table, BorderLayout.CENTER);

                JButton nextButton = new JButton("Page avant");
                JButton prevButton = new JButton("Page suivante");
                nextButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (page.get() - 1 >= 0) {
                            page.set(page.get() - 1);
                            //System.out.println(page.get());
                            popUpPan.removeAll();
                            JTable table = new JTable(subTable(data, page.get(), 5), columnNames);
                            DefaultTableModel tableModel = new DefaultTableModel(subTable(data, page.get(), 5), columnNames) {
                                @Override
                                public boolean isCellEditable(int row, int column) {
                                    //all cells false
                                    return false;
                                }
                            };
                            table.setModel(tableModel);
                            popUpPan.add(table);
                            popUpPan.add(nextButton);
                            popUpPan.add(new JLabel(page.toString()));
                            popUpPan.add(prevButton);
                            popUpPan.updateUI();
                        }
                    }
                });
                prevButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        page.set(page.get() + 1);
                        //System.out.println(page.get());
                        popUpPan.removeAll();
                        JTable table = new JTable(subTable(data, page.get(), 5), columnNames);
                        DefaultTableModel tableModel = new DefaultTableModel(subTable(data, page.get(), 5), columnNames) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                //all cells false
                                return false;
                            }
                        };
                        table.setModel(tableModel);
                        popUpPan.add(table);
                        popUpPan.add(nextButton);
                        popUpPan.add(new JLabel(page.toString()));
                        popUpPan.add(prevButton);
                        popUpPan.updateUI();
                    }
                });
                popUpPan.add(prevButton, BorderLayout.PAGE_END);
                popUpPan.add(new JLabel(page.toString()), BorderLayout.PAGE_END);
                popUpPan.add(nextButton, BorderLayout.PAGE_END);
                JOptionPane.showConfirmDialog(null, popUpPan, "Création d’une cartef", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        });
        JButton read_BatButton = new JButton("Consulter la liste des accès bâtiment");
        read_BatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel popUpPan = new JPanel();


                Object[][] data = {
                        {"1", "BALDE", "Batiment A"},
                        {"2", "CHACHA", "Batiment B"},
                        {"3", "CHATEL", "Batiment C"},
                        {"4", "POINOT", "Batiment D"},
                        {"5", "CHATEL", "Batiment J"},
                        {"6", "CHATEL", "Batiment D"},
                        {"7", "CHATEL", "Batiment D"},
                        {"8", "CHATEL", "Batiment D"},
                        {"9", "CHATEL", "Batiment D"},
                        {"10", "CHATEL", "Batiment D"},
                        {"11", "CHATEL", "Batiment D"},
                        {"12", "CHATEL", "Batiment D"},
                        {"13", "CHATEL", "Batiment D"}
                };

                String[] columnNames = {"id", "nom", "Bat_name", ""};
                AtomicInteger page = new AtomicInteger(0);
                JTable table = new JTable(subTable(data, page.get(), 10), columnNames);
                DefaultTableModel tableModel = new DefaultTableModel(subTable(data, page.get(), 5), columnNames) {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        //all cells false
                        return false;
                    }
                };
                table.setModel(tableModel);
                popUpPan.add(table, BorderLayout.CENTER);

                JButton nextButton = new JButton("Page avant");
                nextButton.setMaximumSize(new Dimension(10, 10));
                JButton prevButton = new JButton("Page suivante");
                prevButton.setMaximumSize(new Dimension(10, 10));
                nextButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (page.get() - 1 >= 0) {
                            page.set(page.get() - 1);
                            //System.out.println(page.get());
                            popUpPan.removeAll();
                            JTable table = new JTable(subTable(data, page.get(), 5), columnNames);
                            DefaultTableModel tableModel = new DefaultTableModel(subTable(data, page.get(), 5), columnNames) {
                                @Override
                                public boolean isCellEditable(int row, int column) {
                                    //all cells false
                                    return false;
                                }
                            };
                            table.setModel(tableModel);
                            popUpPan.add(table);
                            popUpPan.add(nextButton);
                            popUpPan.add(new JLabel(page.toString()));
                            popUpPan.add(prevButton);
                            popUpPan.updateUI();
                        }
                    }
                });
                prevButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        page.set(page.get() + 1);
                        //System.out.println(page.get());
                        popUpPan.removeAll();
                        JTable table = new JTable(subTable(data, page.get(), 5), columnNames);
                        DefaultTableModel tableModel = new DefaultTableModel(subTable(data, page.get(), 5), columnNames) {
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                //all cells false
                                return false;
                            }
                        };
                        table.setModel(tableModel);
                        popUpPan.add(table);
                        popUpPan.add(nextButton);
                        popUpPan.add(new JLabel(page.toString()));
                        popUpPan.add(prevButton);
                        popUpPan.updateUI();
                    }
                });
                JButton deleteButton = new JButton("Suprimer la ligne séléctionnée");
                deleteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (table.getSelectedRow() != -1) {
                            tableModel.removeRow(table.getSelectedRow());
                            popUpSuccess("Succes", "La ligne à été supprimée avec succès");
                        }
                    }
                });
                popUpPan.add(nextButton, BorderLayout.PAGE_END);
                popUpPan.add(new JLabel(page.toString()), BorderLayout.PAGE_END);
                popUpPan.add(prevButton, BorderLayout.PAGE_END);
                JOptionPane.showConfirmDialog(null, popUpPan, "Création d’une carte", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            }
        });
        JButton addButton = new JButton("Ajouter un accès");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel popUpPan = new JPanel(new GridLayout(0, 1));
                JLabel addText = new JLabel("Rentez l’identifiant de la carte :");
                JTextField idTf = new JTextField("");
                JLabel chooseText = new JLabel("Choisir quel accès rajouter à cette carte :");
                String[] items = {"Bâtiment Central", "Parking", "Bâtiment B"};
                JComboBox<String> batCombo = new JComboBox<String>(items);

                popUpPan.add(addText);
                popUpPan.add(idTf);
                popUpPan.add(chooseText);
                popUpPan.add(batCombo);

                JOptionPane.showConfirmDialog(null, popUpPan, "Ajouter un accès", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);


            }
        });
        JButton deleteButton = new JButton("Consulter et modifier la liste des cartes");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });


        JLabel connectedLabel = new JLabel("actif", JLabel.CENTER);
        connectedLabel.setForeground(Color.green);
        JLabel unconnectedLabel = new JLabel("non actif", JLabel.CENTER);
        unconnectedLabel.setForeground(Color.red);
        JPanel rfidPan = new JPanel();
        rfidPan.add(new JLabel("Etat  lecteur RFID : "));
        if (rfidSensor)
            rfidPan.add(connectedLabel);
        else
            rfidPan.add(unconnectedLabel);

        //EVERYTHING HERE IS TEMPORARY
        JButton temp = new JButton("OK");
        rfidPan.add(temp);
        temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rfidSensor = !rfidSensor;
                //System.out.println(rfidSensor);
                rfidPan.removeAll();
                rfidPan.add(new JLabel("Etat  lecteur RFID : "));
                if (rfidSensor)
                    rfidPan.add(connectedLabel);
                else
                    rfidPan.add(unconnectedLabel);
                JButton temp = new JButton("OK");
                temp.addActionListener(this::actionPerformed);
                rfidPan.add(temp);
                rfidPan.updateUI();

            }
        });
        // END OF TEMP


        card.add(createButton);
        card.add(modifyButton);
        card.add(read_eqButton);
        card.add(read_BatButton);
        card.add(addButton);
        card.add(deleteButton);
        card.add(rfidPan);


        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        getContentPane().add(card, BorderLayout.CENTER);
        this.setVisible(true);
    }


    public void popUpSuccess(String title, String content) {
        JOptionPane.showMessageDialog(this,
                content,
                title,
                JOptionPane.INFORMATION_MESSAGE);

    }

    public void popUpError(String title, String error) {
        JOptionPane.showMessageDialog(this,
                error,
                title,
                JOptionPane.ERROR_MESSAGE);
    }

    /**
     * A function that is used to get subsequence of 2D array from page to page+numberPerPage
     *
     * @param data          2D array to subdivided
     * @param page          index of the first element of the subsequence
     * @param numberPerPage the number of object per subsequence
     * @return a subsequence with size of numberPerPage
     */
    public Object[][] subTable(Object[][] data, int page, int numberPerPage) {
        ArrayList<Object[]> subTable = new ArrayList<Object[]>();
        int index = 0;
        for (int j = (page * numberPerPage); j < Math.min(((page + 1) * numberPerPage), data.length); j++) {
            subTable.add(data[j]);
            index++;
            //System.out.println(data[j][0]);
        }

        Object[][] toReturn = new Object[subTable.size()][];
        for (int i = 0; i < subTable.size(); i++) {
            toReturn[i] = subTable.get(i);
        }

        return toReturn;
    }

    public static void main(String[] args) {
        Card f = new Card();
    }


}
