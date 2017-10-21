package opg1;

public class Array2DAPP {

	public static void main(String[] args) {
		int[][] arr = { { 3, 3, 1, 0, 1, 6 }, { 0, 0, 9, 7, 1, 6 }, { 5, 5, 9, 9, 1, 6 }, { 7, 1, 1, 1, 7, 6 },
				{ 1, 3, 5, 7, 9, 6 }, { 1, 3, 5, 7, 9, 6 } };
		Array2DMethods am = new Array2DMethods();
		am.print2DTable(arr);
		am.allFives(arr);
		am.print2DTable(arr);
		am.checkers(arr);
		am.print2DTable(arr);
		System.out.println(am.sum(arr));
	}

}
