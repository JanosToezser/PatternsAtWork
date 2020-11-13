package objects.animals.herbivore;

import java.awt.Color;

import objects.animals.Animal;
import strategies.feedstrategies.FeedingStrategy;
import strategies.interactionstrategies.InteractionStrategy;
import strategies.movementstrategies.MovementStrategy;
import strategies.reproductiostrategies.ReproductionStrategy;
import strategies.restingstrategies.RestingStrategy;

public class Hare extends Animal {

	/**
	 * @param spawningLocationX
	 * @param spawningLokationY
	 * @param representationSize
	 * @param color
	 * @param maxHealth
	 * @param currentHealth
	 * @param maxAge
	 * @param currentAge
	 * @param hunger
	 * @param heat
	 * @param preyValueQuotient
	 * @param name
	 * @param representation
	 * @param feedingStrategy
	 * @param restingStrategy
	 * @param movementStragegy
	 * @param reproductionStrategy
	 * @param interactionStrategy
	 */
	public Hare(int spawningLocationX, int spawningLokationY, int representationSize, Color color,
			int maxHealth, int currentHealth, int maxAge, int currentAge, int hunger, boolean heat,
			int preyValueQuotient, String name, String representation,
			FeedingStrategy feedingStrategy, RestingStrategy restingStrategy,
			MovementStrategy movementStragegy, ReproductionStrategy reproductionStrategy,
			InteractionStrategy interactionStrategy) {
		super(spawningLocationX, spawningLokationY, representationSize, color, maxHealth,
				currentHealth, maxAge, currentAge, hunger, heat, preyValueQuotient, name,
				representation, feedingStrategy, restingStrategy, movementStragegy,
				reproductionStrategy, interactionStrategy);
		// TODO Auto-generated constructor stub
	}

}
