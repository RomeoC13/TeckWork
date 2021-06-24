package ui.indicator;

import client.Client;

import java.sql.Connection;


/*******
 * this is a class for only the indicators by company and building, his rule is to get all the
 * information send by client to and make a method
 * using request for each indicator
 *
 * and it allows me make much clear the event of each button either company button or building button
 */

public class IndicOption {

	public IndicOption() {}

	/**********************for the company implementation*******************************/
	public String companyRate() {
		return Client.getSend("companyOccupation");
	}

	public String objectCompany() {
		return Client.getSend("CompanyConnectedObject");
	}

	public String equipmentCompany() {
		return Client.getSend("AllEquipmentCompany");
	}

	public String sensorCompany() {
		return Client.getSend("allSensorCompany");
	}

	public String energyCompany() {
		return Client.getSend("energyConsommationCompany");
	}
	public String buildingUse(){
		return Client.getSend("buildingUse");
	}
	public String usedBatiments(){
		return Client.getSend("usedBatiment");
	}

	/****************for the building implementation*********************/
	public String buildingRate() {
		return Client.getSend("rateBuilding");
	}

	public String objectBuilding() {
		return Client.getSend("objectBuilding");
	}

	public String equipmentBuilding() {
		return Client.getSend("equipmentBuilding");
	}

	public String sensorBuilding() {
		return Client.getSend("sensorBuilding");
	}

	public String companyInBuilding(){
		return Client.getSend("companyBuilding");
	}

	public String energyBuilding() {
		return Client.getSend("energyBuilding");
	}
	public String allFloor(){
		return Client.getSend("allFloor");
	}

}


