package opg3;

import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Player> players;

	public Team(String name) {
		this.name = name;
		players = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void addPlayer(Player p) {
		this.players.add(p);
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void printPlayers() {
		for (Player p : this.players) {
			System.out.printf("%02d: %-7s | %2s | %2s%n", players.indexOf(p), p.getName(), p.getAge(), p.getScore());
		}
	}

	public double calcAverageAge() {
		int sum = 0;
		for (Player p : players) {
			sum += p.getAge();
		}
		return (double) sum / (double) players.size();
	}

	public int calcTotalScore() {
		int totalScore = 0;
		for (Player p : players) {
			totalScore += p.getScore();
		}
		return totalScore;
	}

	public int calcOldPlayerScore(int ageLim) {
		int sum = 0;
		for (Player p : players) {
			if (p.getAge() >= ageLim) {
				sum += p.getScore();
			}
		}
		return sum;
	}

	public int maxScore() {
		int max = 0;
		for (Player p : players) {
			if (p.getScore() > max) {
				max = p.getScore();
			}
		}
		return max;
	}

	public String bestPlayer() {
		int max = 0;
		String best = "";
		for (Player p : players) {
			if (p.getScore() > max) {
				max = p.getScore();
				best = p.getName();
			}
		}
		return best;
	}
}
