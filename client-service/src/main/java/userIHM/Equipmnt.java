package userIHM;

public class Equipmnt {
    private String bat;
    private int floor;
    private  String stat;

    @Override
    public String toString() {
        return "Equipment{" +
                "bat='" + bat + '\'' +
                ", floor=" + floor +
                ", stat='" + stat + '\'' +
                '}';
    }

    public String getBat() {
        return bat;
    }

    public void setBat(String bat) {
        this.bat = bat;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public Equipmnt(String bat, int floor, String stat) {
        this.bat = bat;
        this.floor = floor;
        this.stat = stat;
    }
}
