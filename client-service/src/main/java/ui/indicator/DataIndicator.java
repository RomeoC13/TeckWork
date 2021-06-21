package ui.indicator;


import client.Client;

public class DataIndicator {

    public DataIndicator(){}
    public String getOccupancy(){return Client.getSend("rateOccupation"); }
    public String getConnectedObject(){
        return Client.getSend("connectedObject");
    }
    public String getEquipment(){
        return Client.getSend("allEquipment");
    }
    public String getSensor(){return Client.getSend("allSensor");}
    public String getCompany(){return Client.getSend("allCompany"); }
    public String energyConsumption(){return Client.getSend("energyConsommation"); }

}
