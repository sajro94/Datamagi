package sexDistribution;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class SexApp {

	// "http://athenaakademiet.danskforum.net/memberlist?mode=joined&order=DESC&start=0&username"

	public static void main(String[] args) throws IOException {
		int highestId = getHighestUserId(
				"http://athenaakademiet.danskforum.net/memberlist?mode=joined&order=DESC&start=0&username");
		System.out.println(highestId);
		int users = 0;
		int femas = 0;
		int males = 0;
		for (int i = 1; i <= highestId; i++) {
			String test = "";
			try {
				test = genderSexOfUser("http://athenaakademiet.danskforum.net/u" + i);
			} catch (IOException e) {
			}
			if (test.equals("Male")) {
				males++;
				users++;
			} else if (test.equals("Female")) {
				femas++;
				users++;
			}
		}
		System.out.printf("%s | %.2f%% mænd%n", males, (double) males / (double) users * 100.00);
		System.out.printf("%s | %.2f%% kvinder%n", femas, (double) femas / (double) users * 100.00);
		System.out.printf("%s | %.2f%% brugere%n", users, (double) users / (double) users * 100.00);
	}

	private static String genderSexOfUser(String url) throws IOException {
		Document doc;
		doc = Jsoup.connect(url).timeout(1200000).data("query", "Java").post();
		Elements genderFields = doc.select("dl");
		if (genderFields.size() > 0) {
			Elements genderImgs = genderFields.select("img");
			if (genderImgs.size() > 0) {
				return genderImgs.get(0).attr("title");
			} else {
				return "noGender";
			}

		} else {
			return "noUser";
		}
	}

	private static int getHighestUserId(String url) throws IOException {
		Document doc;
		doc = Jsoup.connect(url).get();
		Elements forumline = doc.select("table.forumline");
		Elements users = forumline.get(8).select("[href^=/u] ");
		return Integer.parseInt(users.get(0).attr("href").replaceAll("/u", ""));
	}

}
