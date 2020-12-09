package objects.objectsutility;

import java.util.concurrent.ThreadLocalRandom;

import objects.plants.Plant;
import objects.plants.eddibleplants.Kale;

public class GameObjectCreator {

	public static Plant createKale() {
		return new Kale(ThreadLocalRandom.current().nextInt(3, 8), "NewKale",
				ThreadLocalRandom.current().nextInt(0, 321),
				ThreadLocalRandom.current().nextInt(0, 321));

	}

}
