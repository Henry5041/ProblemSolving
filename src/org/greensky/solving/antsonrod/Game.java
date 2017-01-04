package org.greensky.solving.antsonrod;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] positions = new int[] { 30, 80, 110, 160, 250 };


		for (int i = 0; i < 32; i++) {
			String bin = Integer.toBinaryString(i);
			char[] chars = bin.toCharArray();
			boolean[] booleans = new boolean[5];
			for (int j = 0; j < chars.length; j++) {

				switch (chars[j]) {
				case '0':
					booleans[j] = false;
					break;
				case '1':
					booleans[j] = true;
				}
			}

			for (int j = 0; j < 5; j++) {
				System.out.print(booleans[j] + " ");
			}
			System.out.println(count(positions, booleans));
		}

	}

	public static int count(int[] positions, boolean[] directions) {
		Ant[] ants = new Ant[positions.length];
		for (int i = 0; i < directions.length; i++) {
			ants[i] = new Ant(positions[i], directions[i]);
		}
		Rod rod = new Rod(300,ants);
		while (rod.getAntNumber() != 0) {
			rod.elapse();
			// for (Ant ant : rod.getAnts()) {
			// System.out.print(ant.getPosition() + " ");
			//
			// }
			// System.out.println();

		}

		return rod.getTime();

	}
}
