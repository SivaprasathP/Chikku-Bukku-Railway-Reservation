package com.chikkubukku.screens.printBookedTickets;

import java.util.Queue;

import com.chikkubukku.dataLayer.ChikkuBukkuRepository;
import com.chikkubukku.dto.Passenger;

public class PrintBookedTicketsViewModel {
	private PrintBookedTickets printBookedTickets;
	
	PrintBookedTicketsViewModel(PrintBookedTickets printBookedTickets){
		this.printBookedTickets=printBookedTickets;
	}

	public Queue<Passenger> getConfirmedTickets() {
		return ChikkuBukkuRepository.getInstance().getConfirmed();
	}

	public Queue<Passenger> getRACTickets() {
		return ChikkuBukkuRepository.getInstance().getRAC();
	}

	public Queue<Passenger> getWaitingTickets() {
		return ChikkuBukkuRepository.getInstance().getWaiting();
	}

	public int[] getAvailableConfirmed() {
		return ChikkuBukkuRepository.getInstance().getConfirmedAvailable();
	}

	public int getAvailableRAC() {
		return ChikkuBukkuRepository.getInstance().getRACAvailable();
	}

	public int getAvailableWaiting() {
		return ChikkuBukkuRepository.getInstance().getWaitingAvailable();
	}
}
