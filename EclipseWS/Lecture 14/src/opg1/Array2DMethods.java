package opg1;

public class Array2DMethods {
	public void print2DTable(int[][] array) {
		for (int[] d : array) {
			System.out.print("|");
			for (int i : d) {
				System.out.printf("%d|", i);
			}
			System.out.printf("%n");
		}
	}

	public void allFives(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				array[i][j] = 5;
			}
		}
	}

	public int sum(int[][] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				sum += array[i][j];
			}
		}
		return sum;
	}

	public void checkers(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (i % 2 == 0) {
					if (j % 2 == 0) {
						array[i][j] = 1;
					} else {
						array[i][j] = 0;
					}
				} else {
					if (j % 2 == 0) {
						array[i][j] = 0;
					} else {
						array[i][j] = 1;
					}
				}
			}
		}
	}
}
