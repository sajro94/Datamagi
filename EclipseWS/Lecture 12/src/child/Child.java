package child;

import java.util.Arrays;

/**
 * A child with a gender and an age.
 */
public class Child {
	private int age;
	private boolean boy;
	private double[] weights;

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
		weights = new double[11];
	}

	public Child(int age, boolean boy, double[] array) {
		this.age = age;
		this.boy = boy;
		this.weights = Arrays.copyOf(array, 11);
	}

	public double getWeight(int age) {
		if (age < 11) {
			return weights[age];
		} else {
			return 123456789;
		}
	}

	public double biggestWeightGain() {
		double gain = weights[1] - weights[0];
		for (int i = 1; i < age + 1; i++) {
			double diff = weights[i + 1] - weights[i];
			if (diff > gain) {
				gain = diff;
			}
		}
		return gain;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBoy() {
		return this.boy;
	}

	public void setBoy(boolean boy) {
		this.boy = boy;
	}

	public String institution() {
		String institution = "Home";
		if (this.age < 3) {
			institution = "Nursery";
		} else if (this.age < 6) {
			institution = "Kindergarten";
		} else if (this.age < 17) {
			institution = "School";
		} else if (this.age > 16) {
			institution = "Out of school";
		}
		return institution;
	}

	public String gender() {
		if (this.boy) {
			return "Boy";
		} else {
			return "Girl";
		}
	}

	public String team() {
		if (this.age < 8) {
			if (this.boy) {
				return "Young cubs";
			} else {
				return "Tumbling girls";
			}
		} else {
			if (this.boy) {
				return "Cool boys";
			} else {
				return "Springy girls";
			}
		}
	}
}
