package objects.animals;

import java.awt.Color;

import objects.GameObject;
import states.RestingState;
import strategies.feedstrategies.FeedingStrategy;
import strategies.interactionstrategies.InteractionStrategy;
import strategies.movementstrategies.MovementStrategy;
import strategies.reproductiostrategies.ReproductionStrategy;
import strategies.restingstrategies.RestingStrategy;

public class Animal extends GameObject {
	private int maxHealth;
	private int currentHealth;
	private int maxAge;
	private int currentAge;
	private int currentX;
	private int currentY;
	private int nextX;
	private int nextY;
	private int hunger;
	private boolean heat;
	private int preyValueQuotient;
	private String name;
	private String representation;
	private FeedingStrategy feedingStrategy;
	private RestingStrategy restingStrategy;
	private MovementStrategy movementStragegy;
	private ReproductionStrategy reproductionStrategy;
	private InteractionStrategy interactionStrategy;

	/**
	 * @param spawningLocationX:    X location on the map where new instance is
	 *                              created.
	 * @param spawningLokationY:    Y location on the map where new instance is
	 *                              created.
	 * @param representationSize:   Size of instance when created.
	 * @param color:                Color of instance when created.
	 * @param maxHealth:            The maximum health an animal of a given species
	 *                              can reach when adult.
	 * @param currentHealth:        The current health of an animal, given the age
	 *                              and hunger values.
	 * @param maxAge:               The maximum age of an animal.
	 * @param currentAge:           The current age of an animal.
	 * @param hunger:               The current hunger level of an animal.
	 * @param heat:                 Boolean if animal is in heat or not.
	 * @param preyValueQuotient:    The resource value that can be gained from this
	 *                              animal when preyed upon.
	 * @param name:                 The name ... everyone need one :)
	 * @param representation:       The letters with which the animal type gets
	 *                              represented on the map.
	 * @param feedingStrategy:      What and how the animal eats.
	 * @param restingStrategy:      How the animal rests/recreates.
	 * @param movementStragegy:     how the animal moves in different situations.
	 * @param reproductionStrategy: How and when an animal reproduces.
	 * @param interactionStrategy:  How the animal interacts with other animals.
	 */

	public Animal(int representationSize, String name, int spawningLocationX, int spawningLokationY,
			Color color, int maxHealth, int currentHealth, int maxAge, int currentAge, int hunger,
			boolean heat, int preyValueQuotient, String representation,
			FeedingStrategy feedingStrategy, RestingStrategy restingStrategy,
			MovementStrategy movementStragegy, ReproductionStrategy reproductionStrategy,
			InteractionStrategy interactionStrategy) {
		super(representationSize, name, spawningLocationX, spawningLokationY, color);
		this.maxHealth = maxHealth;
		this.currentHealth = currentHealth;
		this.maxAge = maxAge;
		this.currentAge = currentAge;
		this.hunger = hunger;
		this.heat = heat;
		this.preyValueQuotient = preyValueQuotient;
		this.name = name;
		this.representation = representation;
		this.feedingStrategy = feedingStrategy;
		this.restingStrategy = restingStrategy;
		this.movementStragegy = movementStragegy;
		this.reproductionStrategy = reproductionStrategy;
		this.interactionStrategy = interactionStrategy;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}

	public void setCurrentAge(int currentAge) {
		this.currentAge = currentAge;
	}

	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public void setHeat(boolean heat) {
		this.heat = heat;
	}

	public void setPreyValueQuotient(int preyValueQuotient) {
		this.preyValueQuotient = preyValueQuotient;
	}

	public int getNextX() {
		return nextX;
	}

	public void setNextX(int nextX) {
		this.nextX = nextX;
	}

	public int getNextY() {
		return nextY;
	}

	public void setNextY(int nextY) {
		this.nextY = nextY;
	}

	public int getMaxHealth() {
		return maxHealth;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public int getCurrentAge() {
		return currentAge;
	}

	public int getCurrentX() {
		return currentX;
	}

	public int getCurrentY() {
		return currentY;
	}

	public int getHunger() {
		return hunger;
	}

	public boolean isHeat() {
		return heat;
	}

	public int getPreyValueQuotient() {
		return preyValueQuotient;
	}

	public String getName() {
		return name;
	}

	public String getRepresentation() {
		return representation;
	}

	public FeedingStrategy getFeedingStrategy() {
		return feedingStrategy;
	}

	public RestingStrategy getRestingStrategy() {
		return restingStrategy;
	}

	public MovementStrategy getMovementStragegy() {
		return movementStragegy;
	}

	public ReproductionStrategy getReproductionStrategy() {
		return reproductionStrategy;
	}

	public InteractionStrategy getInteractionStrategy() {
		return interactionStrategy;
	}

	public RestingState getCurrentState() {
		// TODO Auto-generated method stub
		return null;
	}

}
