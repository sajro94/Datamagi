package opg4_1;

import java.util.ArrayList;

public class Series {
	private String title;
	private ArrayList<String> cast;
	private ArrayList<Episode> episodes;

	public Series(String title, ArrayList<String> cast) {
		this.title = title;
		this.cast = cast;
	}

	public String getTitle() {
		return title;
	}

	public void addEpisode(Episode e) {
		episodes.add(e);
	}

	public ArrayList<String> getCast() {
		return new ArrayList<>(cast);
	}

	public ArrayList<Episode> getEpisodes() {
		return new ArrayList<>(episodes);
	}

}
