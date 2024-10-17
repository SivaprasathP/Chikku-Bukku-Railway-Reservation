package com.chikkubukku.dataLayer;

import com.chikkubukku.dto.*;
import java.util.*;

public class ChikkuBukkuRepository {
	private static ChikkuBukkuRepository chikkuBukkuRepository;
	
	int availableLowerBerths=21;
	int availableMiddleBerths=21;
	int availableUpperBerths=21;
	int availableConfirm=63;
	int availableRAC=18;
	int availableWaiting=10;
	
	private Queue<Passenger> confirmed=new LinkedList<>();
	private Queue<Passenger> rac=new LinkedList<>();
	private Queue<Passenger> waiting=new LinkedList<>();
	
	
	
	private ChikkuBukkuRepository() {
		
	}
	
	public static ChikkuBukkuRepository getInstance() {
		if(chikkuBukkuRepository==null) {
			chikkuBukkuRepository=new ChikkuBukkuRepository();
		}
		return chikkuBukkuRepository;
	}
	

	public int ticketBooking(Passenger passenger) {
		if(passenger.getPassengerAge()<=5) {
			confirmed.add(passenger);
			return 1;
		}
		
		if(passenger.getPassengerAge()>=60) {
			if(availableLowerBerths>0) {
				passenger.setAllocatedBerth("L");
				availableLowerBerths--;
				availableConfirm--;
				return 1;
			}
		}
		if(availableConfirm>0) {
			if(passenger.getBerthPreference().equalsIgnoreCase("L") && availableLowerBerths>0) {
				passenger.setAllocatedBerth("L");
				availableLowerBerths--;
			}else if(passenger.getBerthPreference().equalsIgnoreCase("U") && availableUpperBerths>0) {
				passenger.setAllocatedBerth("U");
				availableUpperBerths--;
			}else if(passenger.getBerthPreference().equalsIgnoreCase("M") && availableMiddleBerths>0) {
				passenger.setAllocatedBerth("M");
				availableMiddleBerths--;
			}else if(availableLowerBerths>0) {
				passenger.setAllocatedBerth("L");
				availableLowerBerths--;
			}else if(availableUpperBerths>0) {
				passenger.setAllocatedBerth("U");
				availableUpperBerths--;
			}else if(availableMiddleBerths>0) {
				passenger.setAllocatedBerth("M");
				availableMiddleBerths--;
			}
			
			availableConfirm--;
			confirmed.add(passenger);
			return 1;
		}else if(availableRAC>0) {
			availableRAC--;
			rac.add(passenger);
			return 2;
		}else if(availableWaiting>0) {
			availableWaiting--;
			waiting.add(passenger);
			return 3;
		}
		
		return -1;
		
	}

	public boolean ticketCanceling(int passengerID) {
		Iterator<Passenger> iterator=confirmed.iterator();
		while(iterator.hasNext()) {
			Passenger passenger=iterator.next();
			if(passenger.getPassengerID()==passengerID) {
				iterator.remove();
				availableConfirm++;
				if(passenger.getAllocatedBerth().equals("L")) {
					availableLowerBerths++;
				}else if(passenger.getAllocatedBerth().equals("M")) {
					availableMiddleBerths++;
				}else if(passenger.getAllocatedBerth().equals("U")) {
					availableUpperBerths++;
				}
				moveFirstRACPassengerToConfirmed();
				return true;
			}
		}
		
		iterator=rac.iterator();
		while(iterator.hasNext()) {
			Passenger passenger=iterator.next();
			if(passenger.getPassengerID()==passengerID) {
				iterator.remove();
				availableRAC++;
				moveFirstWaitingListPassengerToRAC();
				return true;
			}
		}
		
		iterator=waiting.iterator();
		while(iterator.hasNext()) {
			Passenger passenger=iterator.next();
			if(passenger.getPassengerID()==passengerID) {
				iterator.remove();
				availableWaiting++;
				return true;
			}
		}
		
		return false;
	}

	private void moveFirstRACPassengerToConfirmed() {
		if(rac.isEmpty()) {
			return;
		}
		
		Passenger passenger=rac.poll();
		availableRAC++;
		ticketBooking(passenger);
		
		moveFirstWaitingListPassengerToRAC();
		
	}

	private void moveFirstWaitingListPassengerToRAC() {
		if(waiting.isEmpty()) {
			return;
		}
		
		Passenger passenger=waiting.poll();
		availableWaiting++;
		ticketBooking(passenger);
		
	}

	public Queue<Passenger> getConfirmed() {
		return confirmed;
	}
	
	public Queue<Passenger> getRAC() {
		return rac;
	}
	
	public Queue<Passenger> getWaiting() {
		return waiting;
	}

	public int[] getConfirmedAvailable() {
		int[] confirmedAvailable=new int[4];
		confirmedAvailable[0]=availableConfirm;
		confirmedAvailable[1]=availableLowerBerths;
		confirmedAvailable[2]=availableMiddleBerths;
		confirmedAvailable[3]=availableUpperBerths;

		return confirmedAvailable;
	}

	public int getRACAvailable() {
		return availableRAC;
	}

	public int getWaitingAvailable() {
		return availableWaiting;
	}
	
	
	

}
