package opg2;

public class MultipleChoiceApp {

	public static void main(String[] args) {
		MultipleChoice mc = new MultipleChoice(4);
		mc.printStudentAnswers();
		mc.printCorrectAnswersPrStudent();
		mc.printCorrectAnswerPrQuestion();
	}

}
