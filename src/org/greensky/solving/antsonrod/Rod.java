package org.greensky.solving.antsonrod;

public class Rod {
	private Ant[] ants;
	private int time = 0;
	private int length;

	public Rod(int length, Ant[] ants) {
		this.setAnts(ants);
		for (Ant ant : ants) {
			ant.setRod(this);
		}
	}

	/**
	 * @return the ants
	 */
	public Ant[] getAnts() {
		return ants;
	}

	/**
	 * @param ants
	 *            the ants to set
	 */
	public void setAnts(Ant[] ants) {
		this.ants = ants;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	public void elapse() {
		for (Ant ant : ants) {

			if (ant.isOnRod())
				ant.move();

		}
		time++;
	}

	public int getAntNumber() {
		int antNumber = 0;
		for (Ant ant : ants) {
			if (ant.isOnRod()) {
				antNumber++;
			}
		}
		return antNumber;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}
}
