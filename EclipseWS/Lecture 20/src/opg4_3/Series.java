package opg4_3;

import java.util.ArrayList;

public class Series {
	private String title;
	private ArrayList<String> cast;
	private ArrayList<Episode> episodes;

	public Series(String title, ArrayList<String> cast) {
		this.title = title;
		this.cast = cast;
	}

	public Episode createEpisode(ArrayList<String> guestCast, int lengthMinutes) {
		Episode e = new Episode(guestCast, lengthMinutes);
		episodes.add(e);
		return e;
	}

	public String getTitle() {
		return title;
	}

	public ArrayList<String> getCast() {
		return new ArrayList<>(cast);
	}

	public ArrayList<Episode> getEpisodes() {
		return new ArrayList<>(episodes);
	}

	public void removeEpisode(Episode e) {
		episodes.remove(e);
	}

	public int totalLength() {
		int totalLength = 0;
		for (Episode e : episodes) {
			totalLength += e.getLength();
		}
		return totalLength;
	}

}
