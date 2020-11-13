package objects.plants.eddibleplants;

import java.awt.Color;

import objects.plants.Plant;

public class Kale extends Plant {

	public Kale(int representationSize, int spawningLocationX, int spawningLokationY) {
		super(representationSize, spawningLocationX, spawningLokationY, Color.GREEN);
		this.setEddible(true);
	}

}
