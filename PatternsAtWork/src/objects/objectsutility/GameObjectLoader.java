package objects.objectsutility;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import objects.animals.SimpleAnimal;
import objects.animals.herbivore.SimpleHare;
import objects.plants.eddibleplants.Kale;
import strategies.movementstrategies.SimpleHareMovementStrategy;

public class GameObjectLoader {

	/*
	 * For now this will be a simple implementation loading objects that are defined
	 * in an external .csv file. Later on this should be replaced with some sort of
	 * web functionality and the objects should be stored and loaded in/from a
	 * database.
	 */

	public static Collection<Object> getMovingGameObjects() {

		Collection<Object> movingGameObjects = Collections
				.synchronizedCollection(new ArrayList<>());
		String pathToCsv = new String(
				"C:\\Users\\jt\\git\\PatternsAtWork\\PatternsAtWork\\resources\\gameobjects.csv");

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
			String row;
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");

				if (data[0].equals("HARE")) {
					SimpleHareMovementStrategy movementStrategy = new SimpleHareMovementStrategy();
					SimpleAnimal animal = new SimpleHare(10, data[1], Integer.parseInt(data[2]),
							Integer.parseInt(data[3]), Color.GRAY, movementStrategy);
					movementStrategy.setAnimal(animal);
					movingGameObjects.add(animal);
					animal.setNextLocationX(-1);
					animal.setNextLocationY(-1);

				}
			}
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movingGameObjects;
	}

	public static Collection<Object> getNonMovingGameObjects() {
		Collection<Object> stillGameObjects = Collections.synchronizedCollection(new ArrayList<>());
		String pathToCsv = new String(
				"C:\\Users\\jt\\git\\PatternsAtWork\\PatternsAtWork\\resources\\gameobjects.csv");

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
			String row;
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");

				if (data[0].equals("KALE")) {
					stillGameObjects.add(new Kale(5, data[1], Integer.parseInt(data[2]),
							Integer.parseInt(data[3])));
				}
			}
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stillGameObjects;
	}

}
