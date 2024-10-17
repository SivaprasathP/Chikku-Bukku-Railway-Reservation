package com.chikkubukku.screens.cancel;

import com.chikkubukku.dataLayer.ChikkuBukkuRepository;

class CancelTicketViewModel {
	private CancelTicket cancelTicket;

	public CancelTicketViewModel(CancelTicket cancelTicket) {
		this.cancelTicket=cancelTicket;
	}

	public boolean cancelTicket(int passangerID) {
		return ChikkuBukkuRepository.getInstance().ticketCanceling(passangerID);
	}

}
