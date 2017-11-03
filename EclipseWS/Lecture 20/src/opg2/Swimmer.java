package opg2;

import java.util.*;

/**
 * Modeling a Swimmer
 */
public class Swimmer {
	private String name;
	private String club;
	private int yearGroup;
	private ArrayList<Double> lapTimes;

	/**
	 * Initialize a new swimmer with name, club, yearGroup, and lap times.
	 */

	public Swimmer(String name, int yearGroup, ArrayList<Double> lapTimes, String club) {
		this.name = name;
		this.yearGroup = yearGroup;
		this.lapTimes = lapTimes;
		this.club = club;
	}

	/**
	 * Return the name of the swimmer
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Return the yearGroup of the swimmer
	 */
	public int getYearGroup() {
		return this.yearGroup;
	}

	/**
	 * Return the club of the swimmer
	 */
	public String getClub() {
		return this.club;
	}

	/**
	 * Register the club of the swimmer
	 *
	 * @param club
	 */
	public void setClub(String club) {
		this.club = club;
	}

	/**
	 * Return the <i>fastest</i> lap time
	 */
	public double bestLapTime() {
		ArrayList<Double> lapTimesSorted = new ArrayList<>(lapTimes);
		Collections.sort(lapTimesSorted, (o1, o2) -> (int) (o1 - o2));
		return lapTimesSorted.get(0);
	}
}
