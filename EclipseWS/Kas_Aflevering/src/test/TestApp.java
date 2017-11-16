package test;

import java.time.LocalDate;
import java.time.LocalTime;

import application.model.*;

public class TestApp {

	// Conference
	private static Conference conf;
	// Trips
	private static Trip trip1 = new Trip("Byrundtur, Odense", LocalTime.of(13, 30), 125.0, true, "Odense",
			LocalDate.of(2016, 4, 18));
	private static Trip trip2 = new Trip("Egeskov", LocalTime.of(11, 00), 75.0, false, "Egeskov",
			LocalDate.of(2016, 4, 19));
	private static Trip trip3 = new Trip("Trapholdt Museum, Kolding", LocalTime.of(12, 30), 200.0, true, "Kolding",
			LocalDate.of(2016, 4, 20));
	// Hotels
	private static Hotel hDHS = new Hotel("Den Hvide Svane", "Svanevej 25, 7600", 1250.0, 1050.0);
	private static Hotel hHP = new Hotel("Hotel Phoenix", "Phoenixvej 15, 7200", 800.0, 700.0);
	private static Hotel hPT = new Hotel("Pension Tusindfryd", "Tusindfrydsgade 11, 7600", 600.0, 500.0);
	// Extra Services
	private static ExtraService dhsWifi = new ExtraService("Wifi", 50.0);
	private static ExtraService hpBad = new ExtraService("Eget Bad", 200.0);
	private static ExtraService hpWifi = new ExtraService("Wifi", 75.0);
	private static ExtraService ptMad = new ExtraService("Morgenmad", 100.0);
	// Companions
	private static Companion mie = new Companion("Mie Sommer");
	private static Companion jan = new Companion("Jan Madsen");
	// Participants
	private static Participant finn = new Participant("Finn Madsen", "Adresse", "By", "Land", LocalDate.of(2016, 4, 18),
			null, false, "55556666", LocalDate.of(2016, 4, 20), null);
	private static Participant niels = new Participant("Niels Petersen", "Adresse", "By", "Land",
			LocalDate.of(2016, 4, 18), null, false, "55556666", LocalDate.of(2016, 4, 20), null);
	private static Participant peter = new Participant("Peter Sommer", "Adresse", "By", "Land",
			LocalDate.of(2016, 4, 18), null, false, "55556666", LocalDate.of(2016, 4, 20), null);
	private static Participant lone = new Participant("Lone Jensen", "Adresse", "By", "Land", LocalDate.of(2016, 4, 18),
			null, true, "55556666", LocalDate.of(2016, 4, 20), null);

	public static void main(String[] args) {
		conf = new Conference("Hav og Himmel", "Odense Universitet", LocalDate.of(2016, 4, 18),
				LocalDate.of(2016, 4, 20), 1500.0);
		conf.addTrip(trip1);
		conf.addTrip(trip2);
		conf.addTrip(trip3);

		hDHS.addExtraService(dhsWifi);
		hHP.addExtraService(hpBad);
		hHP.addExtraService(hpWifi);
		hPT.addExtraService(ptMad);

		conf.addHotel(hDHS);
		conf.addHotel(hHP);
		conf.addHotel(hPT);

		mie.addTrip(trip2);
		mie.addTrip(trip3);
		jan.addTrip(trip1);
		jan.addTrip(trip2);

		// Registrations
		Registration finnReg = new Registration(finn, null, null, conf);
		Registration nielsReg = new Registration(niels, hDHS, null, conf);
		Registration peterReg = new Registration(peter, hDHS, mie, conf);
		peterReg.addExtraService(dhsWifi);
		Registration loneReg = new Registration(lone, hDHS, jan, conf);
		loneReg.addExtraService(dhsWifi);

		System.out.println(finnReg.getTotalPrice());
		System.out.println(nielsReg.getTotalPrice());
		System.out.println(peterReg.getTotalPrice());
		System.out.println(loneReg.getTotalPrice());
	}

}
