package opg4;

public class Tips {
	private int satisfaction;
	private int bill;

	public Tips(int s, int b) {
		this.satisfaction = s;
		this.bill = b;
	}

	public String tip() {
		if (this.satisfaction > 0 && this.satisfaction < 4) {
			int rate = 0;
			String sat = "";
			switch (this.satisfaction) {
			case 1:
				sat = "totally satisfied";
				rate = 20;
				break;
			case 2:
				sat = "satisfied";
				rate = 15;
				break;
			case 3:
				sat = "not satisfied";
				rate = 10;
				break;
			}
			double _rate = (double) rate / 100;
			double _tip = bill * _rate;
			int kr = (int) _tip;
			int øre = (int) (_tip * 100 - kr * 100);
			return "Your were " + sat + ". Please tip " + kr + " kr og " + øre + " øre.";
		} else {
			return "WHAT THE FUCK!?";
		}
	}
}
