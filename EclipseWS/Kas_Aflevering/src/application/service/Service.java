package application.service;

import java.time.LocalDate;
import java.time.LocalTime;

import application.model.Companion;
import application.model.Conference;
import application.model.ExtraService;
import application.model.Hotel;
import application.model.Participant;
import application.model.Registration;
import application.model.Trip;
import storage.Storage;

public class Service {

	// ----------------------Companion-------------------
	public static Companion createCompanion(String name) {
		Companion companion = new Companion(name);

		Storage.addCompanions(companion);
		return companion;
	}

	public static void deleteCompanion(Companion companion) {
		Storage.removeCompanion(companion);
	}

	// ----------------------Conference-------------------
	public static Conference createConference(String name, String location, LocalDate startDate, LocalDate endDate,
			double pricePerDay) {
		Conference conference = new Conference(location, location, endDate, endDate, pricePerDay);

		Storage.addConference(conference);
		return conference;
	}

	public static void deleteConference(Conference conference) {
		Storage.removeConference(conference);
	}

	// ----------------------ExtraService-------------------
	public static ExtraService createExtraService(String name, double price) {
		ExtraService extraService = new ExtraService(name, price);

		Storage.addExtraService(extraService);
		return extraService;
	}

	public static void deleteExtraService(ExtraService extraService) {
		Storage.removeExtraService(extraService);
	}

	// ----------------------Hotel-------------------
	public static Hotel createHotel(String name, String address, double priceDouble, double priceSingle) {
		Hotel hotel = new Hotel(name, address, priceDouble, priceSingle);

		Storage.addHotel(hotel);
		return hotel;
	}

	public static Hotel createHotel(Hotel hotel) {
		String name = hotel.getName();
		String address = hotel.getAddress();
		double priceDouble = hotel.getPriceDouble();
		double priceSingle = hotel.getPriceSingle();
		Hotel hotelNew = new Hotel(name, address, priceDouble, priceSingle);
		Storage.addHotel(hotelNew);
		return hotelNew;
	}

	public static void deleteHotel(Hotel hotel) {
		Storage.removeHotel(hotel);
	}

	// ----------------------Participant-------------------
	public static Participant createParticipant(String name, String address, String city, String country,
			LocalDate arrival, String firm, boolean lecturer, String phone, LocalDate departure, String firmPhone) {

		Participant participant = new Participant(name, address, city, country, arrival, firm, lecturer, phone,
				departure, firmPhone);
		Storage.addParticipant(participant);
		return participant;

	}

	public static void deleteParticipant(Participant participant) {
		Storage.removeParticipant(participant);
	}

	// ----------------------Registration-------------------
	public static Registration createRegistration(Participant participant, Hotel hotel, Companion companion,
			Conference conference) {
		Registration registration = new Registration(participant, hotel, companion, conference);
		Storage.addRegistration(registration);

		return registration;
	}

	public static void deleteRegistration(Registration registration) {
		Storage.removeRegistration(registration);
	}

	// ----------------------Trip-------------------
	public static Trip createTrip(String name, LocalTime time, double price, boolean includesLunch, String location,
			LocalDate date) {
		Trip trip = new Trip(name, time, price, includesLunch, location, date);
		Storage.addTrip(trip);
		return trip;
	}

	public static void deleteTrip(Trip trip) {
		Storage.removeTrip(trip);
	}

}