package strategies.movementstrategies;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import objects.GameObject;
import objects.animals.SimpleAnimal;
import objects.plants.Plant;

public class SimpleHareMovementStrategy implements MovementStrategy {

	private SimpleAnimal animal;

	@Override
	public Point findFood(ArrayList<Point> knownFoodLocations, Point currentLocation) {
		int closestFoodDistance = Integer.MAX_VALUE;
		Point closestFoodLocation = null; // Caller must handle null. Should initialize exploration.

		for (Point foodLocation : knownFoodLocations) {
			if ((Math.abs(foodLocation.x - currentLocation.x))
					+ (Math.abs(foodLocation.y - currentLocation.y)) < closestFoodDistance) {
				closestFoodDistance = foodLocation.x + foodLocation.y;
				closestFoodLocation = foodLocation;
			}
		}
		return closestFoodLocation;
	}

	@Override
	public Point flee(GameObject pursuer, Point currentLocation) {
		int fleeingX = currentLocation.x;
		int fleeingY = currentLocation.y;

		if (pursuer.getCurrentX() < currentLocation.x) {
			fleeingX = currentLocation.x + 100;
		} else {
			fleeingX = currentLocation.x - 100;

		}

		if (pursuer.getCurrentY() < currentLocation.y) {
			fleeingX = currentLocation.y + 100;
		} else {
			fleeingX = currentLocation.y - 100;

		}

		return new Point(fleeingX, fleeingY);
	}

	@Override
	public Point hide(ArrayList<Point> knownHideoutLocations, Point currentLocation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void explore(Collection<Object> nonMovingObjects, Point currentLocation) {
		int distanceToAnimal = Integer.MAX_VALUE;

		for (Object plant : nonMovingObjects) {
			Plant currentPlant = (Plant) plant;
			distanceToAnimal = Math.abs(currentPlant.getCurrentX() - this.animal.getCurrentX()
					+ Math.abs(currentPlant.getCurrentY() - this.animal.getCurrentY()));
			if (distanceToAnimal < 45) {
				this.animal.getLocationOfPreviouslyDiscoveredFood().put(currentPlant,
						new Point(currentPlant.getCurrentX(), currentPlant.getCurrentY()));
			}
			distanceToAnimal = Integer.MAX_VALUE;
		}
	}

	public SimpleAnimal getAnimal() {
		return animal;
	}

	public void setAnimal(SimpleAnimal animal) {
		this.animal = animal;
	}

}
