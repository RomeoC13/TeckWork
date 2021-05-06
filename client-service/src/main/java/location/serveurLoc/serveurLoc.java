package location.serveurLoc;

import location.serveurLoc.JDBC;

public class serveurLoc {

    public String[] initPlan(String bat, String etage) {
        String[] tab;
        if(bat == "Batiment 1") {
            tab = new String[]{"Réservé", "Réservé", "Réservé", "Libre", "Réservé", "ibre", "Libre", "Libre", "Réservé",
                    "Réservé", "Réservé", "Réservé", "Libre", "Réservé", "Libre", "Libre", "Libre", "Réservé"};
        } else {
            tab = new String[]{"Libre", "Libre", "Libre", "Libre", "Réservé", "ibre", "Libre", "Libre", "Réservé",
                    "Réservé", "Réservé", "Réservé", "Libre", "Réservé", "Libre", "Libre", "Libre", "Réservé"};
        }
        return tab;
    }

    public String[] listBat() {
        String[] tab =  {"Batiment 1", "Batiment 2", "Batiment 3", "Batiment 4", "Batiment 5"};
        return tab;
    }

    public String[] listEtage() {
        String[] tab =  {"Etage 1", "Etage 2", "Etage 3", "Etage 4", "Etage 5", "Etage 6", "Etage 7"};
        return tab;
    }
}
