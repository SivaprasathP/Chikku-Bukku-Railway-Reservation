package com.chikkubukku.dto;

public class Tickets {
	private int passengerID;
	private String allocatedBerth;
	private String ticketType;
	
	
	public Tickets(int passengerID, String allocatedBerth, String ticketType) {
		this.passengerID = passengerID;
		this.allocatedBerth = allocatedBerth;
		this.ticketType = ticketType;
	}


	public int getPassengerID() {
		return passengerID;
	}


	public String getAllocatedBerth() {
		return allocatedBerth;
	}


	public String getTicketType() {
		return ticketType;
	}


	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}


	public void setAllocatedBerth(String allocatedBerth) {
		this.allocatedBerth = allocatedBerth;
	}


	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	
	

}
