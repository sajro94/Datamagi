package opg1;

public class Summer {
	public int sum(int min, int max) {
		int i = min;
		int sum = 0;
		while (i < max) {
			sum += i;
			i++;
		}
		return sum;
	}

	public int sqrSum(int min, int max) {
		int i = min;
		int sum = 0;
		while (i < max) {
			sum += i * i;
			i++;
		}
		return sum;
	}

	public int sqrtSum(int min, int max) {
		int cap = (int) Math.floor(Math.sqrt(max));
		int butt = (int) Math.ceil(Math.sqrt(min));
		int i = butt;
		int sum = 0;
		while (i <= cap) {
			sum += i * i;
			i++;
		}
		return sum;
	}

	public int sumOdd(int min, int max) {
		int i = min;
		if (i % 2 == 1) {
			i++;
		}
		int sum = 0;
		while (i <= max) {
			sum += i;
			i += 2;
		}
		return sum;
	}

	public int crossSum(int num, boolean odd) {
		int test = 0;
		if (odd) {
			test = 1;
		}
		int sum = 0;
		String numS = String.valueOf(num);
		int i = 0;
		while (i < numS.length()) {
			int n = Character.getNumericValue(numS.charAt(i));
			if (n % 2 == test) {
				sum += n;
			}
			i++;
		}
		return sum;

	}

	public void binar(int min, int max) {
		int i = min;
		while (i <= max) {
			System.out.println("2^" + i + ": " + Math.pow(2, i));
			i++;
		}
	}
}
