package opg3;

import java.util.Arrays;

public class TeamTest {

	public static void main(String[] args) {
		Player p1 = new Player("Karsten", 18);
		Player p2 = new Player("Karen", 19);
		Player p3 = new Player("Jens", 22);
		Player p4 = new Player("Bob", 12);
		Player p5 = new Player("Ib", 13);
		p1.addScore(3);
		p2.addScore(5);
		p3.addScore(2);
		p4.addScore(4);
		p5.addScore(1);

		Team t1 = new Team("Bullhogs");
		t1.addPlayer(p1);
		t1.addPlayer(p2);
		t1.addPlayer(p3);
		t1.addPlayer(p4);
		t1.addPlayer(p5);

		t1.printPlayers();
		System.out.println(t1.calcAverageAge());
		System.out.println(t1.calcTotalScore());
		System.out.println(t1.calcOldPlayerScore(18));
		System.out.printf("Best Player: %s with %s points%n", t1.bestPlayer(), t1.maxScore());

		int[][] matrix = new int[5][3];
		System.out.println(Arrays.toString(matrix));
	}

}
