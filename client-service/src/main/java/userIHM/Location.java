package userIHM;

public class Location {
    private int id_location;
    private int id_room;
    private boolean occupied;

    public Location(int id_location, int id_room, boolean occupied) {
        this.id_location = id_location;
        this.id_room = id_room;
        this.occupied = occupied;
    }

    public int getId_location() {
        return id_location;
    }


    public void setId_location(int id_location) {
        this.id_location = id_location;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }
}
