package extbp;

import java.util.HashMap;
import java.util.Map;

public class DisabilityTable extends Disability {

	private Map<Integer, Disability> table;
	private int max = 0;

	public DisabilityTable(String name, int value, String desc) {
		super(name, value, desc);
		table = new HashMap<>();
	}

	public void addDisability(int weight, Disability dis) {
		table.put(max + weight, dis);
		max += weight;
	}

	public Map<Integer, Disability> getTable() {
		return table;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
