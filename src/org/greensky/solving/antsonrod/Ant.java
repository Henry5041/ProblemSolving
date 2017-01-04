package org.greensky.solving.antsonrod;

public class Ant {
	private double position;
	private boolean faceFront;
	private Rod rod;
	private final int SPAN = 5;

	public Ant(double position, boolean faceFront) {
		this.setPosition(position);
		this.setFaceFront(faceFront);

	}

	/**
	 * @return the onRod
	 */
	public boolean isOnRod() {
		return (position > 0 && position < rod.getLength());
	}

	/**
	 * @return the position
	 */
	public double getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(double position) {
		this.position = position;
	}

	/**
	 * @return the faceFront
	 */
	public boolean isFaceFront() {
		return faceFront;
	}

	/**
	 * @param faceFront
	 *            the faceFront to set
	 */
	public void setFaceFront(boolean faceFront) {
		this.faceFront = faceFront;
	}

	public void move() {
		if (isOnRod()) {
			if (isOverlapping()) {
				this.reverse();
			}

			if (isFaceFront()) {
				position += SPAN;
			} else {
				position -= SPAN;
			}
			if (isOverlapping()) {
				this.reverse();
			}

		}

	}

	/**
	 * @return the rod
	 */
	public Rod getRod() {
		return rod;
	}

	/**
	 * @param rod
	 *            the rod to set
	 */
	public void setRod(Rod rod) {
		this.rod = rod;
	}

	public boolean isOverlapping() {
		for (Ant eachAnt : rod.getAnts()) {
			if (eachAnt != this && eachAnt.getPosition() == this.position) {
				return true;
			}
		}
		return false;
	}

	public void reverse() {
		this.setFaceFront(!isFaceFront());
	}
}
