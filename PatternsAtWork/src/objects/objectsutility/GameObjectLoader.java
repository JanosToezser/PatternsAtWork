package objects.objectsutility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import objects.GameObject;

public class GameObjectLoader {

	/*
	 * For now this will be a simple implementation loading objects that are defined
	 * in an external .csv file. Later on this should be replaced with some sort of
	 * web functionality and the objects should be stored and loaded in/from a
	 * database.
	 */

	public static Collection<GameObject> getGameObjects() {

		ArrayList<GameObject> gameObjects = new ArrayList<>();
		String pathToCsv = new String("");

		try {
			BufferedReader csvReader = new BufferedReader(new FileReader(
					"C:\\Users\\jt\\eclipse-workspace\\PatternsAtWork\\resources\\gameobjects.csv"));
			String row;
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				System.out.println(data);

				// Get GameObject info

				// Create new matching GameObject with info

				// Put GameObject into ArrayList
			}
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gameObjects;
	}

}
