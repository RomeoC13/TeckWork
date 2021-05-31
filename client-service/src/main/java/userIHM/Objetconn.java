package userIHM;

public class Objetconn {
    private int id_objet;
    private int id_location;
    private boolean placed;

    public Objetconn(int id_objet, int id_location, boolean placed) {
        this.id_objet = id_objet;
        this.id_location = id_location;
        this.placed = placed;
    }

    public int getId_objet() {
        return id_objet;
    }

    public void setId_objet(int id_objet) {
        this.id_objet = id_objet;
    }

    public int getId_location() {
        return id_location;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setPlaced(boolean placed) {
        this.placed = placed;
    }
}
