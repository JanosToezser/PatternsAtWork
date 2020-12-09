package objects.plants.eddibleplants;

import java.awt.Color;

import objects.plants.Plant;

public class Grass extends Plant {

	public Grass(int representationSize, String name, int spawningLocationX,
			int spawningLokationY) {
		super(representationSize, name, spawningLocationX, spawningLokationY, Color.YELLOW);
		this.setEddible(true);
	}

}
