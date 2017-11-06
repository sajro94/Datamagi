package main;

import classes.*;

public class Main {

	public static void main(String[] args) {
		Person p1 = new Person("Jan", 24);
		Person p2 = new Person("Ben", 45);

		Gift g1 = new Gift("Lagkage");
		g1.setPrice(24.95);
		g1.setGiver(p2);
		Gift g2 = new Gift("Bordtennis");
		g2.setGiver(p2);
		g2.setPrice(299.95);
		Gift g3 = new Gift("Basket");
		g3.setPrice(399.95);
		g3.setGiver(p1);

		p1.addGift(g1);
		p1.addGift(g2);
		p2.addGift(g3);

		System.out.println(p1.getGivers());
		System.out.println(p2.getGivers());
	}

}
