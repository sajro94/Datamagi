package opg4_5;

import java.util.ArrayList;

public class MainApp {

	public static void main(String[] args) {
		String[] cast = { "Flemming", "Dorthe", "Karsten", "Jens" };
		ArrayList<String> castList = new ArrayList<>();
		for (String s : cast) {
			castList.add(s);
		}
		Series s1 = new Series("Flemmings Helte", castList);
		ArrayList<String> g1 = new ArrayList<>();
		g1.add("Jørgen");
		ArrayList<String> g2 = new ArrayList<>();
		g2.add("Birthe");
		ArrayList<String> g3 = new ArrayList<>();
		g3.add("Lars");
		g3.add("Birthe");
		ArrayList<String> g4 = new ArrayList<>();
		g4.add("Bo");
		ArrayList<String> g5 = new ArrayList<>();
		g5.add("Egon");
		g5.add("Jørgen");
		s1.createEpisode(g1, 41);
		s1.createEpisode(g2, 46);
		s1.createEpisode(g3, 39);
		s1.createEpisode(g4, 43);
		s1.createEpisode(g5, 42);
		System.out.println(s1.getGuestActors());
		System.out.println(s1.totalLength());
	}

}
