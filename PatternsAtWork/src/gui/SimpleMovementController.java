package gui;

import java.awt.Color;
import java.awt.Point;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.SwingUtilities;

import objects.GameObject;
import objects.animals.SimpleAnimal;
import objects.animals.herbivore.SimpleHare;
import objects.objectsutility.GameObjectCreator;
import objects.plants.Plant;
import states.ExploringState;
import states.ForagingState;
import states.RestingState;
import states.State;

public class SimpleMovementController implements Runnable {

	private Collection<Object> movingGameObjects;
	private Collection<Object> nonMovingGameObjects;

	private SimpleGUI gui;

	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

	@SuppressWarnings("unchecked")
	public SimpleMovementController(SimpleGUI simpleGUI, Collection<Object> movingGameObjects,
			Collection<Object> nonMovingGameObjects) {
		this.gui = simpleGUI;
		this.movingGameObjects = movingGameObjects;
		this.nonMovingGameObjects = nonMovingGameObjects;

		executor.scheduleAtFixedRate(() -> {
			updateObjects();
			repaint();
		}, 0, 25, TimeUnit.MILLISECONDS);
	}

	@Override
	public void run() {
	}

	// TODO Use random intervals for x and y movement to make it look more natural
	// TODO Try to use quotient of the target points x/y coordinates for movement so
	// that the movement looks smoother when extreme difference between x and y

