package dnd5eCharacterGenerator;

public class Die {
	private String annotation;
	private int min;
	private int max;
	private int avg;
	private Double trueAvg;

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
