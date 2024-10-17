package com.chikkubukku.screens.booking;

import com.chikkubukku.dto.Passenger;
import com.chikkubukku.dataLayer.*;

class BookingViewModel {
	private Booking booking;

	public BookingViewModel(Booking booking) {
		this.booking=booking;
	}

	public int bookTicket(Passenger passenger) {
		return ChikkuBukkuRepository.getInstance().ticketBooking(passenger);
	}

	

}
