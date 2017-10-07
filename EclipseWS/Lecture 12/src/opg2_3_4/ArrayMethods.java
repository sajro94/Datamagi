package opg2_3_4;

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
}
