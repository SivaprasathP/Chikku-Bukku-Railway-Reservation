package com.chikkubukku.screens.booking;

import java.util.Scanner;

import com.chikkubukku.dto.Passenger;

public class Booking {
	private BookingViewModel bookingViewModel;
	
	public Booking() {
		bookingViewModel=new BookingViewModel(this);
	}

	public void getUserDetails() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Passenger Name:");
		String passengerName=scanner.next();
		System.out.println("Enter Passenger Age");
		int passengerAge=scanner.nextInt();
		System.out.println("Enter Passenger Gender");
		String gender=scanner.next();
		System.out.println("Enter Passenger preferred berth");
		String berthPreference=scanner.next();
		
		Passenger passenger=new Passenger(passengerName,passengerAge,gender,berthPreference);
		int bookingStatus=bookingViewModel.bookTicket(passenger);
		if(bookingStatus==1) {
			if(passenger.getPassengerAge()>5) {
				System.out.println("Allocated Berth : "+ passenger.getAllocatedBerth());
			}
			System.out.println("Ticket Confirmed");
			System.out.println(passenger);
		}else if(bookingStatus==2) {
			System.out.println("Your Ticket is at RAC");
			System.out.println(passenger);
		}else if(bookingStatus==3) {
			System.out.println("Your Ticket is at Waiting List");
			System.out.println(passenger);
		}else {
			System.out.println("Sorry.No tickets are available");
		}
	}

}
