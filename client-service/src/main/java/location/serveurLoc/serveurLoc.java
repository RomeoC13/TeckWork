package location.serveurLoc;

import location.serveurLoc.JDBC;

public class serveurLoc {
    static String[][] plan = new String[5][5];
    static String[] tabEtage = {"Etage 1", "Etage 2", "Etage 3", "Etage 4", "Etage 5"};
    static boolean bInit = true;
    static String planEtage = "";
    static String[] listeBat =  {"97 avenue de Pages, Paris 15", "658 rue Delaunay, Créteil", "58 boulevard Xavier Lefevre, Créteil", "84 boulevard Levy, Paris 11", "70 boulevard Brigitte Salmon, Paris 5"};
    
    public String[] initPlan(String bat, String etage) {
        String[] tab = new String[18];
        if(bat == listeBat[0]) {
            if(etage == tabEtage[0]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[0][0].split("-")[i];
                }
            } else if(etage == tabEtage[1]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[0][1].split("-")[i];
                }
            } else if(etage == tabEtage[2]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[0][2].split("-")[i];
                }
            } else if(etage == tabEtage[3]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[0][3].split("-")[i];
                }
            } else if(etage == tabEtage[4]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[0][4].split("-")[i];
                }
            }
        } else if (bat == listeBat[1]){
            if(etage == tabEtage[0]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[1][0].split("-")[i];
                }
            } else if(etage == tabEtage[1]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[1][1].split("-")[i];
                }
            } else if(etage == tabEtage[2]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[1][2].split("-")[i];
                }
            } else if(etage == tabEtage[3]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[1][3].split("-")[i];
                }
            } else if(etage == tabEtage[4]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[1][4].split("-")[i];
                }
            }
        } else if (bat == listeBat[2]){
            if(etage == tabEtage[0]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[2][0].split("-")[i];
                }
            } else if(etage == tabEtage[1]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[2][1].split("-")[i];
                }
            } else if(etage == tabEtage[2]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[2][2].split("-")[i];
                }
            } else if(etage == tabEtage[3]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[2][3].split("-")[i];
                }
            } else if(etage == tabEtage[4]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[2][4].split("-")[i];
                }
            }
        } else if (bat == listeBat[3]){
            if(etage == tabEtage[0]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[3][0].split("-")[i];
                }
            } else if(etage == tabEtage[1]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[3][1].split("-")[i];
                }
            } else if(etage == tabEtage[2]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[3][2].split("-")[i];
                }
            } else if(etage == tabEtage[3]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[3][3].split("-")[i];
                }
            } else if(etage == tabEtage[4]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[3][4].split("-")[i];
                }
            }
        } else if (bat == listeBat[4]){
            if(etage == tabEtage[0]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[4][0].split("-")[i];
                }
            } else if(etage == tabEtage[1]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[4][1].split("-")[i];
                }
            } else if(etage == tabEtage[2]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[4][2].split("-")[i];
                }
            } else if(etage == tabEtage[3]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[4][3].split("-")[i];
                }
            } else if(etage == tabEtage[4]) {
                for(int i = 0; i < 18; i++) {
                    tab[i] = plan[4][4].split("-")[i];
                }
            }
        }
        return tab;
    }

    public int getPlace(String bat) {
        int total = 0;
        if(bat == listeBat[0]) {
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 18; j++) {
                    if(plan[0][i].split("-")[j].equalsIgnoreCase("Libre")) {
                        total++;
                    }
                }
            }
        } else if(bat == listeBat[1]) {
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 18; j++) {
                    if(plan[1][i].split("-")[j].equalsIgnoreCase("Libre")) {
                        total++;
                    }
                }
            }
        } else if(bat == listeBat[2]) {
            System.out.println(bat);
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 18; j++) {
                    if(plan[2][i].split("-")[j].equalsIgnoreCase("Libre")) {
                        total++;
                    }
                }
            }
        } else if(bat == listeBat[3]) {
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 18; j++) {
                    if(plan[3][i].split("-")[j].equalsIgnoreCase("Libre")) {
                        total++;
                    }
                }
            }
        }  else if(bat == listeBat[4]) {
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 18; j++) {
                    if(plan[4][i].split("-")[j].equalsIgnoreCase("Libre")) {
                        total++;
                    }
                }
            }
        }
        System.out.println("AAAA : " + total);
        return total;
    }

    public String[] listBat() {
        return listeBat;
    }

    public String[] listEtage(String bat) {
        return tabEtage;
    }

    public String getNomBat(int i) {
        return listeBat[i];
    }

    public void init() {
        if(bInit) {
            for(int i = 0; i < 18; i++) {
                if(i != 17) {
                    planEtage += "Libre-";
                } else {
                    planEtage += "Libre";
                }

            }
            for(int i = 0; i < 5; i++) {
                for(int j = 0; j < 5; j++) {
                        plan[i][j] = planEtage;
                }
            }
            bInit = false;
        }
    }
}
