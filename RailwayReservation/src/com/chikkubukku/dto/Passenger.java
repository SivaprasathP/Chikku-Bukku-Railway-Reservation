package com.chikkubukku.dto;

public class Passenger {
	private static int passengerCount;
	private int passengerID;
	private String passengerName;
	private int passengerAge;
	private String gender;
	private String berthPreference;
	private String allocatedBerth;
	

	public Passenger(String passengerName, int passengerAge, String gender, String berthPreference) {
		this.passengerID = ++passengerCount;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.gender = gender;
		this.berthPreference = berthPreference;
	}

	public int getPassengerID() {
		return passengerID;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public int getPassengerAge() {
		return passengerAge;
	}

	public String getGender() {
		return gender;
	}

	public String getBerthPreference() {
		return berthPreference;
	}

	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setBerthPreference(String berthPreference) {
		this.berthPreference = berthPreference;
	}
	
	public String getAllocatedBerth() {
		return allocatedBerth;
	}

	public void setAllocatedBerth(String allocatedBerth) {
		this.allocatedBerth = allocatedBerth;
	}

	@Override
	public String toString() {
		return "Passenger ID=" + passengerID + "\nName=" + passengerName + "\nAge="
				+ passengerAge + "\nGender=" + gender ;
	}
	

}
