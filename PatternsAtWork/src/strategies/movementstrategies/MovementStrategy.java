package strategies.movementstrategies;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;

import objects.GameObject;

public interface MovementStrategy {

	public Point findFood(ArrayList<Point> knownFoodLocations, Point currentLocation);

	public Point flee(GameObject pursuer, Point currentLocation);

	public Point hide(ArrayList<Point> knownHideoutLocations, Point currentLocation);

	public void explore(Collection<Object> nonMovingObjects, Point currentLocation);
}
