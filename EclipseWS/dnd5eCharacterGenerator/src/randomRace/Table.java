package randomRace;

import java.util.HashMap;
import java.util.Map;

public class Table {
	Map<Integer, RacialFeature> table;
	int roll;
	Die die;

	public Table() {
		table = new HashMap<>();
		roll = 0;
	}

	public void addResult(int weight, RacialFeature rf) {
		roll += weight;
		table.put(roll, rf);
	}

}
