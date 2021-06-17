package ui.indicator;


import client.Client;

public class DataIndicator {

    public DataIndicator(){}
    public String getOccupancy(){
        String values = Client.getSend("rateOccupation");

        return values;
    }
    public String getConnectedObject(){
        return Client.getSend("connectedObject");
    }
    public String getEquipment(){
        return Client.getSend("allEquipment");
    }
    public String getSensor(){
        String values = Client.getSend("allSensor");
        return values;
    }
    public String getCompany(){
        String values = Client.getSend("allCompany");
        return values;
    }

    public String energyConsumption(){
        String values = Client.getSend("energyConsommation");
        return values;
    }

}
