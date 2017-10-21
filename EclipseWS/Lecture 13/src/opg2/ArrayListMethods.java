package opg2;

import java.util.ArrayList;

public class ArrayListMethods {
	public int min(ArrayList<Integer> list) {
		int min = list.get(0);
		for (int i : list) {
			if (i < min) {
				min = i;
			}
		}
		return min;
	}

	public double average(ArrayList<Integer> list) {
		int sum = 0;
		for (int i : list) {
			sum += i;
		}
		return (double) sum / (double) list.size();
	}

	public int numberOfZero(ArrayList<Integer> list) {
		int zeros = 0;
		for (int i : list) {
			if (i == 0) {
				zeros++;
			}
		}
		return zeros;
	}

	public void replaceEvenWithZeros(ArrayList<Integer> list) {
		for (int i : list) {
			if (i % 2 == 0) {
				int ind = list.indexOf(i);
				list.set(ind, 0);
			}
		}
	}

	public ArrayList<Integer> aEvenList(ArrayList<Integer> list) {
		ArrayList<Integer> result = new ArrayList<>();
		for (int i : list) {
			if (i % 2 == 0) {
				result.add(i);
			}
		}
		return result;
	}

}
