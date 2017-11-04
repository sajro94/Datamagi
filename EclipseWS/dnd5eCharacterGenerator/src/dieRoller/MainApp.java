package dieRoller;

public class MainApp {

	public static void main(String[] args) throws BadAnnotationException {
		String test = "4d(5d6)dl1";
		System.out.println(AnnotationRoller.dieAnnotator(test));
	}

}
