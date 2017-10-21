package opg4;

import java.util.Arrays;

public class ArrayTest {

	public static void main(String[] args) {
		int[] array1 = { 12, 15, 3, 10, 34, 18, 18 };
		int[] array2 = { 10, 12, 5, 23, 15, 11, 25 };
		int[] array3 = { 12, 16, 18, 42, 106, 48 };
		int[] array4 = { 12, 16, 17, 20, 18, 186, 2 };
		System.out.println(Arrays.toString(ArrayMethods.createSum(array1, array2)));
		System.out.println(ArrayMethods.sum(array1));
		System.out.println(ArrayMethods.sum(array2));
		System.out.println(ArrayMethods.sum(ArrayMethods.createSum(array1, array2)));
		System.out.println(ArrayMethods.hasOdd(array3));
		System.out.println(ArrayMethods.hasOdd(array4));

		System.out.println(Arrays.toString(array2));
		ArrayMethods.shiftR(array2);
		System.out.println(Arrays.toString(array2));
		System.out.println(ArrayMethods.hasDoublets(array2));
		ArrayMethods.replace0(array2);
		System.out.println(Arrays.toString(array2));
		System.out.println(ArrayMethods.nextHigh(array2));
		System.out.println(ArrayMethods.increasing(array2));
		System.out.println(ArrayMethods.hasDoublets(array1));

		ArrayMethods.mystery(array4);
		System.out.println(Arrays.toString(array4));

	}

}