	private void updateObjects() {
		// TODO The game objects should decide themselves which point will be the next
		// they "want" to move to.

		for (Object animal : this.movingGameObjects) {

			// Make sure that everything that doesn't move is allowed not to. Make
			// everything move that is not allowed to not move.
			if (animal instanceof SimpleAnimal) {

				SimpleAnimal currentSimpleAnimal = (SimpleAnimal) animal;

				State currentState = currentSimpleAnimal.getCurrentState();

				// TODO Implement all other states later. For now we rest, forage or explore!
				if (currentState instanceof RestingState) {
					currentSimpleAnimal.setFatigue(currentSimpleAnimal.getFatigue() - 1);
					currentSimpleAnimal.setHunger(currentSimpleAnimal.getHunger() + 1);

					// Check if resting is allowed
					if (currentSimpleAnimal.getFatigue() < 1) {
						currentSimpleAnimal.setTarget(null);
						// For now only check against hunger. Must be expanded later on.
						if (currentSimpleAnimal.getHunger() > currentSimpleAnimal
								.getMaxTollerableHungerValue()) {
							currentSimpleAnimal.setCurrentState(new ForagingState());
							currentSimpleAnimal.setColor(Color.WHITE);
						} else {
							currentSimpleAnimal.setCurrentState(new ExploringState());
							currentSimpleAnimal.setColor(Color.CYAN);
						}
					}
				} else if (currentState instanceof ForagingState) {
					// Feeding on current Food.
					// TODO Make food not infinite!!!
					// Animal is full and should start exploring
					if (currentSimpleAnimal.getHunger() <= 0) {
						currentSimpleAnimal.setCurrentState(new ExploringState());
						currentSimpleAnimal.setColor(Color.CYAN);
						currentSimpleAnimal.setHasNextTarget(false);
						currentSimpleAnimal.setFeeding(false);
						continue;
					}

					// If we are at food and are feeding continue.
					if ((currentSimpleAnimal.hasNextTarget())
							&& currentSimpleAnimal.getTarget() != null
							&& currentSimpleAnimal.isFeeding()) {
						// TODO Need to differentiate for herbivores and carnivores later
						Plant target = ((Plant) currentSimpleAnimal.getTarget());
						target.setHealthPoints(target.getHealthPoints() - 10);
						currentSimpleAnimal.setHunger(currentSimpleAnimal.getHunger() - 100);
						if (target.getHealthPoints() <= 0) {
							currentSimpleAnimal.getLocationOfPreviouslyDiscoveredFood()
									.remove(target);
							currentSimpleAnimal.setHasNextTarget(false);
							currentSimpleAnimal.setFeeding(false);
							currentSimpleAnimal.setTarget(null);
							synchronized (nonMovingGameObjects) {
								this.nonMovingGameObjects.remove(target);
								if (ThreadLocalRandom.current().nextInt(0, 10) < 4) {
									this.nonMovingGameObjects.add(GameObjectCreator.createKale());
								}
							}

						}

						continue;
					}
					// Else find food if there are entries in the list
					else if ((!currentSimpleAnimal.getLocationOfPreviouslyDiscoveredFood()
							.isEmpty()) && (!currentSimpleAnimal.isFeeding())
							&& (currentSimpleAnimal.getTarget() == null)) {
						GameObject closestFood = findClosestFood(currentSimpleAnimal);
						Point nextKnownLocationForFood = findClosestLocationForFood(closestFood);

						currentSimpleAnimal.setNextLocationX(nextKnownLocationForFood.x);
						currentSimpleAnimal.setNextLocationY(nextKnownLocationForFood.y);
						currentSimpleAnimal.setHasNextTarget(true);
						currentSimpleAnimal.setTarget(closestFood);
						continue;
					}
					// If there are no entries in the list change state to exploring
					else if (currentSimpleAnimal.getLocationOfPreviouslyDiscoveredFood()
							.isEmpty()) {
						currentSimpleAnimal.setCurrentState(new ExploringState());
						currentSimpleAnimal.setColor(Color.CYAN);
						continue;
					}
					// TODO Else when arriving at food location but there is no food
					else if ((currentSimpleAnimal.hasNextTarget())
							&& currentSimpleAnimal.getTarget() != null
							&& (!currentSimpleAnimal.isFeeding()
									&& (currentSimpleAnimal.getCurrentX() == currentSimpleAnimal
											.getNextLocationX())
									&& (currentSimpleAnimal.getCurrentY() == currentSimpleAnimal
											.getNextLocationY()))) {
						currentSimpleAnimal.setFeeding(true);
						continue;
					}
					// Else when arriving at food location start feeding
					else if ((currentSimpleAnimal.hasNextTarget())
							&& currentSimpleAnimal.getTarget() != null
							&& (!currentSimpleAnimal.isFeeding()
									&& (currentSimpleAnimal.getCurrentX() == currentSimpleAnimal
											.getNextLocationX())
									&& (currentSimpleAnimal.getCurrentY() == currentSimpleAnimal
											.getNextLocationY()))) {
						currentSimpleAnimal.setFeeding(true);
						continue;
					} else {
						if (currentSimpleAnimal.getCurrentX() < currentSimpleAnimal
								.getNextLocationX()) {
							currentSimpleAnimal.move(currentSimpleAnimal.getCurrentX() + 1,
									currentSimpleAnimal.getCurrentY());
						} else if (currentSimpleAnimal.getCurrentX() > currentSimpleAnimal
								.getNextLocationX()) {
							currentSimpleAnimal.move(currentSimpleAnimal.getCurrentX() - 1,
									currentSimpleAnimal.getCurrentY());
						}
						if (currentSimpleAnimal.getCurrentY() < currentSimpleAnimal
								.getNextLocationY()) {
							currentSimpleAnimal.move(currentSimpleAnimal.getCurrentX(),
									currentSimpleAnimal.getCurrentY() + 1);
						} else if (currentSimpleAnimal.getCurrentY() > currentSimpleAnimal
								.getNextLocationY()) {
							currentSimpleAnimal.move(currentSimpleAnimal.getCurrentX(),
									currentSimpleAnimal.getCurrentY() - 1);
						}
					}

				} else if (currentState instanceof ExploringState) {
//TODO Not sure if hunger should affect the exploration duration ... Should use fatigue 
//					if (currentSimpleAnimal.getHunger() > currentSimpleAnimal
//							.getMaxTollerableHungerValue()) {
//						currentSimpleAnimal.setCurrentState(new ForagingState());
//					}
					currentSimpleAnimal.setFatigue(currentSimpleAnimal.getFatigue() + 1);
					if ((currentSimpleAnimal.getFatigue() > currentSimpleAnimal
							.getMaxTollerableFatigue())) {
						currentSimpleAnimal.setHasNextTarget(false);
						currentSimpleAnimal.setCurrentState(new RestingState());
						currentSimpleAnimal.setColor(Color.YELLOW);
						continue;
					}
					// Determine if we already are moving somewhere.
					if (!currentSimpleAnimal.hasNextTarget()) {
						// Move to a new random location and check on the way if food is nearby.
						currentSimpleAnimal.setHasNextTarget(true);
						currentSimpleAnimal
								.setNextLocationX(ThreadLocalRandom.current().nextInt(0, 777));
						currentSimpleAnimal
								.setNextLocationY(ThreadLocalRandom.current().nextInt(0, 777));

					}
					((SimpleHare) currentSimpleAnimal).explore(this.nonMovingGameObjects);

				}
				if (!(currentSimpleAnimal.getCurrentState() instanceof RestingState)) {
					if (currentSimpleAnimal.getCurrentX() < currentSimpleAnimal
							.getNextLocationX()) {
						currentSimpleAnimal.move(currentSimpleAnimal.getCurrentX() + 1,
								currentSimpleAnimal.getCurrentY());
					} else if (currentSimpleAnimal.getCurrentX() > currentSimpleAnimal
							.getNextLocationX()) {
						currentSimpleAnimal.move(currentSimpleAnimal.getCurrentX() - 1,
								currentSimpleAnimal.getCurrentY());
					}
					if (currentSimpleAnimal.getCurrentY() < currentSimpleAnimal
							.getNextLocationY()) {
						currentSimpleAnimal.move(currentSimpleAnimal.getCurrentX(),
								currentSimpleAnimal.getCurrentY() + 1);
					} else if (currentSimpleAnimal.getCurrentY() > currentSimpleAnimal
							.getNextLocationY()) {
						currentSimpleAnimal.move(currentSimpleAnimal.getCurrentX(),
								currentSimpleAnimal.getCurrentY() - 1);
					}
				}
			}
		}
	}

	private GameObject findClosestFood(SimpleAnimal currentSimpleAnimal) {
		int distanceToUndercut = Integer.MAX_VALUE;
		int currentLocationSum = currentSimpleAnimal.getCurrentX()
				+ currentSimpleAnimal.getCurrentY();
		GameObject closestFood = null;

		for (GameObject knownFood : currentSimpleAnimal.getLocationOfPreviouslyDiscoveredFood()
				.keySet()) {
			int currentKnownFoodLocationSum = knownFood.getCurrentX() + knownFood.getCurrentY();
			if (Math.abs(currentLocationSum - currentKnownFoodLocationSum) < distanceToUndercut) {
				distanceToUndercut = currentKnownFoodLocationSum;
				closestFood = knownFood;
			}
		}

		return closestFood;
	}

	private Point findClosestLocationForFood(GameObject closestFood) {

		return new Point(closestFood.getCurrentX(), closestFood.getCurrentY());
	}

	private void repaint() {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				gui.repaintDrawingPanel();
			}
		});
	}
}