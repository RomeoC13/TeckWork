package userIHM;

public class Room {
    private int id_room;
    private int id_floor;
    private boolean stats;

    public Room(int id_room, int id_floor, boolean stats) {
        this.id_room = id_room;
        this.id_floor = id_floor;
        this.stats = stats;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getId_floor() {
        return id_floor;
    }

    public void setId_floor(int id_floor) {
        this.id_floor = id_floor;
    }

    public boolean isStats() {
        return stats;
    }

    public void setStats(boolean stats) {
        this.stats = stats;
    }
}
