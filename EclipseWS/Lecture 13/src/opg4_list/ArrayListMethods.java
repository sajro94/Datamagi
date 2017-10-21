package opg4_list;

import java.util.ArrayList;

public class ArrayListMethods {
	public void swapFirstLast(ArrayList<Integer> list) {
		int temp = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.set(list.size() - 1, temp);
	}

	public void shiftR(ArrayList<Integer> list) {
		list.add(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
	}

	public void replaceEvenWithZeros(ArrayList<Integer> list) {
		for (int i : list) {
			if (i % 2 == 0) {
				int ind = list.indexOf(i);
				list.set(ind, 0);
			}
		}
	}

	public int nextHigh(ArrayList<Integer> list) {
		int max = list.get(0);
		int next = list.get(0);
		int prev = list.get(0);
		for (int i : list) {
			if (i > max) {
				max = i;
				next = prev;
				prev = max;
			}
		}
		return next;
	}

	public boolean increasing(ArrayList<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) > list.get(i + 1)) {
				return false;
			}
		}
		return true;
	}

	public boolean hasDoublets(ArrayList<Integer> list) {
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i : list) {
			if (temp.contains(i)) {
				return true;
			} else {
				temp.add(i);
			}
		}
		return false;
	}
}
