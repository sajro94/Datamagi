package opg2;

public class Child {
	private int age;
	private boolean boy;

	public Child(int age, boolean boy) {
		this.age = age;
		this.boy = boy;
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

	public String gender() {
		String result = "Girl";
		if (this.boy) {
			result = "Boy";
		}
		return result;
	}

	public String team() {
		String result = "";
		if (this.boy) {
			if (this.age < 8) {
				result = "Young Cubs";
			} else {
				result = "Cool Boys";
			}
		} else {
			if (this.age < 8) {
				result = "Tumbling Girls";
			} else {
				result = "Springy Girls";
			}
		}
		return result;
	}

	public String institution() {
		String result = "";
		if (this.age == 0) {
			result = "Home";
		} else if (this.age <= 2) {
			result = "Nursery";
		} else if (this.age <= 5) {
			result = "Kindergarten";
		} else if (this.age <= 16) {
			result = "School";
		} else {
			result = "Out of School";
		}
		return result;
	}

}
