package child;

public class ChildApp {

	public static void main(String[] args) {
		Child child = new Child(2, false);
		System.out.println(String.format("Alder: %s", child.getAge()));
		String inst = child.institution();
		System.out.println(String.format("Institution: %s", inst));
		double[] arrayW = { 4.2, 9.3, 12.4, 17.5, 23.2, 25.3, 28.6, 30.4, 33.9 };
		Child cW = new Child(8, true, arrayW);
		System.out.println(cW.biggestWeightGain());
		Child c1 = new Child(2, false);
		Child c2 = new Child(5, true);
		Child c3 = new Child(6, true);
		Child c4 = new Child(7, true);
		Child c5 = new Child(8, false);
		Child c6 = new Child(12, true);
		Child c7 = new Child(7, false);

		Institution i1 = new Institution("Solgården", "Solgårdsvej 12");
		i1.addChild(c1);
		i1.addChild(c2);
		i1.addChild(c3);
		i1.addChild(c4);
		i1.addChild(c5);
		i1.addChild(c6);
		i1.addChild(c7);
		System.out.printf("Gennemsnits alderen for institutionen %s er %s.\n", i1.getName(), i1.averageAge());
		System.out.printf("Der er %s piger og %s drenge på adressen %s.\n", i1.girlsCount(), i1.boysCount(),
				i1.getAdress());
	}

}
