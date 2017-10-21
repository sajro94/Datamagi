import java.util.ArrayList;

public class ArrayListAPP {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("Hans");
		names.add("Viggo");
		names.add("Jens");
		names.add("Børge");
		names.add("Bent");
		System.out.println(names.size());
		names.add(2, "Jane");
		System.out.println(names);
		names.remove(1);
		names.add(0, "Pia");
		names.add("Ib");
		System.out.println(names.size());
		names.set(2, "Hansi");
		System.out.println(names.size());
		System.out.println(names);
		for (int i = 0; i < names.size(); i++) {
			System.out.printf("\"%s\" -> %s%n", names.get(i), names.get(i).length());
		}
		for (String s : names) {
			System.out.printf("\"%s\" -> %s%n", s, s.length());
		}

	}

}
