package application.model;

import java.util.ArrayList;

public class Hotel {

	private String name;
	private String address;
	private int roomSingle = 0;
	private int roomDouble = 0;
	private ArrayList<Participant> participants = new ArrayList<>();
	private double priceDouble;
	private double priceSingle;
	private ArrayList<ExtraService> extraServices = new ArrayList<>();

	public Hotel(String name, String address, double priceDouble, double priceSingle) {
		this.name = name;
		this.address = address;
		this.priceDouble = priceDouble;
		this.priceSingle = priceSingle;
	}

	public void addParticipant(Participant participant, boolean hasCompanion) {
		participants.add(participant);
		if (hasCompanion) {
			roomDouble++;
		} else {
			roomSingle++;
		}
	}

	public void addExtraService(ExtraService es) {
		extraServices.add(es);
	}

	public double getPriceSingle() {
		return priceSingle;
	}

	public double getPriceDouble() {
		return priceDouble;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public int getRoomSingle() {
		return roomSingle;
	}

	public int getRoomDouble() {
		return roomDouble;
	}

	public ArrayList<Participant> getParticipants() {
		return participants;
	}

	public ArrayList<ExtraService> getExtraServices() {
		return extraServices;
	}

}
