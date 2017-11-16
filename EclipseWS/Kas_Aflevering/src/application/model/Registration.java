package application.model;

import java.util.ArrayList;

public class Registration {

	private Participant participant;
	private Hotel hotel;
	private Companion companion;
	private ArrayList<ExtraService> extraServices = new ArrayList<>();
	private Conference conference;

	public Registration(Participant participant, Hotel hotel, Companion companion, Conference conference) {
		setParticipant(participant);
		setHotel(hotel);
		setCompanion(companion);
		setConference(conference);
	}

	private void setConference(Conference conference) {
		if (this.conference == null) {
			this.conference = conference;
			conference.addRegistration(this);
		} else {
			this.conference.removeRegistration(this);
			this.conference = conference;
			conference.addRegistration(this);
		}
	}

	public Participant getParticipant() {
		return participant;
	}

	public void setParticipant(Participant participant) {
		this.participant = participant;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
		if (this.hotel != null) {
			this.hotel.addParticipant(participant, companion != null);
		}
	}

	public Companion getCompanion() {
		return companion;
	}

	public void setCompanion(Companion companion) {
		this.companion = companion;
	}

	public ArrayList<ExtraService> getExtraService() {
		return extraServices;
	}

	public void setExtraService(ArrayList<ExtraService> extraServices) {
		this.extraServices = extraServices;
	}

	public Conference getConference() {
		return conference;
	}

	public double getTotalPrice() {
		double sum = 0.0;
		if (!participant.isLecturer()) {
			sum += participant.getParticipationDays() * conference.getPricePerDay();
		}
		if (hotel != null && companion != null) {
			sum += companion.getTripPrice();
			sum += hotel.getPriceDouble() * (participant.getParticipationDays() - 1);
		} else if (hotel != null) {
			sum += hotel.getPriceSingle() * (participant.getParticipationDays() - 1);
		}
		double extraServiceSum = 0.0;
		for (ExtraService e : extraServices) {
			extraServiceSum += e.getPrice();
		}
		sum += extraServiceSum * (participant.getParticipationDays() - 1);
		return sum;
	}

	public void addExtraService(ExtraService es) {
		extraServices.add(es);
	}

}