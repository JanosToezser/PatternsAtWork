package objects.animals;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import objects.GameObject;
import states.ExploringState;
import states.State;
import strategies.movementstrategies.MovementStrategy;
import strategies.movementstrategies.SimpleHareMovementStrategy;

public class SimpleAnimal extends GameObject {

	private MovementStrategy simpleMovementStrategy;
	private HashMap<GameObject, Point> locationOfPreviouslyDiscoveredFood = new HashMap<GameObject, Point>();

	private int nextLocationX;
	private int nextLocationY;

	private State currentState;

	private int hunger;
	private int fatigue;
	private boolean isFeeding = false;
	private boolean hasNextTarget = false;

	private GameObject target;

	private int maxRestingDuration;
	private int maxExploringDuration;
	private int maxMatingDuration;
	private int maxTollerableHungerValue;
	private int maxTollerableFatigue;

	public SimpleAnimal(int representationSize, String name, int spawningLocationX,
			int spawningLokationY, Color color, SimpleHareMovementStrategy simpleMovementStrategy) {
		super(representationSize, name, spawningLocationX, spawningLokationY, color);
		this.setSimpleMovementStrategy(simpleMovementStrategy);
		this.currentState = new ExploringState();
	}

	public int getNextLocationX() {
		return nextLocationX;
	}

	public void setNextLocationX(int nextLocationX) {
		this.nextLocationX = nextLocationX;
	}

	public int getNextLocationY() {
		return nextLocationY;
	}

	public void setNextLocationY(int nextLocationY) {
		this.nextLocationY = nextLocationY;
	}

	public HashMap<GameObject, Point> getLocationOfPreviouslyDiscoveredFood() {
		return locationOfPreviouslyDiscoveredFood;
	}

	public Point findFood(ArrayList<Point> knownFoodLocations, Point currentLocation) {
		return getSimpleMovementStrategy().findFood(knownFoodLocations, currentLocation);
	};

	public Point flee(GameObject pursuer, Point currentLocation) {
		return getSimpleMovementStrategy().flee(pursuer, currentLocation);
	};

	public Point hide(ArrayList<Point> knownHideoutLocations, Point currentLocation) {
		return getSimpleMovementStrategy().hide(knownHideoutLocations, currentLocation);
	};

	public void explore(Collection<Object> nonMovingGameObjects) {
		getSimpleMovementStrategy().explore(nonMovingGameObjects,
				new Point(this.getCurrentX(), this.getCurrentY()));
	}

	public State getCurrentState() {
		return this.currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	public int getMaxRestingDuration() {
		return maxRestingDuration;
	}

	public void setMaxRestingDuration(int maxRestingDuration) {
		this.maxRestingDuration = maxRestingDuration;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getMaxTollerableHungerValue() {
		return maxTollerableHungerValue;
	}

	public void setMaxTollerableHungerValue(int maxTollerableHungerValue) {
		this.maxTollerableHungerValue = maxTollerableHungerValue;
	}

	public int getMaxMatingDuration() {
		return maxMatingDuration;
	}

	public void setMaxMatingDuration(int maxMatingDuration) {
		this.maxMatingDuration = maxMatingDuration;
	}

	public int getMaxExploringDuration() {
		return maxExploringDuration;
	}

	public void setMaxExploringDuration(int maxExploringDuration) {
		this.maxExploringDuration = maxExploringDuration;
	}

	public int getFatigue() {
		return fatigue;
	}

	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	public int getMaxTollerableFatigue() {
		// TODO Auto-generated method stub
		return this.maxTollerableFatigue;
	}

	public void setMaxTollerableFatigue(int maxTollerableFatigue) {
		this.maxTollerableFatigue = maxTollerableFatigue;
	}

	public MovementStrategy getSimpleMovementStrategy() {
		return simpleMovementStrategy;
	}

	public void setSimpleMovementStrategy(MovementStrategy simpleMovementStrategy) {
		this.simpleMovementStrategy = simpleMovementStrategy;
	}

	public boolean isFeeding() {
		return isFeeding;
	}

	public void setFeeding(boolean isFeeding) {
		this.isFeeding = isFeeding;
	}

	public boolean hasNextTarget() {
		return hasNextTarget;
	}

	public void setHasNextTarget(boolean hasNextTarget) {
		this.hasNextTarget = hasNextTarget;
	}

	public GameObject getTarget() {
		return target;
	}

	public void setTarget(GameObject nextTarget) {
		this.target = nextTarget;
	};
}
