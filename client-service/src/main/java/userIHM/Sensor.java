package userIHM;

public class Sensor {
    private int id_sensor;
    private boolean states_sensor;

    public Sensor(int id_sensor, boolean states_sensor) {
        this.id_sensor = id_sensor;
        this.states_sensor = states_sensor;
    }

    public int getId_sensor() {
        return id_sensor;
    }

    public void setId_sensor(int id_sensor) {
        this.id_sensor = id_sensor;
    }

    public boolean isStates_sensor() {
        return states_sensor;
    }

    public void setStates_sensor(boolean states_sensor) {
        this.states_sensor = states_sensor;
    }
}
