package opg2;

import java.util.ArrayList;

public class ArrayListMethodsAPP {

	public static void main(String[] args) {
		ArrayListMethods ar = new ArrayListMethods();
		ArrayList<Integer> list = new ArrayList<>();

		list.add(4);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(4);
		list.add(4);

		System.out.println(ar.min(list));
		System.out.println(ar.average(list));
		System.out.println(ar.numberOfZero(list));
		System.out.println(ar.aEvenList(list));

		ar.replaceEvenWithZeros(list);
		System.out.println(list);
	}

}
