package dnd5eCharacterGenerator;

public class Die {
	private String annotation;
	private int min;
	private int max;
	private int avg;
	private Double trueAvg;
	static final Die D4 = new Die("d4", 1, 4);
	static final Die D6 = new Die("d6", 1, 6);
	static final Die D8 = new Die("d8", 1, 8);
	static final Die D10 = new Die("d10", 1, 10);
	static final Die D12 = new Die("d12", 1, 12);
	static final Die D20 = new Die("d20", 1, 20);
	static final Die D100 = new Die("d100", 1, 100);

	public Die(String annotation, int min, int max) {
		this.annotation = annotation;
		this.min = min;
		this.max = max;
		this.avg = (int) Math.ceil((double) (min + max) / 2.0);
		this.trueAvg = (double) (min + max) / 2.0;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getAvg() {
		return avg;
	}

	public void setAvg(int avg) {
		this.avg = avg;
	}

	public Double getTrueAvg() {
		return trueAvg;
	}

	public void setTrueAvg(Double trueAvg) {
		this.trueAvg = trueAvg;
	}

}
