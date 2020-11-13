package objects.plants;

import java.awt.Color;

import objects.GameObject;

public abstract class Plant extends GameObject {

	private boolean isEddible;

	public Plant(int representationSize, int spawningLocationX, int spawningLokationY,
			Color color) {
		super(representationSize, spawningLocationX, spawningLokationY, color);
		// TODO Auto-generated constructor stub
	}

	public boolean isEddible() {
		return isEddible;
	}

	public void setEddible(boolean isEddible) {
		this.isEddible = isEddible;
	}

}
