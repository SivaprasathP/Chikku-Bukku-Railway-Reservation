package com.chikkubukku.screens.printBookedTickets;

import java.util.Iterator;
import java.util.Queue;

import com.chikkubukku.dto.Passenger;

public class PrintBookedTickets {
	private PrintBookedTicketsViewModel printBookedTicketsViewModel;
	
	public PrintBookedTickets() {
		printBookedTicketsViewModel=new PrintBookedTicketsViewModel(this);
	}

	public void displayTickets() {
		System.out.println("Booked Tickets");
		System.out.println("===================================");

		System.out.println("Confirmed List");
		Queue<Passenger> confirmed=printBookedTicketsViewModel.getConfirmedTickets();
		Iterator<Passenger> iterator=confirmed.iterator();
		while(iterator.hasNext()) {
			Passenger passenger=iterator.next();
			System.out.println("Passenger ID:"+passenger.getPassengerID());
			System.out.println("Passenger Name:"+passenger.getPassengerName());
			System.out.println("Passenger Age:"+passenger.getPassengerAge());
			System.out.println("Passenger Gender:"+passenger.getGender());
			if(passenger.getPassengerAge()>5) {
				System.out.println("Allocated Berth:"+passenger.getAllocatedBerth());
			}
			System.out.println();
		}
		
		System.out.println("===================================");
		
		System.out.println("RAC List");
		Queue<Passenger> rac=printBookedTicketsViewModel.getRACTickets();
		iterator=rac.iterator();
		while(iterator.hasNext()) {
			Passenger passenger=iterator.next();
			System.out.println("Passenger ID:"+passenger.getPassengerID());
			System.out.println("Passenger Name:"+passenger.getPassengerName());
			System.out.println("Passenger Age:"+passenger.getPassengerAge());
			System.out.println("Passenger Gender:"+passenger.getGender());
			System.out.println();
		}
		
		System.out.println("===================================");

		
		System.out.println("Waiting List");
		Queue<Passenger> waiting=printBookedTicketsViewModel.getWaitingTickets();
		iterator=waiting.iterator();
		while(iterator.hasNext()) {
			Passenger passenger=iterator.next();
			System.out.println("Passenger ID:"+passenger.getPassengerID());
			System.out.println("Passenger Name:"+passenger.getPassengerName());
			System.out.println("Passenger Age:"+passenger.getPassengerAge());
			System.out.println("Passenger Gender:"+passenger.getGender());
			System.out.println();
		}
		
		System.out.println("===================================");

	}

	public void displayAvailableTickets() {
		System.out.println("Available Tickets");
		System.out.println("===================================");

		int[] availableConfirmed=printBookedTicketsViewModel.getAvailableConfirmed();
		System.out.println("Available Confirmed:"+availableConfirmed[0]+"\nAvailable Lower Berths:"+availableConfirmed[1]+"\nAvailable Middle Berths:"+availableConfirmed[2]+"\nAvailable Upper Berths:"+availableConfirmed[3]);
		
		System.out.println();
		
		System.out.println("Available RAC:"+printBookedTicketsViewModel.getAvailableRAC());
		
		System.out.println();
		
		System.out.println("Available Waiting:"+printBookedTicketsViewModel.getAvailableWaiting());
	}

}
