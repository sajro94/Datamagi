package storage;

import java.util.ArrayList;

import application.model.Companion;
import application.model.Conference;
import application.model.ExtraService;
import application.model.Hotel;
import application.model.Participant;
import application.model.Registration;
import application.model.Trip;

public class Storage {
	private static ArrayList<Companion> companions = new ArrayList<>();
	private static ArrayList<Conference> conferences = new ArrayList<>();
	private static ArrayList<ExtraService> extraServices = new ArrayList<>();
	private static ArrayList<Hotel> hotels = new ArrayList<>();
	private static ArrayList<Participant> participants = new ArrayList<>();
	private static ArrayList<Registration> registrations = new ArrayList<>();
	private static ArrayList<Trip> trips = new ArrayList<>();

	// ---------------------Companion-------------------------

	public static ArrayList<Companion> getCompanion() {
		return new ArrayList<>(companions);
	}

	public static void addCompanions(Companion companion) {
		companions.add(companion);
	}

	public static void removeCompanion(Companion companion) {
		companions.remove(companion);
	}

	// --------------------Conference-------------------------

	public static ArrayList<Conference> getConference() {
		return new ArrayList<>(conferences);
	}

	public static void addConference(Conference conference) {
		conferences.add(conference);
	}

	public static void removeConference(Conference conference) {
		conferences.remove(conference);
	}

	// --------------------ExtraService-------------------------

	public static ArrayList<ExtraService> getExtraService() {
		return new ArrayList<>(extraServices);
	}

	public static void addExtraService(ExtraService extraService) {
		extraServices.add(extraService);
	}

	public static void removeExtraService(ExtraService extraService) {
		extraServices.remove(extraService);
	}

	// --------------------Hotel-------------------------

	public static ArrayList<Hotel> getHotels() {
		return new ArrayList<>(hotels);
	}

	public static void addHotel(Hotel hotel) {
		hotels.add(hotel);
	}

	public static void removeHotel(Hotel hotel) {
		hotels.remove(hotel);
	}

	// --------------------Participant-------------------------

	public static ArrayList<Participant> getParticipant() {
		return new ArrayList<>(participants);
	}

	public static void addParticipant(Participant participant) {
		participants.add(participant);
	}

	public static void removeParticipant(Participant participant) {
		participants.remove(participant);
	}

	// --------------------Registration-------------------------

	public static ArrayList<Registration> getRegistrations() {
		return new ArrayList<>(registrations);
	}

	public static void addRegistration(Registration registration) {
		registrations.add(registration);
	}

	public static void removeRegistration(Registration registration) {
		registrations.remove(registration);
	}

	// --------------------Trip-------------------------

	public static ArrayList<Trip> getTrip() {
		return new ArrayList<>(trips);
	}

	public static void addTrip(Trip trip) {
		trips.add(trip);
	}

	public static void removeTrip(Trip trip) {
		trips.add(trip);
	}

}