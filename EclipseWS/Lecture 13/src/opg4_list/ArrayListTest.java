package opg4_list;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		ArrayListMethods alm = new ArrayListMethods();
		ArrayList<Integer> list = new ArrayList<>();

		list.add(2);
		list.add(3);
		list.add(5);
		list.add(4);
		list.add(6);
		list.add(0);
		list.add(4);
		System.out.println(alm.hasDoublets(list));

		System.out.println(list);
		alm.swapFirstLast(list);
		System.out.println(list);
		alm.shiftR(list);
		System.out.println(list);
		alm.replaceEvenWithZeros(list);
		System.out.println(list);
		System.out.println(alm.increasing(list));
		System.out.println(alm.nextHigh(list));
	}

}
