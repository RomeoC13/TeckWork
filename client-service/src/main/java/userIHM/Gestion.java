package userIHM;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import static client.Client.getSend;
import static client.Client.map;

public class Gestion extends JPanel implements MouseListener {
    public boolean roomScreenSelected;
    public boolean roomPriseSelected;
    public Gestion() {
        setPreferredSize(new Dimension(750, 750));
        this.addMouseListener(this);
    }


    public void paint(Graphics g) {
        URL imgURL = Thread.currentThread().getContextClassLoader().getResource("planbureau.jpg");
        BufferedImage currentEquipment;
        try {
            currentEquipment = ImageIO.read(imgURL);
            g.drawImage(currentEquipment, 0, 0, 750, 750, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (roomScreenSelected) {
           drawPositions();
            revalidate();
        }
        if (roomPriseSelected) {
            drawPrisePosition();
            revalidate();
        }

    }

    public void drawPositions() {
        URL imgURL;
        BufferedImage currentEquipment;
        try {

            String id_room = WindowsMapping.getId_room();

            map.get("requestScreenIsEmpty").put("id_room", id_room);
            String responseScreenIsEmpty = getSend("requestScreenIsEmpty");
            String[] answers = responseScreenIsEmpty.split("@");
            for (String b : answers) {
                if (b.contains("@")) {
                    b.replace("@", "");
                }
                System.out.println(b);
            }

            if (!answers[0].contains("t")) {
                imgURL = Thread.currentThread().getContextClassLoader().getResource("localisation.png");
            } else {
                imgURL = Thread.currentThread().getContextClassLoader().getResource("écran.jpg");
            }
            currentEquipment = ImageIO.read(imgURL);
            getGraphics().drawImage(currentEquipment, 195, 460, 50, 50, null);

            imgURL = Thread.currentThread().getContextClassLoader().getResource("localisation.png");
            currentEquipment = ImageIO.read(imgURL);

            getGraphics().drawImage(currentEquipment, 550, 549, 50, 50, null);
            getGraphics().drawImage(currentEquipment, 99, 377, 50, 50, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawPrisePosition () {
        URL imgURL;
        BufferedImage currentEquipment;

        try {
            String id_room = WindowsMapping.getId_room();
            map.get("requestPriseIsEmpty").put("id_room", id_room);
            String responsePriseIsEmpty = getSend("requestPriseIsEmpty");
            String[] answers = responsePriseIsEmpty.split("@");
            for (String b : answers) {
                if (b.contains("@")) {
                    b.replace("@", "");
                }
                System.out.println(b);
            }
            if (!answers[0].contains("t")) {
                imgURL = Thread.currentThread().getContextClassLoader().getResource("localisation.png");
            } else {
                imgURL = Thread.currentThread().getContextClassLoader().getResource("prise.jpg");
            }
            currentEquipment = ImageIO.read(imgURL);
            getGraphics().drawImage(currentEquipment, 533, 201, 50, 50, null);

            imgURL = Thread.currentThread().getContextClassLoader().getResource("localisation.png");
            currentEquipment = ImageIO.read(imgURL);

            getGraphics().drawImage(currentEquipment, 550, 549, 50, 50, null);
            getGraphics().drawImage(currentEquipment, 99, 377, 50, 50, null);


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
        URL mapUrl = Thread.currentThread().getContextClassLoader().getResource("écran.jpg");
        if (e.getX() >= 195 & e.getX() <= 245 & e.getY() >= 460 & e.getY() <= 510) {
            //envoyer la requete si l'emplacement est occupé ou pas
            String id_room = WindowsMapping.getId_room();

            map.get("requestScreenIsEmpty").put("id_room", id_room);
            String responseScreenIsEmpty = getSend("requestScreenIsEmpty");
            String[] answers = responseScreenIsEmpty.split("@");
            for (String b : answers) {
                if (b.contains("@")) {
                    b.replace("@", "");
                }
                System.out.println(b);
            }


            if (!answers[0].contains("t")) {
                int responseScreen = JOptionPane.showConfirmDialog(null, " Voulez vous placer un écran?");
                if (responseScreen == JOptionPane.YES_OPTION) {


                    String valueChoose = "1";
                    map.get("requestUpdate").put("value", valueChoose);
                    map.get("requestUpdate").put("id_room", id_room);
                    String responseUpdate = getSend("requestUpdate");
                    answers = responseUpdate.split("@");
                    for (String b : answers) {
                        if (b.contains("@")) {
                            b.replace("@", "");
                        }
                        System.out.println(b);
                    }

                    try {
                        currentEquipment = ImageIO.read(mapUrl);
                        getGraphics().drawImage(currentEquipment, 195, 460, 50, 50, null);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            } else {
                int responseScreen = JOptionPane.showConfirmDialog(null, " Voulez vous supprimer un écran?");
                if (responseScreen == JOptionPane.YES_OPTION) {


                    String valueChoose = "0";
                    map.get("requestUpdate").put("value", valueChoose);
                    map.get("requestUpdate").put("id_room", id_room);
                    String responseUpdate = getSend("requestUpdate");
                    answers = responseUpdate.split("@");
                    for (String b : answers) {
                        if (b.contains("@")) {
                            b.replace("@", "");
                        }
                        System.out.println(b);
                    }

                    try {
                        URL imgURL = Thread.currentThread().getContextClassLoader().getResource("localisation.png");
                        currentEquipment = ImageIO.read(imgURL);
                        getGraphics().clearRect(195, 460, 50, 50);
                        getGraphics().drawImage(currentEquipment, 195, 460, 50, 50, null);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }

        }


        URL mapUrl2 = Thread.currentThread().getContextClassLoader().getResource("prise.jpg");
        if (e.getX() >= 533 & e.getX() <= 583 & e.getY() >= 201 & e.getY() <= 251) {

            String id_room = WindowsMapping.getId_room();

            map.get("requestPriseIsEmpty").put("id_room", id_room);
            String responsePriseIsEmpty = getSend("requestPriseIsEmpty");
            String[] answers = responsePriseIsEmpty.split("@");
            for (String b : answers) {
                if (b.contains("@")) {
                    b.replace("@", "");
                }
                System.out.println(b);
            }

            if (!answers[0].contains("t")) {
                int responsePrise = JOptionPane.showConfirmDialog(null, " Voulez vous placer une prise?");
                if (responsePrise == JOptionPane.YES_OPTION) {


                    String valueChoose = "1";
                    map.get("requestUpdatePrise").put("value", valueChoose);
                    map.get("requestUpdatePrise").put("id_room", id_room);
                    String responseUpdate = getSend("requestUpdatePrise");
                    answers = responseUpdate.split("@");
                    for (String b : answers) {
                        if (b.contains("@")) {
                            b.replace("@", "");
                        }
                        System.out.println(b);
                    }

                    try {
                        currentEquipment = ImageIO.read(mapUrl2);
                        getGraphics().drawImage(currentEquipment, 533, 201, 50, 50, null);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            } else {
                int responseScreen = JOptionPane.showConfirmDialog(null, " Voulez vous supprimer une prise?");
                if (responseScreen == JOptionPane.YES_OPTION) {


                    String valueChoose = "0";
                    map.get("requestUpdatePrise").put("value", valueChoose);
                    map.get("requestUpdatePrise").put("id_room", id_room);
                    String responseUpdate = getSend("requestUpdatePrise");
                    answers = responseUpdate.split("@");
                    for (String b : answers) {
                        if (b.contains("@")) {
                            b.replace("@", "");
                        }
                        System.out.println(b);
                    }

                    try {
                        URL imgURL = Thread.currentThread().getContextClassLoader().getResource("localisation.png");
                        currentEquipment = ImageIO.read(imgURL);
                        getGraphics().clearRect(533, 201, 50, 50);
                        getGraphics().drawImage(currentEquipment, 533, 201, 50, 50, null);
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }
            }

        }

        URL mapUrl1 = Thread.currentThread().getContextClassLoader().getResource("fenetre.jpg");
        if (e.getX() >= 550 & e.getX() <= 600 & e.getY() >= 549 & e.getY() <= 599) {

            int reponseFenetre = JOptionPane.showConfirmDialog(null, "Emplacement Fenêtre. Voulez vous continuer?");

            if (reponseFenetre == JOptionPane.YES_OPTION) {

                try {
                    currentEquipment = ImageIO.read(mapUrl1);
                    getGraphics().drawImage(currentEquipment, 550, 549, 50, 50, null);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }

        }

        URL mapUrl3 = Thread.currentThread().getContextClassLoader().getResource("capteur.jpg");
        if (e.getX() >= 99 & e.getX() <= 149 & e.getY() >= 377 & e.getY() <= 427) {

            int reponseCapteur = JOptionPane.showConfirmDialog(null, "Emplacement Fenêtre. Voulez vous continuer?");

            if (reponseCapteur == JOptionPane.YES_OPTION) {


                try {
                    currentEquipment = ImageIO.read(mapUrl3);
                    getGraphics().drawImage(currentEquipment, 99, 377, 50, 50, null);
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

