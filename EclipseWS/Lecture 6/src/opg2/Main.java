package opg2;

public class Main {

	public static void main(String[] args) {
		Child test = new Child(12, false);
		System.out.println(test.institution());
		System.out.println(test.gender());
		System.out.println(test.team());
	}

}
