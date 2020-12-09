package objects.plants.eddibleplants;

import java.awt.Color;

import objects.plants.Plant;

public class Kale extends Plant {

	public Kale(int representationSize, String name, int spawningLocationX, int spawningLokationY) {
		super(representationSize, name, spawningLocationX, spawningLokationY, Color.GREEN);
		this.setEddible(true);
	}

}
