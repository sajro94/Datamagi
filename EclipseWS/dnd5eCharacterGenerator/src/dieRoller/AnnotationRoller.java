package dieRoller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import statGenerator.DieRoller;

public class AnnotationRoller {
	private final static String DEPTHREGEX = "\\((.*)\\)";
	private final static String ANNOTATIONREGEX = "^\\d{1,3}d(?:\\d{1,3}|\\(([^(]*)\\))(?:dl\\d{1,3}|r\\d{1,3})*$";
	private final static String ROLLREGEX = "^(\\d{1,3})(d)(\\d{1,3})(dl|r)?(\\d{1,3})?(dl)?(\\d{1,3})?$";

	public static int dieAnnotator(String annotation) throws BadAnnotationException {

		if (annotation.matches(ANNOTATIONREGEX)) {
			if (annotation.contains("(")) {
				Pattern pattern = Pattern.compile(DEPTHREGEX);
				Matcher matcher = pattern.matcher(annotation);
				int i = 1;
				while (matcher.find()) {
					String result = "" + dieAnnotator(matcher.group(i));
					annotation = annotation.replace("(" + matcher.group(i) + ")", result);
					i++;
				}
				return dieAnnotator(annotation);
			} else {
				String[] parts = annotationToArray(annotation);
				System.out.println(Arrays.toString(parts));
				int dies = Integer.parseInt(parts[0]);
				int size = Integer.parseInt(parts[2]);
				int drops = 0;
				int reroll = 0;
				if (parts.length > 4) {
					switch (parts[3]) {
					case "r":
						reroll = Integer.parseInt(parts[4]);
						break;
					case "dl":
						drops = Integer.parseInt(parts[4]);
						break;
					}
				}
				if (parts.length > 6) {
					drops = Integer.parseInt(parts[6]);
				}
				return DieRoller.dieRoller(1, size, dies, drops, reroll);

			}

		} else {
			throw new BadAnnotationException();
		}
	}

	private static String[] annotationToArray(String annotation) {
		Pattern pattern = Pattern.compile(ROLLREGEX);
		Matcher matcher = pattern.matcher(annotation);
		ArrayList<String> parts = new ArrayList<>();
		if (matcher.find()) {
			for (int i = 1; i <= matcher.groupCount(); i++) {
				if (matcher.group(i) != null) {
					parts.add(matcher.group(i));
				}
			}
		}
		String[] resultParts = new String[parts.size()];
		resultParts = parts.toArray(resultParts);
		return resultParts;
	}

}
