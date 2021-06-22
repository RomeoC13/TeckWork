package ui.indicator;

import client.Client;

import java.sql.Connection;

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


