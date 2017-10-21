package opg4;

import java.util.Arrays;

public class ArrayMethods {
	public static int sum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}

	public static int[] createSum(int[] arrayA, int[] arrayB) {
		if (arrayA.length == arrayB.length) {
			int[] returnArray = new int[arrayA.length];
			for (int i = 0; i < arrayA.length; i++) {
				returnArray[i] = arrayA[i] + arrayB[i];
			}
			return returnArray;
		} else {
			return new int[0];
		}
	}

	public static boolean hasOdd(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 1) {
				return true;
			}
		}
		return false;
	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void swapFirstLast(int[] array) {
		swap(array, 0, array.length - 1);
	}

	public static void shiftR(int[] array) {
		int temp = array[array.length - 1];

		for (int i = array.length - 2; i >= 0; i--) {
			array[i + 1] = array[i];
		}
		array[0] = temp;
	}

	public static void replace0(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] % 2 == 0) {
				array[i] = 0;
			}
		}
	}

	public static void mystery(int[] array) {
		array = new int[5];
		array[0] = 12345;
		System.out.println(Arrays.toString(array));
	}

	public static int nextHigh(int[] array) {
		int max = Integer.MIN_VALUE;
		int next = Integer.MIN_VALUE;
		for (int i : array) {
			if (i > max) {
				next = max;
				max = i;
			} else if (i > next) {
				next = i;
			}
		}
		return next;
	}

	public static boolean increasing(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean hasDoublets(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int check = array[i];
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] == check) {
					return true;
				}
			}
		}
		return false;
	}
}
