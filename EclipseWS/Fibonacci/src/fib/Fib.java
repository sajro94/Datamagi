package fib;

public class Fib {
	private long[] seq;

	public long[] getSeq() {
		return seq;
	}

	public Fib() {
		this.seq = new long[100];
		this.seq[0] = 1;
		this.seq[1] = 1;
		generate();
	}

	public Fib(int start1, int start2, int length) {
		this.seq = new long[length];
		this.seq[0] = start1;
		this.seq[1] = start2;
		generate();
	}

	public void printFib() {
		for (int i = 0; i < seq.length; i++) {
			System.out.printf("%S: %S%n", i + 1, seq[i]);
		}
	}

	private void generate() {
		for (int i = 2; i < seq.length; i++) {
			seq[i] = seq[i - 1] + seq[i - 2];
		}
	}

}
