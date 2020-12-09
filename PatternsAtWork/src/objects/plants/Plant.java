package objects.plants;

import java.awt.Color;

import objects.GameObject;

public abstract class Plant extends GameObject {

	private boolean isEddible;
	private int healthPoints = 10;

	public Plant(int representationSize, String name, int spawningLocationX, int spawningLokationY,
			Color color) {
		super(representationSize, name, spawningLocationX, spawningLokationY, color);
		// TODO Auto-generated constructor stub
	}

	public boolean isEddible() {
		return isEddible;
	}

	public void setEddible(boolean isEddible) {
		this.isEddible = isEddible;
	}

	public int getHealthPoints() {
		return healthPoints;
	}

	public void setHealthPoints(int healthPoints) {
		this.healthPoints = healthPoints;
	}

}
