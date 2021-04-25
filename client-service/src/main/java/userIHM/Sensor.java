package userIHM;

public class Sensor {
    private String room;
    private int number;
    private  String states;

    public Sensor (String room, int number, String states) {
        this.room = room;
        this.number = number;
        this.states = states;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }
    public String toString() {
        return "Nom de la salle du capteur: " + room +"\n Numéro :" +number+ "\n States :" +states;
    }
}
