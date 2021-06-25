package ui.indicator;


import client.Client;

/***********
 * this class is to implement  the general indicators for each data
 *
 * his rule is to implement here all the information send by client
 * and to avoid plenty information in our event generalInformation button
 *
 *
 */
public class DataIndicator {

    public DataIndicator(){}
    public String getOccupancy(){return Client.getSend("rateOccupation"); }
    public String getConnectedObject(){ return Client.getSend("connectedObject");}
    public String getEquipment(){ return Client.getSend("allEquipment"); }
    public String getSensor(){return Client.getSend("allSensor");}
    public String getCompany(){return Client.getSend("allCompany"); }
    public String energyConsumption(){return Client.getSend("energyConsommation"); }

}
