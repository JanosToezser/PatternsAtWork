package objects.animals.herbivore;

import java.awt.Color;
import java.awt.Point;
import java.util.Collection;

import objects.animals.SimpleAnimal;
import strategies.movementstrategies.SimpleHareMovementStrategy;

public class SimpleHare extends SimpleAnimal {

	public SimpleHare(int representationSize, String name, int spawningLocationX,
			int spawningLokationY, Color color, SimpleHareMovementStrategy simpleMovementStrategy) {
		super(representationSize, name, spawningLocationX, spawningLokationY, color,
				simpleMovementStrategy);
		this.setHunger(0);
		this.setFatigue(0);

		this.setMaxRestingDuration(Integer.MAX_VALUE);
		this.setMaxExploringDuration(Integer.MAX_VALUE);
		this.setMaxMatingDuration(Integer.MAX_VALUE);
		this.setMaxTollerableHungerValue(11);
		this.setMaxTollerableFatigue(22);
	}

	@Override
	public void explore(Collection<Object> nonMovingGameObjects) {
		((SimpleHareMovementStrategy) getSimpleMovementStrategy()).explore(nonMovingGameObjects,
				new Point(this.getCurrentX(), this.getCurrentY()));
	}

}
