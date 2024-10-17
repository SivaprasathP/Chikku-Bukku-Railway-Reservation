package com.chikkubukku;

import java.util.Scanner;

import com.chikkubukku.dataLayer.ChikkuBukkuRepository;
import com.chikkubukku.screens.booking.*;
import com.chikkubukku.screens.cancel.CancelTicket;
import com.chikkubukku.screens.printBookedTickets.PrintBookedTickets;

public class ChikkuBukku {

	public static void main(String[] args) {
		System.out.println("Welcome to Railway Reservation Booking");
		
		Scanner scanner=new Scanner(System.in);
		outer:while(true) {
			System.out.println("\n1.Book \n2.Cancel \n3.Print Booked Tickets \n4.Print Available Tickets \n5.Exit");
			System.out.println("Enter your choice:");
			int choice=scanner.nextInt();
			
			switch(choice) {
			case 1:
				Booking booking=new Booking();
				booking.getUserDetails();
				break;
			case 2:
				CancelTicket cancelTicket=new CancelTicket();
				cancelTicket.getTicketDetailsToCancel();
				break;
			case 3:
				PrintBookedTickets printTickets=new PrintBookedTickets();
				printTickets.displayTickets();
				break;
			case 4:
				PrintBookedTickets printAvailableTickets=new PrintBookedTickets();
				printAvailableTickets.displayAvailableTickets();
				break;
			case 5:
				break outer;
			}
		}
	}

}
