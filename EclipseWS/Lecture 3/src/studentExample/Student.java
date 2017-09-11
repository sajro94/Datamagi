package studentExample;

public class Student {
	private String name;
	private int totalScore;
	private int totalQuizzes;
	private double averageScore;

	public Student(String n) {
		this.name = n;
		this.totalQuizzes = 0;
		this.totalScore = 0;
	}

	public String getName() {
		return this.name;
	}

	public int getScore() {
		return this.totalScore;
	}

	public double getAverage() {
		return this.averageScore;
	}

	public void addQuiz(int s) {
		this.totalScore += s;
		this.totalQuizzes++;
		this.averageScore = this.totalScore / this.totalQuizzes;
	}

	@Override
	public String toString() {
		return "Average: " + this.averageScore + " - Total: " + this.totalScore;
	}
}
