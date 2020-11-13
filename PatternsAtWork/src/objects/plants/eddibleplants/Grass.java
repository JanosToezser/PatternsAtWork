package objects.plants.eddibleplants;

import java.awt.Color;

import objects.plants.Plant;

public class Grass extends Plant {

	public Grass(int representationSize, int spawningLocationX, int spawningLokationY) {
		super(representationSize, spawningLocationX, spawningLokationY, Color.YELLOW);
		this.setEddible(true);
	}

}
