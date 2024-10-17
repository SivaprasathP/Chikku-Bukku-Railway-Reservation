package com.chikkubukku.screens.cancel;

import java.util.Scanner;

public class CancelTicket {
	private CancelTicketViewModel cancelTicketViewModel;
	
	public CancelTicket() {
		cancelTicketViewModel=new CancelTicketViewModel(this);
	}

	public void getTicketDetailsToCancel() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Passanger ID:");
		int passangerID=scanner.nextInt();
		
		if(cancelTicketViewModel.cancelTicket(passangerID)) {
			System.out.println("Ticket Cancelled Successfully");
		}else {
			System.out.println("ERROR:Passanger ID does not exist");
		}
	}

}
